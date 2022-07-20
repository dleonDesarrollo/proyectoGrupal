package model.DAO;

import model.conexion.Conexion;
import model.entity.Administrativo;
import model.entity.Profesional;
import model.entity.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesionalDAO implements IProfesionalDAO {
  @Override
  public void add(Profesional p) throws SQLException {
    String sql =
            "INSERT INTO profesional " +
                    "(rut_profesional, nombre, fecha_nac, titulo, fecha_ingreso) " +
                    "VALUES (?, ?, ?, ?, ?)";

    Connection connection = Conexion.getConnection();

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, p.getRun());
    statement.setString(2, p.getNombre());
    statement.setString(3, p.getFechaNacimiento());
    statement.setString(4, p.getTitulo());
    statement.setString(5, p.getFechaIngreso());
    statement.execute();
  }

  @Override
  public List<Profesional> readAll() throws SQLException {
    List<Profesional> listaProf = new ArrayList<>();

    String sql = "SELECT rut_profesional, nombre, fecha_nac, titulo, fecha_ingreso FROM profesional";

    Connection connection = Conexion.getConnection();

    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      String rutProf = resultSet.getString("rut_profesional");
      String nombre = resultSet.getString("nombre");
      String fechaNacimiento = resultSet.getString("fecha_nac");
      String titulo = resultSet.getString("titulo");
      String fechaIngreso = resultSet.getString("fecha_ingreso");

      Profesional prof = new Profesional(nombre, fechaNacimiento, rutProf, titulo, fechaIngreso);
      listaProf.add(prof);
    }
    return listaProf;
  }

  @Override
  public Profesional read(String rut) throws SQLException {
    Profesional prof = null;
    String sql =
            "SELECT rut_profesional, nombre, fecha_nac, titulo, fecha_ingreso FROM profesional WHERE rut_profesional = ?";

    Connection connection = Conexion.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, rut);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {

      String rutProf = resultSet.getString("rut_profesional");
      String nombre = resultSet.getString("nombre");
      String fechaNacimiento = resultSet.getString("fecha_nac");
      String titulo = resultSet.getString("titulo");
      String fechaIngreso = resultSet.getString("fecha_ingreso");

      prof = new Profesional(nombre, fechaNacimiento, rutProf, titulo, fechaIngreso);
    }

    return prof;
  }

  @Override
  public void update(Profesional p) throws SQLException {
    String sql =
            "UPDATE profesional " +
                    "SET rut_profesional = ?, nombre = ?, fecha_nac = ?, titulo = ?, fecha_ingreso = ? WHERE rut_profesional = ?";

    Connection connection = Conexion.getConnection();

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, p.getRun());
    statement.setString(2, p.getNombre());
    statement.setString(3, p.getFechaNacimiento());
    statement.setString(4, p.getTitulo());
    statement.setString(5, p.getFechaIngreso());
    statement.setString(6, p.getRun());

    statement.executeUpdate();
  }

  @Override
  public void delete(int id) throws SQLException {
    String sql = "DELETE FROM profesional WHERE id_profesional = ?";
    Connection connection = Conexion.getConnection();

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, id);

    statement.executeUpdate();
  }
}
