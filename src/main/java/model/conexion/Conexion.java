package model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
  public static final String NOMBRE_BASE_DATOS = "gestion_preder";
  public static final String USER_BASE_DATOS = "gestorpreder";
  public static final String PASS_BASE_DATOS = "gestor1234";

  private static Connection connection = null;

  private Conexion() throws SQLException {

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager
              .getConnection("jdbc:mysql://localhost:3306/" + NOMBRE_BASE_DATOS, USER_BASE_DATOS, PASS_BASE_DATOS);

    } catch (ClassNotFoundException e) {
      System.out.println("Error al conectar a la base de datos: " + e.getMessage());
    }

  }

  public static Connection getConnection() throws SQLException {
    if (connection == null) {
      new Conexion();
    }
    return connection;

  }

}


