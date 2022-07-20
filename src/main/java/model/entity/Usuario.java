package model.entity;

public class Usuario {
  private int idUsuario;
  private String nombre;
  private String fechaNacimiento;
  private String run;

  public Usuario() {
  }

  public Usuario(int idUsuario, String nombre, String fechaNacimiento, String run) {
    this.idUsuario = idUsuario;
    this.nombre = nombre;
    this.fechaNacimiento = fechaNacimiento;
    this.run = run;
  }

  public Usuario(String nombre, String fechaNacimiento, String run) {
    this.nombre = nombre;
    this.fechaNacimiento = fechaNacimiento;
    this.run = run;
  }

  public String getPerfil() {
    return "USUARIO";
  }

  public int getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getRun() {
    return run;
  }

  public void setRun(String run) {
    this.run = run;
  }

  @Override
  public String toString() {
    return ("Nombre: " + this.nombre +
            "<br>RUN: " + this.run +
            "<br>Fecha de Nacimiento: " + this.fechaNacimiento);
  }
}
