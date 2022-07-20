package controller;

import model.entity.Capacitacion;
import model.service.implementacion.ServicioCapacitacion;
import model.service.interfaces.IServicioCapacitacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/capacitacion")
public class CapacitacionServlet extends HttpServlet {

  private IServicioCapacitacion servicio;

  @Override
  public void init() throws ServletException {
    this.servicio = new ServicioCapacitacion();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String op = request.getParameter("op");

    if (op == null) {
      op = "nuevo";
    }

    try {
      switch (op) {
        case "nuevo":
          mostrarFormulario(request, response, op);
          break;
        case "add":
          addCapacitacion(request, response, op);
          break;
        case "listar":
          mostrarLista(request, response, op);
          break;
      }
    } catch (SQLException e) {
      throw new ServletException(e);
    }


  }

  private void addCapacitacion(HttpServletRequest request, HttpServletResponse response, String op) throws SQLException, ServletException, IOException {
    request.setAttribute("op", op);

    String rutCliente = request.getParameter("rut");
    String lugar = request.getParameter("lugar");
    String dia = request.getParameter("dia");
    String hora = request.getParameter("hora");
    String duracion = request.getParameter("duracion");
    int cantidadAsis = Integer.parseInt(request.getParameter("asistentes"));

    this.servicio.ingresarCapacitacion(new Capacitacion(rutCliente, dia, hora, lugar, duracion, cantidadAsis));

    response.sendRedirect("capacitacion?op=listar");

  }

  private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response, String op) throws SQLException, ServletException, IOException {

    request.setAttribute("op", op);
    getServletContext()
            .getRequestDispatcher("/static/views/cliente/formulario_crear-capacitacion.jsp")
            .forward(request, response);
  }

  private void mostrarLista(HttpServletRequest request, HttpServletResponse response, String op) throws SQLException, ServletException, IOException {
    request.setAttribute("op", op);

    request.setAttribute("listaCapas", this.servicio.leerTodas());

    getServletContext()
            .getRequestDispatcher("/static/views/cliente/lista_capacitaciones.jsp")
            .forward(request, response);

  }


}
