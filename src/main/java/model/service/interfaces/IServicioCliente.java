package model.service.interfaces;

import model.entity.Cliente;
import model.entity.Usuario;

import java.sql.SQLException;
import java.util.List;


public interface IServicioCliente {

  void ingresarUsuario(Cliente c) throws SQLException;

  List<Cliente> leerTodos() throws SQLException;

  Cliente leer(String rut) throws SQLException;

  void modificar(Cliente c) throws SQLException;

  void eliminar(int id) throws SQLException;

}
