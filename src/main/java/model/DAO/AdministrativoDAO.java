package model.DAO;

import model.conexion.Conexion;
import model.entity.Administrativo;
import model.entity.Cliente;
import model.entity.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministrativoDAO implements IAdministrativoDAO {


  @Override
  public void add(Administrativo a) throws SQLException {
    String sql =
            "INSERT INTO administrativo " +
                    "(rut_admi, nombre, fecha_nac, area, exp_previa) " +
                    "VALUES (?, ?, ?, ?, ?)";

    Connection connection = Conexion.getConnection();

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, a.getRun());
    statement.setString(2, a.getNombre());
    statement.setString(3, a.getFechaNacimiento());
    statement.setString(4, a.getArea());
    statement.setString(5, a.getExpPrevia());
    statement.execute();
  }

  @Override
  public List<Administrativo> readAll() throws SQLException {
    List<Administrativo> listaAdmin = new ArrayList<>();

    String sql = "SELECT rut_admi,nombre, fecha_nac,area,exp_previa FROM administrativo";

    Connection connection = Conexion.getConnection();

    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      String rutAdmin = resultSet.getString("rut_admi");
      String nombre = resultSet.getString("nombre");
      String fechaNacimiento = resultSet.getString("fecha_nac");
      String area = resultSet.getString("area");
      String expPrevia = resultSet.getString("exp_previa");

      Administrativo admin = new Administrativo(nombre, fechaNacimiento, rutAdmin, area, expPrevia);

      listaAdmin.add(admin);
    }
    return listaAdmin;
  }

  @Override
  public Administrativo read(String rut) throws SQLException {
    Administrativo admin = null;
    String sql =
            "SELECT rut_admi,nombre, fecha_nac,area,exp_previa FROM administrativo WHERE rut_admi = ?";

    Connection connection = Conexion.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, rut);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {

      String rutAdmin = resultSet.getString("rut_admi");
      String nombre = resultSet.getString("nombre");
      String fechaNacimiento = resultSet.getString("fecha_nac");
      String area = resultSet.getString("area");
      String expPrevia = resultSet.getString("exp_previa");

      admin = new Administrativo(nombre, fechaNacimiento, rutAdmin, area, expPrevia);
    }

    return admin;
  }

  @Override
  public void update(Administrativo a) throws SQLException {
    String sql =
            "UPDATE administrativo " +
                    "SET rut_admi = ?, nombre = ?, fecha_nac = ?, area = ?, exp_previa = ? WHERE rut_admi = ?";

    Connection connection = Conexion.getConnection();

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, a.getRun());
    statement.setString(2, a.getNombre());
    statement.setString(3, a.getFechaNacimiento());
    statement.setString(4, a.getArea());
    statement.setString(5, a.getExpPrevia());
    statement.setString(6, a.getRun());

    statement.executeUpdate();
  }

  @Override
  public void delete(int id) throws SQLException {
    String sql = "DELETE FROM administrativo WHERE id_admi = ?";
    Connection connection = Conexion.getConnection();

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, id);

    statement.executeUpdate();
  }
}
