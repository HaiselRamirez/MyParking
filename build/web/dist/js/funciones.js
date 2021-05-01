$(function(){
startTime();
});


function startTime() {
  var today = new Date();
 
  var months = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Augosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
  var days = ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado'];
  var curWeekDay = days[today.getDay()];
  var curDay = today.getDate();
  var curMonth = months[today.getMonth()];
  var curYear = today.getFullYear();
  var date = curWeekDay+", "+curDay+" "+curMonth+" "+curYear;
  document.getElementById("date").innerHTML = date;
    var time = setTimeout(function(){ startTime() }, 500);
};

/* funcion para resentar los mensajes del sistema*/

function mensaje(tipo, msj){
  let type = null; let clase = null; let titulo = null; let mensaje = msj;
  if(tipo =="E"){
    type = 'error'; clase = 'danger'; titulo = 'Error';
  }else if(tipo == "W"){
    type = 'question'; clase = 'warning'; titulo = '?';
  }else if(tipo =="I"){
    type = 'info'; clase = 'info'; titulo = 'Información!';
  }else if(tipo =="S"){
    type = 'success'; clase = 'success'; titulo = "Bien!";
  }

  Swal.fire({
    position: 'center',
    icon: type,
    title: titulo,
    text: mensaje,
    timer: 4000
  });
}


$("#btnSalir").click(function(e){
  Swal.fire({
    title: 'Quiere salir del sistema?',
    showCancelButton: true,
    confirmButtonText: `Si, Salir!`,
    cancelButtonText: `No`
  }).then((result) => {
    if (result.isConfirmed) {
      cerrarSesion();
    }
  });
});

function cerrarSesion(){
  $.ajax({
    type: "POST",
    url: "Login",
    data: {"accion": "salir"},
    dataType: "json",
    success: function (d) {
      if(d.code == "success"){
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Hasta luego!',
          showConfirmButton: false,
          timer: 1500
        }).then((result)=>{
          if (result.dismiss === Swal.DismissReason.timer) {
            location.reload();
          }
        });
      }else{
        console.log(d);
      }
    }
  });
}
