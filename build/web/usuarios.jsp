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
            <div class="col-9"></div>
            <div class="col-3">
              <button class="btn btn-block btn-dark" onclick="cambioDiv();"><i class="fas fa-user-plus"></i> NUEVO USUARIO</button>
            </div>
          </div>
        </div>
        <div class="card-body">
          <div class="table-responsive">
             <table class="table table-sm table-hover table-bordered" id="tblUsuarios">
               <thead class="text-center">
                <tr>
                  <th>Id</th>
                  <th>Usuario</th>
                  <th>Nombre</th>
                  <th>Email</th>
                  <th>Cargo</th>
                  <th>Tanda</th>
                  <th>Estado</th>
                  <th></th>
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
<!-- Formulario para agregar un usuario -->
  <div class="row d-none" id="divFormUsuarios">
    <div class="col-12">
      <div class="card elevation-2">
          <div class="card-header">
            <h3 class="card-title"><i class="fas fa-user-plus"></i> Formulario para nuevo usuario</h3>
          </div>
          <div class="card-body">
            <form action="Usuarios_c" method="POST" id="frmAddUsuario">
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
                    </select>
                  </div>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-6"></div>
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
<!-- Formulario para editar un usuario -->
  <div class="row d-none" id="divEditUsuarios">
    <div class="col-12">
      <div class="card elevation-2">
          <div class="card-header">
            <h3 class="card-title"><i class="fas fa-user-edit"></i> Editar Informacion de usuario</h3>
          </div>
          <div class="card-body">
            <form action="Usuario_c?accion=editar" method="POST" id="frmEditUsuario">
              <div class="row">
                <input type="hidden" name="teuId" id="teuId">
                <div class="col-3">
                  <div class="form-group">
                    <label for="tuUsuario">Usuario: </label>
                    <input type="text" class="form-control" id="teuUsuario" name="teuUsuario" readonly >
                  </div>
                </div>
                <div class="col-4">
                  <div class="form-group">
                    <label for="tuClave">Contraseña: </label>
                    <input type="password" class="form-control" id="teuClave" name="teuClave" placeholder="Contraseña">
                  </div>
                </div>
                <div class="col-5">
                  <div class="form-group">
                    <label for="tuNombre">Nombre: </label>
                    <input type="text" class="form-control" id="teuNombre" name="teuNombre" placeholder="Nombre">
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-5">
                  <div class="form-group">
                    <label for="tuCorreo">Correo electronico: </label>
                    <input type="mail" class="form-control" id="teuCorreo" name="teuCorreo" placeholder="example@mail.com">
                  </div>
                </div>
                <div class="col-4">
                  <div class="form-group">
                    <label for="tuCargo">Cargo:</label>
                    <select class="form-control" id="teuCargo" name="teuCargo" >
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
                    <select class="form-control" id="teuTanda" name="teuTanda">
                      <option value="">Seleccione...</option>
                      <option value="matutino">Matutino</option>
                      <option value="vespertino">Vespertino</option>
                      <option value="nocturno">Nocturno</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="row mt-2">
                <div class="col-6"></div>
                <div class="col-3">
                  <button class="btn btn-block btn-dark" type="submit">
                    <i class="fas fa-save"></i>
                    <span>EDITAR</span>
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
</section>



<%@include file="footer.jsp" %>
  <script src="dist/js/usuarios.js"></script>
  </body>
</html>
