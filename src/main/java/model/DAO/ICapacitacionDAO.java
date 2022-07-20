package model.DAO;

import model.entity.Capacitacion;

import java.sql.SQLException;
import java.util.List;

public interface ICapacitacionDAO {


  void add(Capacitacion c) throws SQLException;

  List<Capacitacion> readAll() throws SQLException;

  Capacitacion read(int id) throws SQLException;

  void update(Capacitacion c) throws SQLException;

  void delete(int id) throws SQLException;


}
