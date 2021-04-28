
function cambioDiv(){
  $("#divTblUsuarios").toggleClass('d-none');
  $("#divFormUsuarios").toggleClass('d-none');
}

function cambio2Div(){
  $("#divTblUsuarios").toggleClass('d-none');
  $("#divEditUsuarios").toggleClass('d-none');
}


$("#tblUsuarios").dataTable({
  ordering: false,
  language:{
    url: 'dist/Spanish.json'
  },
  ajax:{
    type: "POST",
    url: "Usuarios",
    dataType: "json",
    dataSrc:""
  },
  columns:[
    {data:"id"},
    {data:"user"},
    {data:"nombre"},
    {data:"email"},
    {data:"cargo"},
    {data:"tanda"},
    {data:"estado"},
    {orderable:true,
      render:function(data,type,row){
        return `
          <button class="btn btn-flat btn-sm btn-info rounded-circle">
            <i class="fas fa-pencil-alt"></i>
          </button>
          <button class="btn btn-flat btn-sm btn-danger rounded-circle">
            <i class="fas fa-trash"></i>
          </button>
        `;
      }
    }
  ],
  columnDefs:[
    {
      targets: 0,
      searchable: false,
      render:function(data,type,row){
        return `<strong class="text-navy">${data}</strong>`;
      }
    },
    {
      targets: 1,
      render:function(data,type,row){
        return `<strong class="text-primary">${data}</strong>`;
      }
    },
    {
      targets: 4,
      render:function(data,type,row){
        if(data =="admin"){
          return `<span class="text-primary"><i class="fas fa-user-cog"></i> Administrador</span>`;
        }else if(data == "caja"){
          return `<span class="text-info"><i class="fas fa-user-tag"></i> Cajero</span>`;
        }else{
          return `<span class="text-dark"><i class="fas fa-user-shield"></i> Vigilante</span>`;
        }
        
      }
    },
    {
      targets: 5,
      render:function(data,type,row){
        if(data =="matutino"){
          return `<span class="text-dark"><i class="fas fa-cloud-sun"></i> Matutino</span>`;
        }else if(data == "vespertino"){
          return `<span class="text-dark"><i class="fas fa-cloud-meatball"></i> Vespertino</span>`;
        }else if(data == "nocturno"){
          return `<span class="text-dark"><i class="fas fa-cloud-moon"></i> Nocturno</span>`;
        }else{
          return `<span class="text-warning"> Indefinido</span>`;
        }
        
      }
    },
    {
      targets: 6,
      render:function(data,type,row){
        if(data ==true){
          return `<span class="badge badge-primary"><i class="fas fa-user-check"></i> Activo</span>`;
        }else{
          return `<span class="badge badge-danger"><i class="fas fa-user-lock"></i> Inactivo</span>`;
        }
        
      }
    },
  ]

});

$("#frmAddUsuario").submit(function(e){
  e.preventDefault();
  if(validarCampos() == true){
    $.ajax({
      type: "POST",
      url: "Usuarios",
      data: {"accion": "agregar"},
      dataType: "json",
      success: function (response) {
        console.log(response);
      }
    });
  }
})

function validarCampos(){
  let r = false;
  let Usuario = $("#tuUsuario").val().toString();
  let Clave = $("#tuClave").val().toString();
  let Nombre = $("#tuNombre").val().toString();
  let Correo = $("#tuCorreo").val().toString();
  let Cargo = $("#tuCargo").val().toString();
  let Tanda = $("#tuTanda").val().toString();
  if(Usuario == "" || null){
    mensaje("E", "El usuario es requerido");
  }
  return r;
}