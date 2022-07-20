package model.service.interfaces;

import java.sql.SQLException;
import java.util.List;

import model.entity.Capacitacion;


public interface IServicioCapacitacion {

  void ingresarCapacitacion(Capacitacion c) throws SQLException;

  List<Capacitacion> leerTodas() throws SQLException;

  Capacitacion leer(int id) throws SQLException;

  void modificar(Capacitacion c) throws SQLException;

  void eliminar(int id) throws SQLException;

}
