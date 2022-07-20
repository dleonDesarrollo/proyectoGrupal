package model.entity;

public class Profesional extends Usuario {
  private String titulo;
  private String fechaIngreso;

  public Profesional() {
  }

  public Profesional(String nombre, String fechaNacimiento, String run, String titulo, String fechaIngreso) {
    super(nombre, fechaNacimiento, run);
    this.titulo = titulo;
    this.fechaIngreso = fechaIngreso;
  }

  public Profesional(int idUsuario, String nombre, String fechaNacimiento, String run, String titulo, String fechaIngreso) {
    super(idUsuario, nombre, fechaNacimiento, run);
    this.titulo = titulo;
    this.fechaIngreso = fechaIngreso;
  }

  public String getPerfil(){
    return "Profesional";
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(String fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  @Override
  public String toString() {
    return (super.toString()+
            "<br>Titulo: " + this.titulo +
            "<br>Fecha de Ingreso: " + this.fechaIngreso);
  }
}
