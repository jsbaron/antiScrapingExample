package repositories;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlExceptionLogger {
  private SqlExceptionLogger() {
  }

  public static void log(SQLException e) {
    Logger lgr = Logger.getLogger(SqlExceptionLogger.class.getName());
    lgr.log(Level.SEVERE, e.getMessage(), e);
  }
}
