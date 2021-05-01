package Controlador;

import DAO.UsuariosDAO;
import Modelo.Usuarios;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Usuarios_c extends HttpServlet {
  
  UsuariosDAO dao = new UsuariosDAO();
  Usuarios us = new Usuarios();
  Map<String, String> map = new HashMap<String, String>();
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      listarUsuarios(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    String act;
    act = request.getParameter("accion");
    if(act != null){
      switch(act){
        case "agregar":
          agregarUsuarios(request, response);
          break;
        case "editar":
          editarUsuario(request, response);
          break;
        case "eliminar":
          eliminarUsuario(request, response);
          break;
        case "list":
          unUsuario(request, response);
          break;
        default:
          listarUsuarios(request, response);
          break;
      }
    }else{
      listarUsuarios(request, response);
    }
  }
  
  @Override
  public String getServletInfo() {
    return "Short description";
  }
  private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<Usuarios>list = new ArrayList();
    list = dao.listar();
    responseJson(list, response);
  }
  
  private void agregarUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException {
    us.setUser(request.getParameter("tuUsuario"));
    us.setClave(request.getParameter("tuClave"));
    us.setNombre(request.getParameter("tuNombre"));
    us.setEmail(request.getParameter("tuCorreo"));
    us.setCargo(request.getParameter("tuCargo"));
    us.setTanda(request.getParameter("tuTanda"));
    boolean add = dao.agregar(us);
    if(add == true){
     map.put("code", "success");
     map.put("mensaje", "Usuario agregado correctamente");
    }else{
      map.put("code", "error");
      map.put("mensaje", "No se pudo agregar el nuevo usuario");
    }
    responderJson(map, response);
  }
  
  private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String estado = request.getParameter("t_Estado");
    if(estado.equalsIgnoreCase("1")){
      us.setEstado(true);
    }else{
      us.setEstado(false);
    }
    us.setUser(request.getParameter("t_Usuario"));
    us.setClave(request.getParameter("t_Clave"));
    us.setNombre(request.getParameter("t_Nombre"));
    us.setEmail(request.getParameter("t_Correo"));
    us.setCargo(request.getParameter("t_Cargo"));
    us.setTanda(request.getParameter("t_Tanda"));
    us.setId(Integer.parseInt(request.getParameter("t_Id")));
    boolean add = dao.editar(us);
    if(add == true){
     map.put("code", "success");
     map.put("mensaje", "Los cambios se guardaron correctamente");
    }else{
      map.put("code", "error");
      map.put("mensaje", "No se pudo editar información del usuario");
    }
    responderJson(map, response);
  }

  private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void unUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
   String ide = request.getParameter("id");
   Map<String,String> m = new HashMap<String,String>();
   if (ide != null){
     int id = parseInt(ide);
     Usuarios u = new Usuarios();
     u = dao.list(id);
     m.put("id",Integer.toString(u.getId()));
     m.put("usuario", u.getUser());
     m.put("clave", u.getClave());
     m.put("nombre", u.getNombre());
     m.put("correo", u.getEmail());
     m.put("cargo", u.getCargo());
     m.put("tanda", u.getTanda());
     m.put("estado",String.valueOf(u.isEstado()));
   }else{
     m.put("code", "error");
     m.put("mensaje", "El usuario no se encuentra en la base de datos");
   }
   responderJson(m,response);
  }

  private void responseJson(List<Usuarios> list, HttpServletResponse response) throws IOException {
    Gson gson = new Gson();
    String json = gson.toJson(list);
    PrintWriter printer = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("utf-8");
    printer.write(json);
    printer.close();
  }

  private void responderJson(Map<String, String> map, HttpServletResponse response) throws IOException {
   Gson gson = new Gson();
    String json = gson.toJson(map);
    PrintWriter printer = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("utf-8");
    printer.write(json);
    printer.close();
  }
}