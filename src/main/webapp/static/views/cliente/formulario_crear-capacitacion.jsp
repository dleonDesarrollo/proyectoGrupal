<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="../componentes/head.jsp"/>
    <title>Crear Capacitacion</title>
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

        <h2>Capacitaciones - Ingreso de Capacitacion</h2>
        <h3 class="subtitle">Complete esta información para solicitar una capacitacion </h3>

        <form class="formulario" action="${pageContext.request.contextPath}/capacitacion?op=add" method="post">

          <div class="formulario__container">

            <div class="formulario__campo" >
              <label class="formulario__label" for="rut">Rut Cliente (representante):</label>
              <input onblur="validaRut()" class="formulario__input" type="text" name="rut" id="rut" placeholder="99.999.999" required>
              <span class="msjValidacion"></span>
            </div>
            <div class="formulario__campo">
              <label class="formulario__label" for="lugar">Lugar:</label>
              <input onblur="validaLugar()" class="formulario__input" type="text" name="lugar" id="lugar" required>
              <span class="msjValidacion"></span>
            </div>
          </div>


          <div class="formulario__container">

            <div class="formulario__campo">
              <label class="formulario__label" for="dia">Día:</label>
              <select onblur="validaDia()" class="formulario__input" name="dia" id="dia">
                <option onsubmit="validaDia()" value="Seleccionar">Seleccionar</option>
                <option value="lunes">Lunes</option>
                <option value="martes">Martes</option>
                <option value="miercoles">Miercoles</option>
                <option value="jueves">Jueves</option>
                <option value="viernes">Viernes</option>
                <option value="sabado">Sábado</option>
                <option value="domingo">Domingo</option>
              </select>
              <span class="msjValidacion"></span>
            </div>
            <div class="formulario__campo">
              <label class="formulario__label" for="hora">Hora:</label>
              <input onblur="validaHora()" class="formulario__input" type="time" name="hora" id="hora" required>
              <span class="msjValidacion"></span>
            </div>
          </div>

          <div class="formulario__container">
            <div class="formulario__campo">
              <label class="formulario__label" for="duracion">Duración:</label>
              <input onblur="validaDuracion()" class="formulario__input" type="number" name="duracion" id="duracion" min="10" max="60"
                     step="10" required>
              <span class="msjValidacion"></span>
            </div>
            <div class="formulario__campo">
              <label class="formulario__label" for="asistentes">Cantidad de Asistentes:</label>
              <input onblur="validaAsistentes()" class="formulario__input" type="number" name="asistentes" id="asistentes"
                     placeholder="Máximo 1000" required>
              <span class="msjValidacion"></span>
            </div>
          </div>
          <div class="button__container">
            <a type="reset" href="" class="button button--secondary">Limpiar Campos</a>
            <input  type="submit" value="Ingresar" class="button button--primary">
          </div>
        </form>
      </main>
    </div>
    <script>
        <%@include file="../../scripts/script.js" %>
        <%@include file="../../scripts/validaFormCapacitacion.js"%>
    </script>
  </body>

</html>