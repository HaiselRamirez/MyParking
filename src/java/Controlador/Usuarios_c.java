/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.UsuariosDAO;
import Modelo.Usuarios;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Usuarios_c extends HttpServlet {
  Usuarios us = new Usuarios();
  UsuariosDAO dao = new UsuariosDAO();
 
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      String accion = request.getParameter("accion");
      try {
        if(accion != null){
          switch(accion){
            case "verificar":
             verificar(request, response);
             break;
            case "cerrar":
              cerrarSession(request, response);
              break;
            default:
              response.sendRedirect("login.jsp");
          }
        }else{
          response.sendRedirect("login.jsp");
        }
    } catch (Exception e) {
        try {
          this.getServletConfig().getServletContext().getRequestDispatcher("/mensaje.jsp").forward(request, response);
        } catch (Exception ex) {
          System.out.println("Error " + ex.getMessage());
        }
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String act = request.getParameter("accion");
    if(act.equalsIgnoreCase("Agregar")){
      us.setUser(request.getParameter("tuUsuario"));
      us.setClave(request.getParameter("tuClave"));
      us.setNombre(request.getParameter("tuNombre"));
      us.setEmail(request.getParameter("tuCorreo"));
      us.setCargo(request.getParameter("tuCargo"));
      us.setTanda(request.getParameter("tuTanda"));
      if(dao.agregar(us)){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Map<String,String> map = new HashMap<String,String>();
        
      }
    }else if(act.equalsIgnoreCase("Login")){
      us.setUser(request.getParameter("txtUser"));
      us.setClave(request.getParameter("txtPass"));
      Usuarios u = dao.validar(us);
      
    }
  }
  
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  private void verificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession sesion;
    UsuariosDAO dao;
    Usuarios usu;
    usu = this.obtenerUsuario(request);
    dao = new UsuariosDAO();
    usu = dao.validar(usu);
    if(usu != null){
      sesion = request.getSession();
      sesion.setAttribute("usuario", usu);
      sesion.setAttribute("mensaje", "Bienvenido al sistema");
      this.getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }else{
      request.setAttribute("mensaje","Usuario y/o clave incorrecta");
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
  }
  private void cerrarSession(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    HttpSession sesion = request.getSession();
    sesion.setAttribute("usuario", null);
    sesion.invalidate();
    response.sendRedirect("login.jsp");
  }

  private Usuarios obtenerUsuario(HttpServletRequest request) {
    Usuarios u = new Usuarios();
    u.setUser(request.getParameter("txtUser"));
    u.setClave(request.getParameter("txtPass"));
    return u;
  }
}
