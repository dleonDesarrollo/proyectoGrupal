package model.service.implementacion;

import model.DAO.AdministrativoDAO;
import model.DAO.ClienteDAO;
import model.DAO.IAdministrativoDAO;
import model.DAO.IClienteDAO;
import model.entity.Administrativo;
import model.entity.Usuario;
import model.service.interfaces.IServicioAdministrativo;

import java.sql.SQLException;
import java.util.List;

public class ServicioAdministrativo implements IServicioAdministrativo {

  IAdministrativoDAO dao;

  public ServicioAdministrativo() {
    this.dao = new AdministrativoDAO();
  }

  @Override
  public void ingresarUsuario(Administrativo a) throws SQLException {
    this.dao.add(a);
  }

  @Override
  public List<Administrativo> leerTodos() throws SQLException {
    return this.dao.readAll();
  }

  @Override
  public Administrativo leer(String rut) throws SQLException {
    return this.dao.read(rut);
  }

  @Override
  public void modificar(Administrativo a) throws SQLException {
    this.dao.update(a);
  }

  @Override
  public void eliminar(int id) throws SQLException {
    this.dao.delete(id);
  }
}
