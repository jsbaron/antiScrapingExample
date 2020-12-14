package repositories;

import datasources.EventLogDataSource;

import java.sql.*;

public class EventLogRepository {
  private static final String SHOULD_ENFORCE = "should_enforce";

  private static EventLogRepository repo = null;

  private EventLogRepository() {
  }

  public static EventLogRepository getRepo() {
    if (repo == null) {
      repo = new EventLogRepository();
    }
    return repo;
  }

  public void insertEventLog(String ip, String event, String target, Timestamp date) throws SQLException {
    String insertEventLog = "INSERT INTO `eventlogs`.event_logs(ip, event, target, date) VALUES(?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;

    try {
      connection = EventLogDataSource.getDataSourceConnection();
      insertStmt = connection.prepareStatement(insertEventLog);
      insertStmt.setString(1, ip);
      insertStmt.setString(2, event);
      insertStmt.setString(3, target);
      insertStmt.setTimestamp(4, date);
      insertStmt.executeUpdate();
    } catch (SQLException e) {
      if (e.getErrorCode() != 1062) {
        throw e;
      }
    } finally {
      close(connection, insertStmt, null);
    }
  }


  private boolean shouldEnforce(String ip, String query) throws SQLException {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet resultSet = null;
    int shouldEnforce = 0;
    try {
      con = EventLogDataSource.getDataSourceConnection();
      pst = con.prepareStatement(query);
      pst.setString(1, ip);
      resultSet = pst.executeQuery();
      if (resultSet.next()) {
        shouldEnforce = resultSet.getInt(SHOULD_ENFORCE);
      }
    } catch (SQLException e) {
      SqlExceptionLogger.log(e);
    } finally {
      close(con, pst, resultSet);
    }
    return shouldEnforce == 1;
  }

  public boolean requestsEveryMinute(String ip) throws SQLException {
    return shouldEnforce(
        ip,
        "SELECT " +
            "    EXISTS( SELECT " +
            "ip" +
            " FROM (" +
            " SELECT" +
            " ip, " +
            " date, " +
            " count(coalesce(diff, 1)=1 OR null OR -59) OVER (PARTITION BY ip ORDER BY date) seq " +
            " from ( " +
            " SELECT " +
            " ip, " +
            " date, " +
            " minute(date) - lag(minute(date)) OVER (PARTITION BY ip ORDER BY date) AS diff" +
            " FROM `eventlogs`.event_logs " +
            " ) as lags " +
            " ) as seqs " +
            " where ip = ?" +
            " having max(seq) > 100) AS should_enforce"
        );
  }

  public boolean hasHighTrafficVolume(String ip) throws SQLException {
    return shouldEnforce(ip,
        "SELECT " +
          "    EXISTS( SELECT " +
          "            ip," +
          "                COUNT(*) AS num_requests," +
          "                UNIX_TIMESTAMP(date) DIV 3600 AS hour_interval" +
          "        FROM" +
          "            `eventlogs`.event_logs" +
          "        WHERE" +
          "            ip = ? "+
          "        GROUP BY UNIX_TIMESTAMP(date) DIV 3600 , ip" +
          "        HAVING COUNT(*) > 1000) AS should_enforce");
  }

  public boolean hasBadUserAgent(String userAgent) throws SQLException {
    return shouldEnforce(
        userAgent,
        "SELECT EXISTS( " +
            " select " +
            " * " +
            " from `eventlogs`.bad_user_agents " +
            "        where ? like CONCAT('%', user_agent_string, '%') " +
            ") as should_enforce"
        );
  }

  public boolean hasBadIp(String ip) throws SQLException {
    return shouldEnforce(
        ip,
        "SELECT EXISTS( " +
            " select " +
            " * " +
            " from `eventlogs`.bad_ips " +
            "        where ? = ip_address " +
            ") as should_enforce"
    );
  }

  public void insertBadIp(String ip) throws SQLException {
    String insertBadIpAddress = "INSERT INTO `eventlogs`.bad_ips(ip_address) VALUES(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;

    try {
      connection = EventLogDataSource.getDataSourceConnection();
      insertStmt = connection.prepareStatement(insertBadIpAddress);
      insertStmt.setString(1, ip);
      insertStmt.executeUpdate();
    } catch (SQLException e) {
      if (e.getErrorCode() != 1062) {
        throw e;
      }
    } finally {
      close(connection, insertStmt, null);
    }
  }


  public static void close(Connection connection, PreparedStatement statement, ResultSet results) throws SQLException {
    if (connection != null) {
      connection.close();
    }
    if (statement != null) {
      statement.close();
    }
    if (results != null) {
      results.close();
    }
  }
}
