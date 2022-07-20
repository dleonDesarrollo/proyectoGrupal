<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

  <head>
    <jsp:include page="../componentes/head.jsp"/>
    <title>Gestion Usuarios</title>
  </head>

  <body>
    <%
      if (session.getAttribute("usuario") == null) {
        response.sendRedirect("login");
      }
    %>


    <div class="container">
      <jsp:include page="../componentes/admin_navbar.jsp"/>

      <main class="main" id="blur">
        <h2>Detalles de ${u.nombre}</h2>
        <h3 class="subtitle mb-1"> ${u}</h3>
      </main>
    </div>
    <script>
        <%@include file="../../scripts/script.js" %>
    </script>
  </body>

</html>