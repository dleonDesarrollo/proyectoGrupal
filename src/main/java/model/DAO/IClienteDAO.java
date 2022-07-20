package model.DAO;

import model.entity.Cliente;
import model.entity.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IClienteDAO {


  void add(Cliente c) throws SQLException;

  List<Cliente> readAll() throws SQLException;

  Cliente read(String rut) throws SQLException;

  void update(Cliente c) throws SQLException;

  void delete(int id) throws SQLException;


}
