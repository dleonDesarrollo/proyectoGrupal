<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

  <head>
    <jsp:include page="../componentes/head.jsp"/>
    <title>Lista de Capacitaciones</title>
  </head>

  <body>

    <%
      if (session.getAttribute("usuario") == null) {
        response.sendRedirect("login");
      }
    %>

    <div class="container">
      <jsp:include page="../componentes/cliente_navbar.jsp"/>

      <main class="main" id="blur">
        <h2>Capacitaciones solicitadas</h2>
        <h3 class="subtitle mb-1">Lista de capacitaciones asociadas a su cuenta</h3>

        <table id="users" class="display">
          <thead>
            <tr>
              <th>Rut Cliente</th>
              <th>Dia</th>
              <th>Hora</th>
              <th>Lugar</th>
              <th>Duracion</th>
              <th>Asistentes</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="capa" items="${listaCapas}">
              <tr>
                <td>${capa.rutCliente}</td>
                <td>${capa.dia}</td>
                <td>${capa.hora}</td>
                <td>${capa.lugar}</td>
                <td>${capa.duracion}</td>
                <td>${capa.asistentes}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        <div class="button__container">
          <a type="reset" href="${pageContext.request.contextPath}/capacitacion?op=nuevo"
             class="button button--op"><i class="fa-solid fa-graduation-cap"></i> Solicitar nueva
            capacitacion</a>
        </div>


      </main>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#users').DataTable({

                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/1.10.15/i18n/Spanish.json"
                    }
                }
            );
        });

    </script>

    <script>
        <%@include file="../../scripts/script.js" %>
    </script>

  </body>

</html>