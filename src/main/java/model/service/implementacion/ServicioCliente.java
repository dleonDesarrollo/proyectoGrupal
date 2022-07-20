package model.service.implementacion;

import model.DAO.ClienteDAO;
import model.DAO.IClienteDAO;
import model.entity.Cliente;
import model.entity.Usuario;
import model.service.interfaces.IServicioCliente;

import java.sql.SQLException;
import java.util.List;

public class ServicioCliente implements IServicioCliente {

  IClienteDAO dao;

  public ServicioCliente() {
    this.dao = new ClienteDAO();
  }

  @Override
  public void ingresarUsuario(Cliente c) throws SQLException {
    this.dao.add(c);
  }

  @Override
  public List<Cliente> leerTodos() throws SQLException {
    return this.dao.readAll();
  }

  @Override
  public Cliente leer(String rut) throws SQLException {
    return this.dao.read(rut);
  }

  @Override
  public void modificar(Cliente c) throws SQLException {
    this.dao.update(c);
  }

  @Override
  public void eliminar(int id) throws SQLException {
    this.dao.delete(id);
  }
}
