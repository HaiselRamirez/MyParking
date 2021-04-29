
function cambioDiv(){
  $("#divTblUsuarios").toggleClass('d-none');
  $("#divFormUsuarios").toggleClass('d-none');
}

function cambio2Div(){
  $("#divTblUsuarios").toggleClass('d-none');
  $("#divEditUsuarios").toggleClass('d-none');
}

$("#frmEditUsuario").submit(function(e){
  e.preventDefault();
  $.ajax({
    type: "POST",
    url: "Usuarios",
    data: $(this).serialize(),
    dataType: "json",
    success: function (data) {
      msg(data);     
    }
  });
});

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
          <button class="btn btn-flat btn-sm btn-info rounded-circle" onclick="editarUsuarios(${row.id});">
            <i class="fas fa-pencil-alt"></i>
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
          return `<span class="badge badge-success"><i class="fas fa-user-check"></i> Activo</span>`;
        }else{
          return `<span class="badge badge-danger"><i class="fas fa-user-lock"></i> Inactivo</span>`;
        }
        
      }
    },
  ]

});

$("#frmAddUsuario").submit(function(e){
  e.preventDefault();
  $.ajax({
    type: "POST",
    url: "Usuarios",
    data: $(this).serialize(),
    dataType: "json",
    success: function (data) {
      msg(data);     
    }
  });
});

function editarUsuarios(id){
  let datos = {"id":id,"accion": "list"};
  $.ajax({
    type: "POST",
    url: "Usuarios",
    data: datos,
    dataType: "json",
    success: function (da) {
      cargarFrmEditar(da);
    }
  });
}

function cargarFrmEditar(da){
  debugger;
  $("#t_Id").val(da.id);
  $("#t_Usuario").val(da.usuario);
  $("#t_Clave").val(da.clave);
  $("#t_Nombre").val(da.nombre);
  $("#t_Correo").val(da.correo);
  $("#t_Cargo").val(da.cargo);
  $("#t_Tanda").val(da.tanda);
  if(da.estado == "true"){
    $("#t_Estado").val(1);
  }else{
    $("#t_Estado").val(0);
  }
  cambio2Div();
}

function msg(data){
  const Toast = Swal.mixin({
    toast: true,
    position: 'bottom-end',
    showConfirmButton: false,
    timer: 6000,
    timerProgressBar: true,
    didOpen: (toast) => {
      toast.addEventListener('mouseenter', Swal.stopTimer)
      toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
  });
  Toast.fire({
    icon: data.code,
    title: data.mensaje
  }).then((result) => {
    if (result.dismiss === Swal.DismissReason.timer) {
      location.reload();
    }
  })
}
