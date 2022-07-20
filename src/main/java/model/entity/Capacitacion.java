package model.entity;

public class Capacitacion {
  private int id;
  private String rutCliente;
  private String dia;
  private String hora;
  private String lugar;
  private String duracion;
  private int asistentes;

  public Capacitacion(int id, String rutCliente, String dia, String hora, String lugar, String duracion, int asistentes) {
    this.id = id;
    this.rutCliente = rutCliente;
    this.dia = dia;
    this.hora = hora;
    this.lugar = lugar;
    this.duracion = duracion;
    this.asistentes = asistentes;
  }

  public Capacitacion(String rutCliente, String dia, String hora, String lugar, String duracion, int asistentes) {
    this.rutCliente = rutCliente;
    this.dia = dia;
    this.hora = hora;
    this.lugar = lugar;
    this.duracion = duracion;
    this.asistentes = asistentes;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRutCliente() {
    return rutCliente;
  }

  public void setRutCliente(String rutCliente) {
    this.rutCliente = rutCliente;
  }

  public String getDia() {
    return dia;
  }

  public void setDia(String dia) {
    this.dia = dia;
  }

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public String getLugar() {
    return lugar;
  }

  public void setLugar(String lugar) {
    this.lugar = lugar;
  }

  public String getDuracion() {
    return duracion;
  }

  public void setDuracion(String duracion) {
    this.duracion = duracion;
  }

  public int getAsistentes() {
    return asistentes;
  }

  public void setAsistentes(int asistentes) {
    this.asistentes = asistentes;
  }

  @Override
  public String toString() {
    return "Capacitacion{" +
            "id=" + id +
            ", rutCliente='" + rutCliente + '\'' +
            ", dia='" + dia + '\'' +
            ", hora='" + hora + '\'' +
            ", lugar='" + lugar + '\'' +
            ", duracion='" + duracion + '\'' +
            ", asistentes=" + asistentes +
            '}';
  }
}
