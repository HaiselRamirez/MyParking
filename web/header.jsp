<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
  <body class="hold-transition sidebar-mini">
  <div class="wrapper">
    <nav class="main-header navbar navbar-expand navbar-dark navbar-dark">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item"><span class="text-muted my-auto mx-2" id="date"></span></li>
        <li class="nav-item dropdown">
          <a class="nav-link" data-toggle="dropdown" href="#">
            <i class="fas fa-user-check text-success"></i>
            <strong><%=session.getAttribute("user")%></strong>
          </a>
          <div class="dropdown-menu dropdown-menu-right mt-2">
            <a href="#" class="dropdown-item">
              <i class="fas fa-user mr-2"></i> Mi cuenta
            </a>
            <a href="#" class="dropdown-item">
              <i class="fas fa-edit mr-2"></i> Cambiar Clave
            </a>
            <a href="#" class="dropdown-item" id="btnSalir">
              <i class="fas fa-power-off mr-2"></i> Cerrar Sesión
            </a>
          </div>
        </li>
      </ul>
    </nav>
    
    
    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index.jsp" class="brand-link">
      <img src="dist/img/AdminLTELogo.png" alt="Logo" class="brand-image img-circle elevation-3">
      <span class="brand-text font-weight-bold">MyParking</span>
    </a>
    <!-- Sidebar -->
    <div class="sidebar">
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false" id="menu">
          <li class="nav-item">
            <a href="registro.jsp" class="nav-link">
              <i class="nav-icon fas fa-car"></i>
              <p>Registro</p>
            </a>
          </li>
           <li class="nav-item">
            <a href="salida.jsp" class="nav-link">
              <i class="nav-icon fas fa-hand-holding-usd"></i>
              <p>Salida</p>
            </a>
          </li>
          <%
            if("admin".equals(session.getAttribute("cargo"))){
          %>
            <li class="nav-header">
              <h5><i class="fas fa-cogs"></i> Administracion</h5>
            </li>
            <li class="nav-item">
              <a href="usuarios.jsp" class="nav-link">
                <i class="nav-icon fas fa-users"></i>
                <p> Usuarios</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="parqueos.jsp" class="nav-link">
                <i class="nav-icon fas fa-parking"></i>
                <p> Parqueos</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="precios.jsp" class="nav-link">
                <i class="nav-icon fas fa-dollar-sign"></i>
                <p> Precios</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link">
                <i class="nav-icon fas fa-file-invoice-dollar"></i>
                <p>
                  Reportes
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="#" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>Por fecha</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="#" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>Por tipo de Vehiculos</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="#" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>Por usuarios</p>
                  </a>
                </li>
              </ul>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link">
                <i class="nav-icon fas fa-cogs"></i>
                <p>
                  Configuraciones
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="#" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>Datos de la empresa</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="#" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p></p>
                  </a>
                </li>
              </ul>
            </li>
          <%}%>
        </ul>
      </nav>
    </div>
  </aside>
  <div class="content-wrapper">