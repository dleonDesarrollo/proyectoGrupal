package model.entity;

public class Cliente extends Usuario {
  private String apellidos;
  private String telefono;
  private String afp;
  private int sistemaSalud;
  private String direccion;
  private String comuna;
  private int edad;

  public Cliente() {
  }

  public Cliente(String nombre, String fechaNacimiento, String run, String apellidos, String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
    super(nombre, fechaNacimiento, run);
    this.apellidos = apellidos;
    this.telefono = telefono;
    this.afp = afp;
    this.sistemaSalud = sistemaSalud;
    this.direccion = direccion;
    this.comuna = comuna;
    this.edad = edad;
  }

  public Cliente(int idUsuario, String nombre, String fechaNacimiento, String run, String apellidos, String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
    super(idUsuario, nombre, fechaNacimiento, run);
    this.apellidos = apellidos;
    this.telefono = telefono;
    this.afp = afp;
    this.sistemaSalud = sistemaSalud;
    this.direccion = direccion;
    this.comuna = comuna;
    this.edad = edad;
  }

  public String obtenerSistemaSalud() {
    return this.sistemaSalud == 1 ? "Fonasa" : "Isapre";
  }

  public String getPerfil() {
    return "Cliente";
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getAfp() {
    return afp;
  }

  public void setAfp(String afp) {
    this.afp = afp;
  }

  public int getSistemaSalud() {
    return sistemaSalud;
  }

  public void setSistemaSalud(int sistemaSalud) {
    this.sistemaSalud = sistemaSalud;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getComuna() {
    return comuna;
  }

  public void setComuna(String comuna) {
    this.comuna = comuna;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  @Override
  public String toString() {
    return (super.toString() +
            "<br>Apellidos: " + this.apellidos +
            "<br>Telefono: " + this.telefono +
            "<br>Afp: " + this.afp +
            "<br>Sistema de salud: " + this.obtenerSistemaSalud() +
            "<br>Direccion: " + this.direccion +
            "<br>Comuna: " + this.comuna +
            "<br>Edad: " + this.edad);
  }
}
