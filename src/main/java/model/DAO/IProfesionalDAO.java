package model.DAO;

import model.entity.Administrativo;
import model.entity.Profesional;
import model.entity.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IProfesionalDAO {


  void add(Profesional p) throws SQLException;

  List<Profesional> readAll() throws SQLException;

  Profesional read(String rut) throws SQLException;

  void update(Profesional p) throws SQLException;

  void delete(int id) throws SQLException;


}
