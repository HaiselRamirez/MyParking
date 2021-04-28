<%--<%
  if(session.getAttribute("usu") != null){
%>--%>
<%@include file="header.jsp"%>
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1> <i class="fas fa-parking"></i> MyParking</h1>
          </div>
          <div class="col-sm-6">
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
    <section class="content">
      <div class="row">
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-primary">
            <div class="inner">
              <h3>0</h3>

              <p>Vehiculos parqueados</p>
            </div>
            <div class="icon">
              <i class="fas fa-car"></i>
            </div>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-green">
            <div class="inner">
              <h3>0</h3>

              <p>Parqueos Disponibles</p>
            </div>
            <div class="icon">
              <i class="fas fa-parking"></i>
            </div>
            
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3>0</h3>

              <p>Registros del dia</p>
            </div>
            <div class="icon">
              <i class="fa fa-check"></i>
            </div>
            
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-red">
            <div class="inner">
              <h3>RD$:0.00</h3>

              <p>Pesos cobrado</p>
            </div>
            <div class="icon">
              <i class="fas fa-donate"></i>
            </div>
            
          </div>
        </div>
        <!-- ./col -->
      </div>
      <div class="row mt-5">
        <div class="col-12">
          <div class="card">
            <div class="card-header">
              <h3 class="card-title">Detalles de los registros activos</h3>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-sm table-bordered">
                  <thead>
                    <tr>
                      <th>Placa</th>
                      <th>Tipo de auto</th>
                      <th>Fecha de entrada</th>
                      <th>Hora de entrada</th>
                      <th>Parqueo</th>
                      <th>Usuario</th>
                      <th>Observación</th>
                    </tr>
                  </thead>
                  <tbody></tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
<%@include file="footer.jsp"%>
  </body>
</html>

<%-- <%}else{ --%>
<%--response.sendRedirect("login.jsp");--%>
<%--}%> --%>
