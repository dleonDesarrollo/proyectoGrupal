<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <style>
      <%@include file="../css/style.css"%>
    </style>
    <title>Bienvenido</title>
  </head>

  <body>
    <nav class="principal__nav"></nav>

    <main class="principal__main">
      <div class="principal__container">
        <h1 class="principal__titulo">PREDER</h1>
        <h3 class="principal__sub">Plataforma de gestion para empresas.</h3>
        <div class="button__container--center">
          <a href="${pageContext.request.contextPath}/login" class="button button--welcome mt-4">INGRESAR</a>
        </div>

      </div>
    </main>

    <footer class="principal__foot">
      <p>Los Huasos TECH 2022. Todos los derechos reservados</p>
    </footer>
  </body>

</html>