package Controlador;

import DAO.UsuariosDAO;
import Modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

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
      String accion = request.getParameter("accion");
      try {
        if(accion != null){
          switch(accion){
            case "entrar":
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
          this.getServletConfig().getServletContext().getRequestDispatcher("/mensaje.jsp").forward    (request, response);
        } catch (Exception ex) {
          System.out.println("Error " + ex.getMessage());
        }
    }
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  
  protected void verificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
