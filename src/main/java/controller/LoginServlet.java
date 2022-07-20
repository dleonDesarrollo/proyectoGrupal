package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


  public static final String USUARIO_ADMIN = "admin";
  public static final String USUARIO_CLIENTE = "cliente";
  public static final String PASS = "1234";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    RequestDispatcher dispatcher = request.getRequestDispatcher("/static/views/login.jsp");
    dispatcher.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nombre = request.getParameter("usuario");
    String pass = request.getParameter("pass");


    if (USUARIO_ADMIN.equals(nombre) && PASS.equals(pass)) {
      HttpSession session = request.getSession();
      session.setAttribute("usuario", USUARIO_ADMIN);
      session.setAttribute("perfil", "Administrativo");
      session.setMaxInactiveInterval(30 * 60);

      response.sendRedirect("gestionusuarios");

    } else if (USUARIO_CLIENTE.equals(nombre) && PASS.equals(pass)) {
      HttpSession session = request.getSession();
      session.setAttribute("usuario", USUARIO_CLIENTE);
      session.setAttribute("perfil", "Cliente");
      session.setMaxInactiveInterval(30 * 60);

      response.sendRedirect("Contacto");

    } else {
      response.sendRedirect("login");
    }
  }

}
