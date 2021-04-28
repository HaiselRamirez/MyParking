/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.UsuariosDAO;
import Modelo.Usuarios;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
  Map<Integer, String> map = new HashMap<Integer, String>();
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    listarUsuarios(request, response);
    String act = request.getParameter("accion");
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
    us.setClave(request.getParameter("tuUsuario"));
    us.setNombre(request.getParameter("tuNombre"));
    us.setEmail(request.getParameter("tuCorreo"));
    us.setCargo(request.getParameter("tuCargo"));
    us.setTanda(request.getParameter("tuTanda"));
    boolean add = dao.agregar(us);
    if(add == true){
     map.put(1, "success");
     map.put(2, "Usuario agregado correctamente");
    }else{
      map.put(1, "error");
      map.put(2, "Ocurrió un error al agregar al usuario");
    }
    responderJson(map, response);
  }
  
  private void editarUsuario(HttpServletRequest request, HttpServletResponse response) {
    
  }

  private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void unUsuario(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

  private void responderJson(Map<Integer, String> map, HttpServletResponse response) throws IOException {
   Gson gson = new Gson();
    String json = gson.toJson(map);
    PrintWriter printer = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("utf-8");
    printer.write(json);
    printer.close();
  }
  
  
}