<%
  if("on".equals(session.getAttribute("login"))){
    if("admin".equals(session.getAttribute("cargo"))){
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<div class="content-header">
  <div class="container-fluid">
    <div class="row mb-2">
      <div class="col-sm-8">
        <h1 class="m-0">
          <i class="fas fa-parking text-warning"></i>
          <span> Parqueos</span>
        </h1>
      </div>
      <div class="col-sm-4">
        <ol class="breadcrumb float-sm-right">
          <li class="breadcrumb-item"><a href="index.jsp">Inicio</a></li>
          <li class="breadcrumb-item active">Parqueos</li>
        </ol>
      </div>
    </div>
  </div>
</div>
<div class="content">
  <div class="container-fluid">
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-header bg-white">
            <div class="row">
              <div class="col-9">
                <h2 class="card-title"><i class="fas fa-list"></i> Lista de los parqueos que tenemos</h2>
              </div>
              <div class="col-3">
                <button class="btn btn-block btn-dark" onclick="nuevoParqueo();"  data-toggle="modal" data-target="#mNuevoParqueo">
                  <i class="fas fa-plus"></i>
                  <span>NUEVO PARQUEO</span>
                </button>
              </div>
            </div>
          </div>
          <div class="card-body table-responsive">
            <table class="table table-sm table-hover" id="tblParqueos">
              <thead>
                <tr>
                  <th>Parqueo</th>
                  <th>Nivel</th>
                  <th>Descripción</th>
                  <th>Condición</th>
                  <th>Estado</th>
                  <th><i class="fa fa-cogs"></i></th>
                </tr>
              </thead>
            </table>
            <body>
            </body>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="mNuevoParqueo" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header py-2 bg-orange">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="Parqueo" method="POST" id="fNuevoParqueo">
        <div class="modal-body">
          <input type="hidden" class="d-none" name="accion" id="tpAccion" value="agregar">
          <div class="row form-group mb-2">
            <div class="col-3 text-right">
              <label for="tpParqueo">Parqueo:</label>
            </div>
            <div class="col-4">
              <input type="text" class="form-control" id="tpParqueo" name="tpParqueo" placeholder="Parqueo" required>
            </div>
          </div>
          <div class="row form-group mb-2">
            <div class="col-3 text-right">
              <label for="tpNivel" class="text-right">Nivel:</label>
            </div>
            <div class="col-6">
              <input type="text" class="form-control" id="tpNivel" name="tpNivel" placeholder="Nivel" required>
            </div>
          </div>
          <div class="row form-group mb-2">
            <div class="col-3 text-right">
              <label for="tpCondicion" class="text-right">Condición:</label>
            </div>
            <div class="col-9">
              <input type="text" class="form-control" id="tpCondicion" name="tpCondicion" placeholder="Condición" required>
            </div>
          </div>
          <div class="row form-group mb-2">
            <div class="col-3 text-right">
              <label for="tpDescripcion" class="text-right">Descripción:</label>
            </div>
            <div class="col-9">
              <textarea class="form-control" id="tpDescripcion" name="tpDescripcion" placeholder="Descrición del parqueo">
              </textarea>
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary">
            <i class="fas fa-save"></i> GUARDAR
          </button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">
            <i class="fas fa-times"></i>  CANCELAR
          </button>
        </div>
      </form>
    </div>
  </div>
</div>

<%@include file="footer.jsp" %>
  <script src="dist/js/parqueos.js"></script>
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