package controller;

import model.entity.Administrativo;
import model.entity.Cliente;
import model.entity.Profesional;
import model.entity.Usuario;
import model.service.implementacion.ServicioAdministrativo;
import model.service.implementacion.ServicioCliente;
import model.service.implementacion.ServicioProfesional;
import model.service.interfaces.IServicioAdministrativo;
import model.service.interfaces.IServicioCliente;
import model.service.interfaces.IServicioProfesional;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/gestionusuarios")
public class GestionUsuariosServlet extends HttpServlet {

  private IServicioCliente servicioCliente;
  private IServicioAdministrativo servicioAdministrativo;
  private IServicioProfesional servicioProfesional;

  @Override
  public void init() throws ServletException {
    this.servicioCliente = new ServicioCliente();
    this.servicioAdministrativo = new ServicioAdministrativo();
    this.servicioProfesional = new ServicioProfesional();

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String op = request.getParameter("op");

    if (op == null) {
      op = "listar";
    }
    try {
      switch (op) {
        case "nuevoC":
          mostrarFormularioCliente(request, response, op);
          break;
        case "nuevoA":
          mostrarFormularioAdmin(request, response, op);
          break;
        case "nuevoP":
          mostrarFormularioProfesional(request, response, op);
          break;
        case "addC":
          addCliente(request, response, op);
          break;
        case "addA":
          addAdministrativo(request, response, op);
          break;
        case "addP":
          addProfesional(request, response, op);
          break;
        case "edit":
          editarUsuario(request, response, op);
          break;
        case "update":
          updateUsuario(request, response, op);
          break;
        case "listar":
          mostrarLista(request, response, op);
          break;
      }

    } catch (SQLException e) {
      throw new ServletException(e);
    }
  }

  private void updateUsuario(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException, SQLException {
    request.setAttribute("op", op);
    String perfil = request.getParameter("perf");


    switch (perfil) {
      case "Cliente": {
        String rutCliente = request.getParameter("run");
        String nombre = request.getParameter("nombres");
        String fechaNacimiento = request.getParameter("fnacimiento");
        String apellido = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String afp = request.getParameter("afp");
        String sistSalud = request.getParameter("sisS");
        String direccion = request.getParameter("direccion");
        String comuna = request.getParameter("comuna");
        int edad = Integer.parseInt(request.getParameter("edad"));

        int sisS = sistSalud.equals("Fonasa") ? 1 : 2;

        Cliente cliente = new Cliente(nombre, fechaNacimiento, rutCliente, apellido,
                telefono, afp, sisS, direccion, comuna, edad);

        this.servicioCliente.modificar(cliente);
        break;
      }
      case "Administrativo": {
        String rutAdmin = request.getParameter("run");
        String nombre = request.getParameter("nombres");
        String fechaNacimiento = request.getParameter("fnacimiento");
        String area = request.getParameter("area");
        String expPrevia = request.getParameter("exp");

        Administrativo admin = new Administrativo(nombre, fechaNacimiento, rutAdmin, area, expPrevia);

        this.servicioAdministrativo.modificar(admin);
        break;
      }
      case "Profesional": {
        String rutProf = request.getParameter("run");
        String nombre = request.getParameter("nombres");
        String fechaNacimiento = request.getParameter("fnacimiento");
        String titulo = request.getParameter("titulo");
        String fechaIngreso = request.getParameter("fingreso");

        Profesional prof = new Profesional(nombre, fechaNacimiento, rutProf, titulo, fechaIngreso);

        this.servicioProfesional.modificar(prof);
        break;
      }
    }

    response.sendRedirect("gestionusuarios?op=listar");
  }


  private void editarUsuario(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException, SQLException {

    request.setAttribute("op", op);
    String run = request.getParameter("id");
    String perfil = request.getParameter("perf");


    switch (perfil) {
      case "Cliente":
        request.setAttribute("user", this.servicioCliente.leer(run));
        request.getRequestDispatcher("/static/views/administrativo/formulario_crear_cliente.jsp").forward(request, response);
        break;
      case "Administrativo":
        request.setAttribute("user", this.servicioAdministrativo.leer(run));
        request.getRequestDispatcher("/static/views/administrativo/formulario_crear_admin.jsp").forward(request, response);
        break;
      case "Profesional":
        request.setAttribute("user", this.servicioProfesional.leer(run));
        request.getRequestDispatcher("/static/views/administrativo/formulario_crear_profesional.jsp").forward(request, response);
        break;
    }
  }

  private void addCliente(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException, SQLException {
    request.setAttribute("op", op);

    String run = request.getParameter("run");
    String nombres = request.getParameter("nombres");
    String apellidos = request.getParameter("apellidos");
    int edad = Integer.parseInt(request.getParameter("edad"));
    String telefono = request.getParameter("telefono");
    String afp = request.getParameter("afp");
    String comuna = request.getParameter("comuna");
    String direccion = request.getParameter("direccion");
    String fnacimiento = request.getParameter("fnacimiento");

    String sistemaS = request.getParameter("sisS");

    int sisS = sistemaS.equals("Fonasa") ? 1 : 2;

    this.servicioCliente.ingresarUsuario(new Cliente(nombres, fnacimiento, run, apellidos, telefono, afp, sisS, direccion, comuna, edad));
    response.sendRedirect("gestionusuarios?op=listar");
  }

  private void addProfesional(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException, SQLException {
    request.setAttribute("op", op);

    String run = request.getParameter("run");
    String nombres = request.getParameter("nombres");
    String fnacimiento = request.getParameter("fnacimiento");
    String fingreso = request.getParameter("fingreso");
    String titulo = request.getParameter("titulo");


    this.servicioProfesional.ingresarUsuario(new Profesional(nombres, fnacimiento, run, titulo, fingreso));

    response.sendRedirect("gestionusuarios?op=listar");
  }

  private void addAdministrativo(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException, SQLException {
    request.setAttribute("op", op);

    String run = request.getParameter("run");
    String nombres = request.getParameter("nombres");
    String fnacimiento = request.getParameter("fnacimiento");
    String exp = request.getParameter("exp");
    String area = request.getParameter("area");


    this.servicioAdministrativo.ingresarUsuario(new Administrativo(nombres, fnacimiento, run, area, exp));
    response.sendRedirect("gestionusuarios?op=listar");
  }


  private void mostrarFormularioCliente(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException {

    request.setAttribute("op", op);
    getServletContext()
            .getRequestDispatcher("/static/views/administrativo/formulario_crear_cliente.jsp")
            .forward(request, response);
  }

  private void mostrarFormularioAdmin(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException {

    request.setAttribute("op", op);
    getServletContext()
            .getRequestDispatcher("/static/views/administrativo/formulario_crear_admin.jsp")
            .forward(request, response);
  }

  private void mostrarFormularioProfesional(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException {

    request.setAttribute("op", op);
    getServletContext()
            .getRequestDispatcher("/static/views/administrativo/formulario_crear_profesional.jsp")
            .forward(request, response);
  }


  private void mostrarLista(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException, SQLException {
    request.setAttribute("op", op);

    List<Usuario> allUsers = new ArrayList<>();


    request.setAttribute("listaClientes", this.servicioCliente.leerTodos());
    request.setAttribute("listaAdmin", this.servicioAdministrativo.leerTodos());
    request.setAttribute("listaProf", servicioProfesional.leerTodos());


    getServletContext()
            .getRequestDispatcher("/static/views/administrativo/lista_usuarios.jsp")
            .forward(request, response);

  }
}