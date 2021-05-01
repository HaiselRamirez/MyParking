
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
import java.util.Date;
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
    } catch (ClassNotFoundException e) {
    } catch (SQLException e) {
    }
    return list;
  }

  @Override
  public Usuarios list(int id) {
    Usuarios user;
    user = new Usuarios();
    String query = "SELECT * FROM usuarios WHERE id="+id;
    try {
      con =cn.getConexion();
      ps=con.prepareStatement(query);
      rs =ps.executeQuery();
      while(rs.next()){
        user.setId(rs.getInt("id"));
        user.setUser(rs.getString("usuario"));
        user.setClave(rs.getString("clave"));
        user.setNombre(rs.getString("nombre"));
        user.setEmail(rs.getString("correo"));
        user.setCargo(rs.getString("cargo"));
        user.setTanda(rs.getString("tanda"));
        user.setEstado(rs.getBoolean("estado"));
      }
    } catch (ClassNotFoundException e) {
    } catch (SQLException e) {
    }
   return user;
  }

  @Override
  public boolean agregar(Usuarios us) {
    String query= "INSERT INTO usuarios(usuario,clave,nombre,correo,cargo,tanda) VALUES('"+us.getUser()+"','"+us.getClave()+"', '"+us.getNombre()+"','"+us.getEmail()+"', '"+us.getCargo()+"', '"+us.getTanda()+"')";
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
    boolean res = false;
    Date fecha = new Date();

    String query = "UPDATE usuarios SET clave='"+us.getClave()+"', nombre='"+us.getNombre()+"', correo='"+us.getEmail()+"', cargo='"+us.getCargo()+"', tanda='"+us.getTanda()+"', estado="+us.isEstado()+" WHERE id="+us.getId();
    try {
      con = cn.getConexion();
      ps = con.prepareStatement(query);
      ps.executeUpdate();
      res = true;
    } catch (ClassNotFoundException e) {
      System.out.print(e.getMessage());
      res = false;
    } catch (SQLException e) {
      System.out.print(e.getMessage());
      res = false;
    }
    return res;
  }

  

  /**
   *
   * @param user
   * @param pass
   * @return
   */
  @Override
  public Usuarios validar(String user, String pass) {
    Usuarios u = new Usuarios();
    ResultSet s;
    String query = "SELECT * FROM usuarios WHERE usuario='"+user+"' AND clave='"+pass+"'";
    try {
      con=cn.getConexion();
      ps = con.prepareStatement(query);
      s = ps.executeQuery();
      while(s.next()){
        u.setId(s.getInt("id"));
        u.setUser(s.getString("usuario"));
        u.setClave(s.getString("clave"));
        u.setNombre(s.getString("nombre"));
        u.setCargo(s.getString("cargo"));
        u.setEmail(s.getString("correo"));
        u.setTanda(s.getString("tanda"));
        u.setEstado(s.getBoolean("estado"));
      }
    } catch (ClassNotFoundException ex) {
      System.out.print("Error al iniciar sesion: " +ex.getMessage());
    } catch (SQLException ex) {
      System.out.print("Error al iniciar sesion: " +ex.getMessage());
    }
    return u;
  }

  /**
   *
   * @param id
   * @param string
   * @return
   */
  @Override
  public boolean cambiarClave(int id, String string) {
    return false;
   
  }

  
}
