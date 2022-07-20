package model.DAO;

import model.conexion.Conexion;
import model.entity.Capacitacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CapacitacionDAO implements ICapacitacionDAO {

  @Override
  public void add(Capacitacion c) throws SQLException {

    String sql = "INSERT INTO capacitacion (rut_cliente, dia, hora, lugar, duracion, asistentes) VALUES (?, ?, ?, ? , ?, ?)";


    Connection connection = Conexion.getConnection();

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, c.getRutCliente());
    statement.setString(2, c.getDia());
    statement.setString(3, c.getHora());
    statement.setString(4, c.getLugar());
    statement.setString(5, c.getDuracion());
    statement.setInt(6, c.getAsistentes());

    statement.execute();
  }

  @Override
  public List<Capacitacion> readAll() throws SQLException {
    List<Capacitacion> listaCapas = new ArrayList<>();

    String sql = "SELECT id_capa, rut_cliente, dia, hora, lugar, duracion, asistentes FROM capacitacion";

    Connection connection = Conexion.getConnection();

    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idCapa = resultSet.getInt("id_capa");
      String rutCliente = resultSet.getString("rut_cliente");
      String dia = resultSet.getString("dia");
      String hora = resultSet.getString("hora");
      String lugar = resultSet.getString("lugar");
      String duracion = resultSet.getString("duracion");
      int asistentes = resultSet.getInt("asistentes");

      Capacitacion capa = new Capacitacion(idCapa, rutCliente, dia, hora, lugar, duracion, asistentes);
      listaCapas.add(capa);
    }

    return listaCapas;
  }

  @Override
  public Capacitacion read(int id) throws SQLException {
    Capacitacion capa = null;
    String sql = "SELECT id_capa, rut_cliente, dia, hora, lugar, duracion, asistentes FROM capacitacion WHERE id_capa = ?";

    Connection connection = Conexion.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, id);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idCapa = resultSet.getInt("id_capa");
      String rutCliente = resultSet.getString("rut_cliente");
      String dia = resultSet.getString("dia");
      String hora = resultSet.getString("hora");
      String lugar = resultSet.getString("lugar");
      String duracion = resultSet.getString("duracion");
      int asistentes = resultSet.getInt("asistentes");

      capa = new Capacitacion(idCapa, rutCliente, dia, hora, lugar, duracion, asistentes);
    }

    return capa;
  }

  @Override
  public void update(Capacitacion c) throws SQLException {
    String sql = "UPDATE capacitacion " +
            "SET rut_cliente = ?, dia = ?, hora = ?, lugar = ?, duracion = ?, asistentes = ? WHERE id_capa = ?";

    Connection connection = Conexion.getConnection();

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, c.getRutCliente());
    statement.setString(2, c.getDia());
    statement.setString(3, c.getHora());
    statement.setString(4, c.getLugar());
    statement.setString(5, c.getDuracion());
    statement.setInt(6, c.getAsistentes());

    statement.executeUpdate();
  }

  @Override
  public void delete(int id) throws SQLException {
    String sql = "DELETE FROM capacitacion WHERE id_capa = ?";
    Connection connection = Conexion.getConnection();

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, id);

    statement.executeUpdate();
  }
}
