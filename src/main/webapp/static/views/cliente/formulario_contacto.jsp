<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

  <head>
    <jsp:include page="../componentes/head.jsp"/>
    <title>Formulario de Contacto</title>
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
        <h2>Formulario de Contacto</h2>
        <h3 class="subtitle">Nos comunicaremos a la brevedad</h3>


        <form class="formulario " method="post" action="Contacto">
          <div class="formulario__container">
            <div class="formulario__campo">
              <label class="formulario__label" for="contacto">Metodo de contacto</label>
              <input class="formulario__input" type="text" name="contacto" id="contacto">
            </div>

            <div class="formulario__campo ">
              <label class="formulario__label" for="area">Area correspondiente</label>
              <input class="formulario__input" type="text" name="area" id="area">
            </div>
          </div>

          <div class="formulario__container ">
            <div class="formulario__campo">
              <label class="formulario__label" for="consulta">Consulta</label>


              <textarea class="formulario__textarea" name="consulta" id="consulta" rows=""></textarea>
            </div>
          </div>
          <div class="button__container">
            <button type="reset" class="button button--secondary">Limpiar Campos</button>
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