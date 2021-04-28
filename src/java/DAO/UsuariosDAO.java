
package DAO;

import Config.Conexion;
import Interfaces.Usuarios_i;
import Modelo.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosDAO implements Usuarios_i{
  Usuarios us = new Usuarios();
  Conexion cn = new Conexion();
  Connection con;
  PreparedStatement ps;
  ResultSet rs;
  Statement ct =null;
  
  @Override
  public List listar() {
    ArrayList<Usuarios>list =new ArrayList();
    String query = "SELECT * FROM usuarios";
    try {
      con =cn.getConexion();
      ps=con.prepareStatement(query);
      rs =ps.executeQuery();
      while(rs.next()){
        Usuarios u = new Usuarios();
        u.setId(rs.getInt("id"));
        u.setUser(rs.getString("usuario"));
        u.setClave(rs.getString("clave"));
        u.setNombre(rs.getString("nombre"));
        u.setEmail(rs.getString("correo"));
        u.setCargo(rs.getString("cargo"));
        u.setTanda(rs.getString("tanda"));
        u.setEstado(rs.getBoolean("estado"));
        list.add(u);
      }
    } catch (Exception e) {
    }
    return list;
  }

  @Override
  public Usuarios list(int id) {
    Usuarios u = new Usuarios();
    String query = "SELECT * FROM usuarios WHERE id="+id;
    try {
      con =cn.getConexion();
      ps=con.prepareStatement(query);
      rs =ps.executeQuery();
    } catch (Exception e) {
    }
    
   return us;
  }

  @Override
  public boolean agregar(Usuarios us) {
    String query= "INSERT INTO usuario(usuario,clave,nombre,correo,cargo,tanda) VALUES('"+us.getUser()+"','"+us.getClave()+"', '"+us.getNombre()+"','"+us.getEmail()+"', '"+us.getCargo()+"', '"+us.getTanda()+"')";
    boolean r = false;
    try {
        con = cn.getConexion();
        ps = con.prepareStatement(query);
        ps.executeUpdate();
        r = true;
    } catch (SQLException e) {
      
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return r;
  }

  @Override
  public boolean editar(Usuarios us) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean eliminar(int id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Usuarios validar(Usuarios user) {
    String query = "SELECT * FROM usuario WHERE usuario='"+user.getUser()+"' AND clave='"+user.getClave()+"'";
    try {
      con= cn.getConexion();
      ct=con.createStatement();
      rs = ct.executeQuery(query);
      if(rs.next() == true){
        us = new Usuarios();
        us.setId(rs.getInt("id"));
        us.setUser(rs.getString("usuario"));
        us.setClave(rs.getString("clave"));
        us.setNombre(rs.getString("nombre"));
        us.setCargo(rs.getString("cargo"));
        us.setTanda(rs.getString("etanda"));
        us.setEstado(rs.getBoolean("estado"));
      }
    } catch (SQLException e) {
      System.out.println("Error: " +e.getMessage());
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
      try {
        if(rs != null && rs.isClosed() == false){
          rs.close();
        }
        if(ps != null && ps.isClosed() == false){
          ps.close();
        }
        if(ct != null && ct.isClosed() == false){
          ct.close();
        }
        cn = null;
      } catch (SQLException ex) {
        Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return us;
  }

}
