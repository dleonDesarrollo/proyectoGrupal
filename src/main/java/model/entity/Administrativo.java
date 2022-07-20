package model.entity;

public class Administrativo extends Usuario {
  private String area;
  private String expPrevia;

  public Administrativo() {
  }

  public Administrativo(String nombre, String fechaNacimiento, String run, String area, String expPrevia) {
    super(nombre, fechaNacimiento, run);
    this.area = area;
    this.expPrevia = expPrevia;
  }

  public Administrativo(int idUsuario, String nombre, String fechaNacimiento, String run, String area, String expPrevia) {
    super(idUsuario, nombre, fechaNacimiento, run);
    this.area = area;
    this.expPrevia = expPrevia;
  }

  public String getPerfil(){
    return "Administrativo";
  }
  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getExpPrevia() {
    return expPrevia;
  }

  public void setExpPrevia(String expPrevia) {
    this.expPrevia = expPrevia;
  }

  @Override
  public String toString() {
    return (super.toString()+
            "<br>Area: " + this.area +
            "<br>Experiencia Previa: " + this.expPrevia);
  }
}
