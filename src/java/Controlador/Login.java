
package Controlador;

import DAO.UsuariosDAO;
import Modelo.Usuarios;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
  UsuariosDAO dao = new UsuariosDAO();
  Usuarios us = new Usuarios();
  HttpSession session;
  
  Map<String,String> map = new HashMap<String,String>();
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
  }


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
          String act;
          act = request.getParameter("accion");
          if(act !=null){
            if("entrar".equals(act)){
              entrar(request, response);
            }else if("salir".equals(act)){
              salir(request, response);
            }
          }else{}
  }

 
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  private void entrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String user = request.getParameter("user");
    String pass = request.getParameter("pass");
    us=dao.validar(user, pass);
    if(us.getUser() != null){
      if(us.isEstado()){
        session= request.getSession();
        session.setAttribute("login", "on");
        session.setAttribute("nombre",us.getNombre());
        session.setAttribute("user",us.getUser());
        session.setAttribute("clave",us.getClave());
        session.setAttribute("cargo",us.getCargo());
        session.setAttribute("tanda",us.getTanda());
        session.setAttribute("correo",us.getEmail());
        map.put("code", "success");
        map.put("mensaje", "Bienvenid@ a MyParking");
        map.put("nombre", us.getNombre());
      }else{
        map.put("code", "error");
        map.put("mensaje", "Usuario deshabilitado, favor contactar el administrador");
      }
    }else{
       map.put("code", "error");
       map.put("mensaje", "Usuario y/o contraseña incorrecta");
    }
     responderJson(map, response);
  }

  private void salir(HttpServletRequest request, HttpServletResponse response) throws IOException {
    session= request.getSession();
    session.setAttribute("login", "off");
      map.put("code", "success");
      map.put("mensaje","hasta luego");
      responderJson(map, response);
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
