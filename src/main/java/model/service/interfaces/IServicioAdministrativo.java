package model.service.interfaces;

import model.entity.Administrativo;
import model.entity.Cliente;
import model.entity.Usuario;

import java.sql.SQLException;
import java.util.List;


public interface IServicioAdministrativo {

  void ingresarUsuario(Administrativo a) throws SQLException;

  List<Administrativo> leerTodos() throws SQLException;

  Administrativo leer(String rut) throws SQLException;

  void modificar(Administrativo a) throws SQLException;

  void eliminar(int id) throws SQLException;

}
