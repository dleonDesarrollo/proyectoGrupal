package model.service.interfaces;

import model.entity.Cliente;
import model.entity.Profesional;
import model.entity.Usuario;

import java.sql.SQLException;
import java.util.List;


public interface IServicioProfesional {

  void ingresarUsuario(Profesional p) throws SQLException;

  List<Profesional> leerTodos() throws SQLException;

  Profesional leer(String rut) throws SQLException;

  void modificar(Profesional p) throws SQLException;

  void eliminar(int id) throws SQLException;

}
