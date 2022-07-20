<nav class="navbar bg-secondary-500">
  <jsp:include page="./popup_no_imp.jsp"/>

  <ul class="navbar__main">
    <li class="navbar__item"><span class="navbar__icon material-icons"><span class="material-symbols-outlined">
              account_box
            </span></span><a class="navbar__link" href="#">Resumen</a></li>
    <li class="navbar__item "><span class="material-icons">contact_support</span><a
            class="navbar__link" href="${pageContext.request.contextPath}/Contacto">Contacto</a></li>

    <li class="navbar__item">
      <span class="material-icons">school</span>
      <a class="navbar__link" href="${pageContext.request.contextPath}/capacitacion?op=listar">Capacitaciones</a>
      <span class="material-icons caret">expand_more</span>
    </li>


    <li class="navbar__item">
      <span class="material-icons">diversity_3</span>
      <a onclick="toggle()" class="navbar__link" href="#">Asistentes</a>
      <span class="material-icons caret">expand_more</span>
    </li>

    <li class="navbar__item">
      <span class="material-icons">medical_services</span>
      <a onclick="toggle()" class="navbar__link" href="#">Accidentes</a>
      <span class="material-icons caret">expand_more</span>
    </li>

    <form action="CerrarSesionServlet" method="post">
      <li class="navbar__item navbar__last">
        <span class="material-icons">power_settings_new</span>
        <input class="navbar__link fixinput" type="submit" value="Cerrar Sesion">
      </li>
    </form>
  </ul>

  <div class="infoUsuario">
    <img class="infoUsuario__img" src="https://unsplash.it//60/60" alt="">

    <div class="infoUsuario__info">
      <p class="infoUsuario__nombre">${usuario}</p>
      <p class="infoUsuario__perfil">Perfil ${perfil}</p>
    </div>
  </div>
</nav>
