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
        <c:if test="${op == 'nuevoC'}">
        <h2>Ingresar Nuevo Cliente</h2>
        <h3 class="subtitle">Complete la informacion para ingresar el nuevo Cliente.</h3>
        <form class="formulario" action="gestionusuarios?op=addC" method="post">
          </c:if>

          <c:if test="${op == 'edit'}">
          <h2>Editar Cliente</h2>
          <h3 class="subtitle">Reeingrese los campos que desee modificar.</h3>
          <form class="formulario" action="gestionusuarios?perf=Cliente&op=update" method="post">
            </c:if>


            <div class="formulario__container">
              <div class="formulario__campo ">
                <label class="formulario__label" for="run">RUN: </label>
                <c:choose>
                  <c:when test="${op == 'edit'}">
                    <input readonly class="formulario__input" type="text" name="run" id="run" value="${user.run}">
                  </c:when>
                  <c:otherwise>
                    <input required class="formulario__input" type="text" name="run" id="run" value="${user.run}">
                  </c:otherwise>
                </c:choose>

              </div>
              <div class="formulario__campo">
                <label class="formulario__label" for="nombres">Nombres: </label>
                <input required class="formulario__input" type="text" name="nombres" id="nombres" value="${user.nombre}">
              </div>
            </div>


            <div class="formulario__container">
              <div class="formulario__campo ">
                <label class="formulario__label" for="apellidos">Apellidos:</label>
                <input required class="formulario__input" type="text" name="apellidos" id="apellidos" value="${user.apellidos}">
              </div>
              <div class="formulario__campo ">
                <label class="formulario__label" for="edad">Edad: </label>
                <input required class="formulario__input" type="text" name="edad" id="edad" value="${user.edad}">
              </div>

            </div>

            <div class="formulario__container">
              <div class="formulario__campo ">
                <label class="formulario__label" for="telefono">Telefono:</label>
                <input required class="formulario__input" type="text" name="telefono" id="telefono" value="${user.telefono}">
              </div>
              <div class="formulario__campo ">
                <label class="formulario__label" for="afp">AFP: </label>
                <input required class="formulario__input" type="text" name="afp" id="afp" value="${user.afp}">
              </div>
            </div>

            <div class="formulario__container">
              <div class="formulario__campo ">
                <label class="formulario__label" for="comuna">Comuna:</label>
                <input required class="formulario__input" type="text" name="comuna" id="comuna" value="${user.comuna}">
              </div>
              <div class="formulario__campo ">
                <label class="formulario__label" for="direccion">Direccion: </label>
                <input required class="formulario__input" type="text" name="direccion" id="direccion" value="${user.direccion}">
              </div>
            </div>

            <div class="formulario__container">
              <div class="formulario__campo ">
                <label class="formulario__label" for="fnacimiento">Fecha Nacimiento: </label>
                <input required class="formulario__input" type="date" name="fnacimiento" id="fnacimiento"
                       value="${user.fechaNacimiento}">
              </div>
              <div class="formulario__campo ">
                <label class="formulario__label" for="sisS">Sistema Salud:</label>
                <select class="formulario__input" name="sisS" id="sisS">
                  <c:if test="${user.sistemaSalud == 1}">
                    <option selected value="Fonasa">Fonasa</option>
                    <option value="Isapre">Isapre</option>
                  </c:if>
                  <c:if test="${user.sistemaSalud == 2}">
                    <option value="Fonasa">Fonasa</option>
                    <option selected value="Isapre">Isapre</option>
                  </c:if>
                  <c:if test="${user.obtenerSistemaSalud() == null}">
                    <option value="Fonasa">Fonasa</option>
                    <option value="Isapre">Isapre</option>
                  </c:if>


                </select>
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