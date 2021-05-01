<%
  if("on".equals(session.getAttribute("login"))){
    if("admin".equals(session.getAttribute("cargo"))){
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<section class="content-header">
  <div class="container-fluid">
    <div class="row mb-2">
      <div class="col-sm-6">
        <h1> <i class="fas fa-users"></i> Usuarios</h1>
      </div>
      <div class="col-sm-6">
      </div>
    </div>
  </div><!-- /.container-fluid -->
</section>

<section class="content">
  <!-- Tabla que presenta los usuarios de la base de datos -->
  <div class="row mt-3" id="divTblUsuarios">
    <div class="col-12">
      <div class="card">
        <div class="card-header">
          <div class="row">
            <div class="col-9">
              <h4 class="card-title"><i class="fas fa-list"></i> Lista de los usuarios del sistema</h4>
            </div>
            <div class="col-3">
              <button class="btn btn-block btn-dark" onclick="cambioDiv();"><i class="fas fa-user-plus"></i> NUEVO USUARIO</button>
            </div>
          </div>
        </div>
        <div class="card-body">
          <div class="table-responsive w-100">
             <table class="table table-sm table-hover" id="tblUsuarios">
               <thead>
                <tr>
                  <th>Usuario</th>
                  <th>Nombre</th>
                  <th>Email</th>
                  <th>Cargo</th>
                  <th>Tanda</th>
                  <th>Estado</th>
                  <th><i class="fas fa-user-edit"></i></th>
                </tr>
              </thead>
              <tbody>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
<!-- Fin del div-->
<!-- Formulario para agregar un usuario -->
  <div class="row d-none" id="divFormUsuarios">
    <div class="col-12">
      <div class="card elevation-2">
          <div class="card-header">
            <h3 class="card-title"><i class="fas fa-user-plus"></i> Formulario para nuevo usuario</h3>
          </div>
          <div class="card-body">
            <form action="Usuarios" method="POST" id="frmAddUsuario">
              <div class="row">
                <div class="col-3">
                  <div class="form-group">
                    <label for="tuUsuario">Usuario: </label>
                    <input type="text" class="form-control" id="tuUsuario" name="tuUsuario" placeholder="Usuario">
                  </div>
                </div>
                <div class="col-4">
                  <div class="form-group">
                    <label for="tuClave">Contraseña: </label>
                    <input type="password" class="form-control" id="tuClave" name="tuClave" placeholder="Contraseña">
                  </div>
                </div>
                <div class="col-5">
                  <div class="form-group">
                    <label for="tuNombre">Nombre: </label>
                    <input type="text" class="form-control" id="tuNombre" name="tuNombre" placeholder="Nombre">
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-5">
                  <div class="form-group">
                    <label for="tuCorreo">Correo electronico: </label>
                    <input type="mail" class="form-control" id="tuCorreo" name="tuCorreo" placeholder="example@mail.com">
                  </div>
                </div>
                <div class="col-4">
                  <div class="form-group">
                    <label for="tuCargo">Cargo:</label>
                    <select class="form-control" id="tuCargo" name="tuCargo" >
                      <option value="">Seleccione...</option>
                      <option value="caja">Cajero</option>
                      <option value="admin">Administrador</option>
                      <option value="vigil">Vigilante</option>
                    </select>
                  </div>
                </div>
                <div class="col-3">
                  <div class="form-group">
                    <label for="tuTanda">Hotario:</label>
                    <select class="form-control" id="tuTanda" name="tuTanda">
                      <option value="">Seleccione...</option>
                      <option value="matutino">Matutino</option>
                      <option value="vespertino">Vespertino</option>
                      <option value="nocturno">Nocturno</option>
                      <option value="na">Indefinida</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-6">
                  <input type="hidden" name="accion" value="agregar">
                </div>
                <div class="col-3">
                  <button class="btn btn-block btn-dark" type="submit">
                    <i class="fas fa-save"></i>
                    <span>AGREGAR</span>
                  </button>
                </div>
                <div class="col-3">
                  <button class="btn btn-block btn-danger" type="button" onclick="cambioDiv();">
                    <i class="fas fa-times"></i>
                    <span> CANCELAR</span>
                  </button>
                </div>
              </div>
            </form>
          </div>
      </div>
    </div>
  </div>
<!-- Fin del div-->
<!-- Formulario para editar un usuario -->
  <div class="row d-none" id="divEditUsuarios">
    <div class="col-12">
      <div class="card elevation-2">
          <div class="card-header">
            <h3 class="card-title"><i class="fas fa-user-edit"></i> Editar Informacion de usuario</h3>
          </div>
          <div class="card-body">
            <form action="#" method="POST" id="frmEditUsuario">
              <div class="row">
                <input type="hidden" name="t_Id" id="t_Id">

                <input type="hidden" name="accion" value="editar">
                <div class="col-3">
                  <div class="form-group">
                    <label for="t_Usuario">Usuario: </label>
                    <input type="text" class="form-control" id="t_Usuario" name="t_Usuario" readonly >
                  </div>
                </div>
                <div class="col-4">
                  <div class="form-group">
                    <label for="t_Clave">Contraseña: </label>
                    <input type="password" class="form-control" id="t_Clave" name="t_Clave" placeholder="Contraseña" required>
                  </div>
                </div>
                <div class="col-5">
                  <div class="form-group">
                    <label for="t_Nombre">Nombre: </label>
                    <input type="text" class="form-control" id="t_Nombre" name="t_Nombre" placeholder="Nombre" required>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-5">
                  <div class="form-group">
                    <label for="t_Correo">Correo electronico: </label>
                    <input type="mail" class="form-control" id="t_Correo" name="t_Correo" placeholder="example@mail.com" required>
                  </div>
                </div>
                <div class="col-4">
                  <div class="form-group">
                    <label for="t_Cargo">Cargo:</label>
                    <select class="form-control" id="t_Cargo" name="t_Cargo" required>
                      <option value="">Seleccione...</option>
                      <option value="caja">Cajero</option>
                      <option value="admin">Administrador</option>
                      <option value="vigil">Vigilante</option>
                    </select>
                  </div>
                </div>
                <div class="col-3">
                  <div class="form-group">
                    <label for="t_Tanda">Hotario:</label>
                    <select class="form-control" id="teuTanda" name="t_Tanda" required>
                      <option value="">Seleccione...</option>
                      <option value="matutino">Matutino</option>
                      <option value="vespertino">Vespertino</option>
                      <option value="nocturno">Nocturno</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-2">
                  <div class="form-group text-right">
                    <label for="t_Estado">Estado:</label>
                  </div>
                </div>
                <div class="col-3">
                  <select name="t_Estado" id="t_Estado" class="form-control" required>
                    <option value="1">Activo</option>
                    <option value="0">Inactivo</option>
                  </select>
                </div>
                <div class="col-1"></div>
                <div class="col-3">
                  <button class="btn btn-block btn-dark" type="submit">
                    <i class="fas fa-save"></i>
                    <span>GUARDAR CAMBIOS</span>
                  </button>
                </div>
                <div class="col-3">
                  <button class="btn btn-block btn-danger" type="reset" onclick="cambio2Div();">
                    <i class="fas fa-times"></i>
                    <span> CANCELAR</span>
                  </button>
                </div>
              </div>
            </form>
          </div>
      </div>
    </div>
  </div>
<!-- Fin del div-->
</section>
<%@include file="footer.jsp" %>
  <script src="dist/js/usuarios.js"></script>
  </body>
</html>
<%
    }else{
      response.sendRedirect("index.jsp");
    }
}else{
  response.sendRedirect("login.jsp");
}
%>
