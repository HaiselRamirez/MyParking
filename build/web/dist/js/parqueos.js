$(function(){
  $("#tblParqueos").dataTable({
    info: false,
    ordering: false,
    language:{
      url:"dist/Spanish.json"
    },
    ajax:{
      url:"Parqueo",
      type:"POST",
      dataType:"json",
      dataSrc:""
    },
    columns:[
      {data: "parqueo"},
      {data: "nivel"},
      {data: "descripcion"},
      {data: "condicion"},
      {data: "estado"},
      {orderable:true,
        render:function(data,type,row){
          return `
            <button class="btn rounded-circle btn-info btn-sm" onclick="editarParqueo(${row.id})">
              <i class="fas fa-edit"></i>
            </button>
          `;
        }
      }
    ],
    columnDefs:[
      {
        targets: 0,
        render:function(data,type,row){
          return `<strong class="text-primary">${data}</strong>`;
        }
      }
    ]
  });
});


function editarParqueo(id){
  
}