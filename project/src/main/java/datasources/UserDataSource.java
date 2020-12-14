package datasources;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDataSource {

  private static final PoolProperties properties = new PoolProperties();
  private static final DataSource dataSource = new DataSource();
  private static final String JDBC_URL = "YOUR_JDBC_URL_HERE";
  private static final String DRIVER_STRING = "YOUR_DRIVER_STRING_HERE";
  private static final String USERNAME = "";
  private static final String PASSWORD = "";

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

  private UserDataSource() {}

  public static Connection getDataSourceConnection() throws SQLException {
    return  dataSource.getConnection();
  }

  public static void closeConnection() throws SQLException {
    dataSource.close();
  }
}
