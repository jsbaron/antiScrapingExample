package repositories;

import datasources.UserDataSource;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

  private static UserRepository repo = null;

  private static final Integer NUM_USERS_PER_PAGE = 10;

  private UserRepository() {
  }

  public static UserRepository getRepo() {
    if (repo == null) {
      repo = new UserRepository();
    }
    return repo;
  }

  private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
    return new User(
        resultSet.getInt(1),
        resultSet.getString(2),
        resultSet.getString(3),
        resultSet.getString(4),
        resultSet.getString(5),
        resultSet.getDate(6),
        resultSet.getString(7),
        resultSet.getString(8)
    );
  }

  public List<User> getTweetsByPage(Integer page) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        try {
          con = UserDataSource.getDataSourceConnection();
          pst = con.prepareStatement(
              "select" +
                  " unitid, description, name, text, tweet_coord, tweet_created, tweet_location, user_timezone " +
                  "from users " +
                  "order by tweet_created " +
                  "limit "+ NUM_USERS_PER_PAGE + " offset ?"
          );
          pst.setInt(1, (page - 1) * NUM_USERS_PER_PAGE);
          resultSet = pst.executeQuery();
          while (resultSet.next()) {
            users.add(getUserFromResultSet(resultSet));
          }
        } catch (SQLException e) {
          SqlExceptionLogger.log(e);
        } finally {
          closeConnections(con, pst, resultSet);
        }
        return users;
  }

  private void closeConnections(Connection con, PreparedStatement pst, ResultSet resultSet) {
    try {
      if (con != null) {
        con.close();
      }
      if (pst != null) {
        pst.close();
      }
      if (resultSet != null) {
        resultSet.close();
      }
    } catch (SQLException e) {
      SqlExceptionLogger.log(e);
    }
  }
}
