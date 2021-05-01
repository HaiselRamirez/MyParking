
package Controlador;

import DAO.ParqueoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Parqueo_c extends HttpServlet {
  Parqueo_c p = new Parqueo_c();
  ParqueoDAO dao = new ParqueoDAO();
  Map<String,Object>map = new HashMap<String,Object>();
  
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
    String act = request.getParameter("accion");
    switch (act){
      case "agregar":
        nuevoParqueo(map, response);
    }
  }

  
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  private void nuevoParqueo(Map<String, Object> map, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  
  private void responseJson(List<Parqueo_c> list, HttpServletResponse response) throws IOException {
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
