<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

  <head>
    <jsp:include page="componentes/head.jsp"/>
    <title>Iniciar Sesion</title>
  </head>

  <body>
    <main class="login__container">
      <jsp:include page="/static/views/componentes/popup_detalle.jsp"/>
      <div class="login__window">

        <h1 class="main__title main__title--strong">Bienvenido</h1>
        <h3 class="subtitle">Para ingresar al sistema debe iniciar sesión.</h3>

        <form class="formulario__log" action="login" method="post">

          <div class="formulario__campo">
            <label class="formulario__label" for="usuario">Nombre de usuario :</label>
            <input class="formulario__input" type="text" name="usuario" id="usuario">

            <label class="formulario__label" for="pass">Contraseña :</label>
            <input class="formulario__input" type="password" name="pass" id="pass">

            <label class="formulario__label">Mantener sesion abierta</label>
            <div class="button__container--center">
              <input class="button button--primary hlp-alg-cnt" type="submit" value="Iniciar Sesión ">
            </div>
          </div>

        </form>
        <a onclick="showInfo('Cuenta Perfil Cliente:<br> Nombre: cliente<br>Pass: 1234<br><br> Cuenta Perfil Admin: <br> Nombre: admin <br> Pass: 1234')"
           class="link--muted mt-05" href="#">¿Cómo puedo ingresar?</a>
      </div>
    </main>
    <script>
        <%@include file="../scripts/script.js" %>
    </script>

  </body>

</html>