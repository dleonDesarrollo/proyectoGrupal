package model.DAO;

import model.entity.Administrativo;
import model.entity.Cliente;
import model.entity.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IAdministrativoDAO {


  void add(Administrativo a) throws SQLException;

  List<Administrativo> readAll() throws SQLException;

  Administrativo read(String rut) throws SQLException;

  void update(Administrativo c) throws SQLException;

  void delete(int id) throws SQLException;


}
