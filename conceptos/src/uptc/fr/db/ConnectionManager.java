package uptc.fr.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class ConnectionManager {
  private static Connection connection;

  public static Connection getConnection() throws SQLException {
    if (connection == null) {
      DriverManager.registerDriver(new OracleDriver());
      connection = DriverManager.getConnection("jdbc:oracle:thin:@10.4.74.22:1521/XE", "conceptos", "admin1234");
    }

    return connection;
  }
}
