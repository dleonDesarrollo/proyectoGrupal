package model.service.implementacion;

import model.DAO.ClienteDAO;
import model.DAO.IClienteDAO;
import model.DAO.IProfesionalDAO;
import model.DAO.ProfesionalDAO;
import model.entity.Profesional;
import model.entity.Usuario;
import model.service.interfaces.IServicioProfesional;

import java.sql.SQLException;
import java.util.List;

public class ServicioProfesional implements IServicioProfesional {

  IProfesionalDAO dao;

  public ServicioProfesional() {
    this.dao = new ProfesionalDAO();
  }


  @Override
  public void ingresarUsuario(Profesional p) throws SQLException {
    this.dao.add(p);
  }

  @Override
  public List<Profesional> leerTodos() throws SQLException {
    return this.dao.readAll();
  }

  @Override
  public Profesional leer(String rut) throws SQLException {
    return this.dao.read(rut);
  }

  @Override
  public void modificar(Profesional p) throws SQLException {
    this.dao.update(p);
  }

  @Override
  public void eliminar(int id) throws SQLException {
    this.dao.delete(id);
  }
}
