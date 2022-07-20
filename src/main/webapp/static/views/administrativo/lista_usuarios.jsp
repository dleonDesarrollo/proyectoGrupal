<%@ page import="model.entity.Cliente" %>
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
      <jsp:include page="../componentes/popup_detalle.jsp"/>
      <main class="main" id="blur">
        <h2>Panel de Usuarios</h2>
        <h3 class="subtitle mb-1">Lista de usuarios registrados en el sistema</h3>

        <table id="users" class="display">
          <thead>
            <tr>
              <th>Rut Usuario</th>
              <th>Nombre</th>
              <th>F. Nacimiento</th>
              <th>Perfil</th>
              <th>___</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="cliente" items="${listaClientes}">

              <tr>

                <td>${cliente.run}</td>
                <td>${cliente.nombre}</td>
                <td>${cliente.fechaNacimiento}</td>
                <td>${cliente.getPerfil()}</td>
                <td>
                    <%--    COLOCAR LINKS ACA      --%>
                  <div class="tooltip">
                    <a onclick="showInfo('${cliente}')"><i class="fa-solid fa-eye btn-icon"></i></a>
                    <span class="tooltip__text">Detalles</span>
                  </div>

                  <div class="tooltip-r">
                    <a href="${pageContext.request.contextPath}/gestionusuarios?op=edit&perf=${cliente.getPerfil()}&id=${cliente.run}"><i
                            class="fa-solid fa-user-pen btn-icon"></i></a>
                    <span class="tooltip-r__text">Editar</span>
                  </div>

                </td>
              </tr>
            </c:forEach>
            <c:forEach var="admin" items="${listaAdmin}">

              <tr>

                <td>${admin.run}</td>
                <td>${admin.nombre}</td>
                <td>${admin.fechaNacimiento}</td>
                <td>${admin.getPerfil()}</td>
                <td>
                    <%--    COLOCAR LINKS ACA      --%>


                  <div class="tooltip">
                    <a onclick="showInfo('${admin}')"><i class="fa-solid fa-eye btn-icon"></i></a>
                    <span class="tooltip__text">Detalles</span>
                  </div>
                  <div class="tooltip-r">
                    <a href="${pageContext.request.contextPath}/gestionusuarios?op=edit&perf=${admin.getPerfil()}&id=${admin.run}"><i
                            class="fa-solid fa-user-pen btn-icon"></i></a>
                    <span class="tooltip-r__text">Editar</span>
                  </div>


                </td>
              </tr>
            </c:forEach>
            <c:forEach var="prof" items="${listaProf}">

              <tr>

                <td>${prof.run}</td>
                <td>${prof.nombre}</td>
                <td>${prof.fechaNacimiento}</td>
                <td>${prof.getPerfil()}</td>
                <td>
                    <%--    COLOCAR LINKS ACA      --%>
                  <div class="tooltip">
                    <a onclick="showInfo('${prof}')"><i class="fa-solid fa-eye btn-icon"></i></a>
                    <span class="tooltip__text">Detalles</span>
                  </div>
                  <div class="tooltip-r">
                    <a href="${pageContext.request.contextPath}/gestionusuarios?op=edit&perf=${prof.getPerfil()}&id=${prof.run}"><i
                            class="fa-solid fa-user-pen btn-icon"></i></a>
                    <span class="tooltip-r__text">Editar</span>
                  </div>


                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        <div class="button__container">
          <a type="reset" href="${pageContext.request.contextPath}/gestionusuarios?op=nuevoC"
             class="button button--op"><i class="fa-solid fa-user-plus"></i> Cliente</a>
          <a type="reset" href="${pageContext.request.contextPath}/gestionusuarios?op=nuevoP"
             class="button button--op"><i class="fa-solid fa-user-plus"></i> Profesional</a>
          <a type="reset" href="${pageContext.request.contextPath}/gestionusuarios?op=nuevoA"
             class="button button--op"><i class="fa-solid fa-user-plus"></i> Administrativo</a>
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