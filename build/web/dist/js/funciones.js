$(function(){
startTime();
});


function startTime() {
  var today = new Date();
  var hr = today.getHours();
  var min = today.getMinutes();
  var sec = today.getSeconds();
  ap = (hr < 12) ? "<span>AM</span>" : "<span>PM</span>";
  hr = (hr == 0) ? 12 : hr;
  hr = (hr > 12) ? hr - 12 : hr;
  //Add a zero in front of numbers<10
  hr = checkTime(hr);
  min = checkTime(min);
  sec = checkTime(sec);
  document.getElementById("clock").innerHTML = hr + ":" + min + ":" + sec + " " + ap;
  
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
function checkTime(i) {
  if (i < 10) {
    i = "0" + i;
  }
  return i;
}


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