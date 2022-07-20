package model.service.implementacion;

import model.DAO.CapacitacionDAO;
import model.DAO.ICapacitacionDAO;
import model.entity.Capacitacion;
import model.service.interfaces.IServicioCapacitacion;

import java.sql.SQLException;
import java.util.List;

public class ServicioCapacitacion implements IServicioCapacitacion {

  private ICapacitacionDAO dao;

  public ServicioCapacitacion() {
    this.dao = new CapacitacionDAO();
  }

  @Override
  public void ingresarCapacitacion(Capacitacion c) throws SQLException {
    this.dao.add(c);
  }

  @Override
  public List<Capacitacion> leerTodas() throws SQLException {
    return this.dao.readAll();
  }

  @Override
  public Capacitacion leer(int id) throws SQLException {
    return this.dao.read(id);
  }

  @Override
  public void modificar(Capacitacion c) throws SQLException {
    this.dao.update(c);
  }

  @Override
  public void eliminar(int id) throws SQLException {
    this.dao.delete(id);
  }
}
