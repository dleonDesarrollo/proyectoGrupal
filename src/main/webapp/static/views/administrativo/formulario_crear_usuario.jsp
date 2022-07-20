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
        <h2>Ingresar Nuevo Usuario</h2>
        <h3 class="subtitle">Complete la informacion para ingresar el nuevo usuario.</h3>


        <form class="formulario" action="gestionusuarios?op=add" method="post">
          <div class="formulario__container">
            <div class="formulario__campo">
              <label class="formulario__label" for="user">Nombre de usuario: </label>
              <input class="formulario__input" type="text" name="user" id="user">
            </div>

            <div class="formulario__campo ">
              <label class="formulario__label" for="run">RUN: </label>
              <input class="formulario__input" type="text" name="run" id="run">
            </div>

            <div class="formulario__campo ">
              <label class="formulario__label" for="nac">Fecha de Nacimiento:</label>
              <input class="formulario__input" type="text" name="nac" id="nac">
            </div>
          </div>


          <div class="button__container">
            <input type="reset" value="Limpiar Campos" class="button button--secondary">
            <button type="submit" class="button button--primary">Enviar Solicitud</button>
          </div>
        </form>
      </main>

    </div>
    <script>
        <%@include file="../../scripts/script.js" %>
    </script>
  </body>

</html>