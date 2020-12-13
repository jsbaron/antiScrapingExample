package datasources;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

public class EventLogDataSource {
  private static final PoolProperties properties = new PoolProperties();
  private static final DataSource dataSource = new DataSource();
  private static final String JDBC_URL = "jdbc:mysql://cs6760-project-db.cwzy8anfsscs.us-east-1.rds.amazonaws.com:3306/eventlogs?useSSL=False";
  private static final String DRIVER_STRING = "com.mysql.cj.jdbc.Driver";
  private static final String USERNAME = "admin";
  private static final String PASSWORD = "admin123";

  static {
    properties.setUrl(JDBC_URL);
    properties.setUsername(USERNAME);
    properties.setPassword(PASSWORD);
    properties.setDriverClassName(DRIVER_STRING);
    properties.setMaxActive(100);
    properties.setMinIdle(10);
    properties.setInitialSize(10);
    properties.setRemoveAbandonedTimeout(5000);
    properties.setRemoveAbandoned(true);
    dataSource.setPoolProperties(properties);
  }

  private EventLogDataSource() {}

  public static Connection getDataSourceConnection() throws SQLException {
    return  dataSource.getConnection();
  }
}
