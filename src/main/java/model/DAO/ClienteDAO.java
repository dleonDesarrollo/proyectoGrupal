package model.DAO;

import model.conexion.Conexion;
import model.entity.Cliente;
import model.entity.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

  @Override
  public void add(Cliente c) throws SQLException {
    String sql =
            "INSERT INTO cliente " +
                    "(rut_cliente, nombre, fecha_nac, apellido, telefono, afp, sist_salud, direccion, comuna, edad) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    Connection connection = Conexion.getConnection();

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, c.getRun());
    statement.setString(2, c.getNombre());
    statement.setString(3, c.getFechaNacimiento());
    statement.setString(4, c.getApellidos());
    statement.setString(5, c.getTelefono());
    statement.setString(6, c.getAfp());
    statement.setInt(7, c.getSistemaSalud());
    statement.setString(8, c.getDireccion());
    statement.setString(9, c.getComuna());
    statement.setInt(10, c.getEdad());

    statement.execute();
  }

  @Override
  public List<Cliente> readAll() throws SQLException {
    List<Cliente> listaClientes = new ArrayList<>();

    String sql = "SELECT rut_cliente, nombre, fecha_nac, apellido, telefono, afp, sist_salud, direccion, comuna, edad FROM cliente";

    Connection connection = Conexion.getConnection();

    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      String rutCliente = resultSet.getString("rut_cliente");
      String nombre = resultSet.getString("nombre");
      String fechaNacimiento = resultSet.getString("fecha_nac");
      String apellido = resultSet.getString("apellido");
      String telefono = resultSet.getString("telefono");
      String afp = resultSet.getString("afp");
      int sistSalud = resultSet.getInt("sist_salud");
      String direccion = resultSet.getString("direccion");
      String comuna = resultSet.getString("comuna");
      int edad = resultSet.getInt("edad");

      Cliente cliente = new Cliente(nombre, fechaNacimiento, rutCliente, apellido,
              telefono, afp, sistSalud, direccion, comuna, edad);
      listaClientes.add(cliente);
    }
    return listaClientes;
  }

  @Override
  public Cliente read(String rut) throws SQLException {
    Cliente cliente = null;
    String sql =
            "SELECT rut_cliente, nombre, fecha_nac, apellido, telefono, afp, sist_salud, direccion, comuna, edad " +
                    "FROM cliente WHERE rut_cliente = ?";

    Connection connection = Conexion.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, rut);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {

      String rutCliente = resultSet.getString("rut_cliente");
      String nombre = resultSet.getString("nombre");
      String fechaNacimiento = resultSet.getString("fecha_nac");
      String apellido = resultSet.getString("apellido");
      String telefono = resultSet.getString("telefono");
      String afp = resultSet.getString("afp");
      int sistSalud = resultSet.getInt("sist_salud");
      String direccion = resultSet.getString("direccion");
      String comuna = resultSet.getString("comuna");
      int edad = resultSet.getInt("edad");

      cliente = new Cliente(nombre, fechaNacimiento, rutCliente, apellido,
              telefono, afp, sistSalud, direccion, comuna, edad);
    }

    return cliente;
  }

  @Override
  public void update(Cliente c) throws SQLException {
    String sql =
            "UPDATE cliente " +
                    "SET rut_cliente = ?, nombre = ?, fecha_nac = ?, apellido = ?, telefono = ?, afp = ?, sist_salud = ?, " +
                    "direccion = ?, comuna = ?, edad = ?" +
                    " WHERE rut_cliente = ?";

    Connection connection = Conexion.getConnection();

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, c.getRun());
    statement.setString(2, c.getNombre());
    statement.setString(3, c.getFechaNacimiento());
    statement.setString(4, c.getApellidos());
    statement.setString(5, c.getTelefono());
    statement.setString(6, c.getAfp());
    statement.setInt(7, c.getSistemaSalud());
    statement.setString(8, c.getDireccion());
    statement.setString(9, c.getComuna());
    statement.setInt(10, c.getEdad());
    statement.setString(11, c.getRun());



    statement.executeUpdate();
  }

  @Override
  public void delete(int id) throws SQLException {
//    String sql = "DELETE FROM cliente WHERE rut_cliente = ?";
//    Connection connection = Conexion.getConnection();
//
//    PreparedStatement statement = connection.prepareStatement(sql);
//    statement.setInt(1, id);
//
//    statement.executeUpdate();
  }
}
