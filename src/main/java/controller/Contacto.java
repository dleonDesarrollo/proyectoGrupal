package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Contacto")
public class Contacto extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/static/views/cliente/formulario_contacto.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String mContacto = request.getParameter("contacto");
    String area = request.getParameter("area");
    String consulta = request.getParameter("consulta");

    System.out.println("=======================================================");
    System.out.println("Metodo de contacto: " + mContacto);
    System.out.println("Area: " + area);
    System.out.println("Consulta: " + consulta);
    System.out.println("=======================================================");
    response.sendRedirect("Contacto");

  }
}
