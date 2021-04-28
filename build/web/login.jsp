<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>MyParking | Login</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <h1 class="display-1 text-dark mb-0"><i class="fas fa-parking"></i></h1>
    <a href="index.jsp"><b>My</b>Parking</a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Ingresa los datos para iniciar sesión</p>
      <form action="Login" method="post" id="frmLogin">
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="txtUser" id="txtUser" placeholder="Usuario">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" name="txtPass" id="txtPass" placeholder="Contraseña">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock-open"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12">
            <button type="submit" class="btn btn-primary btn-block mb-3">Entrar</button>
            <a href="#" class="text-white font-width-bold">Olvidaste la clave?</a>
          </div>
        </div>
      </form>
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<script>
  $(function(){
   $("#frmLogin").submit(function(e){
    e.preventDefault();
     let datos = {
       "accion": "entrar",
       "usuario": $("#txtUser").val().toString(),
       "clave": $("#txtPass").val().toString()
     }
      if(datos.clave =="" || datos.clave==""){
          alert("todos los campos son necesarios");
      }else{
        $.ajax({
          type: "POST",
          url: "Login",
          data: datos,
          dataType: "json",
          success: function (response) {
            console.log(response);
          }
        });
      }
    })
  });
</script>
</body>
</html>
