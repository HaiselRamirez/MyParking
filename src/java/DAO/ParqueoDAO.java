
package DAO;

import Config.Conexion;
import Interfaces.Parqueo_i;
import Modelo.Parqueo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ParqueoDAO implements Parqueo_i {
  Parqueo pa = new Parqueo();
  Conexion cn = new Conexion();
  Connection con ;
  PreparedStatement ps;
  ResultSet rs;
  Statement ct =null;
  boolean resp = false;

  /**
   *
   * @return list 
   */
  @Override
  public List listar() {
    ArrayList<Parqueo> list = new ArrayList();
    String query ="SELECT * FROM parqueo";
    try {
      con = cn.getConexion();
      ps = con.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
        pa.setId(rs.getInt("id"));
        pa.setParqueo(rs.getString("parqueo"));
        pa.setNivel(rs.getInt("nivel"));
        pa.setDescripcion(rs.getString("descripcion"));
        pa.setCondicion(rs.getString("condicion"));
        pa.setEstado(rs.getBoolean("estado"));
        list.add(pa);
      }
    } catch (ClassNotFoundException e) {
    } catch (SQLException e) {
    }
    return list;
  }

  /**
   *
   * @param id
   * @return pa
   */
  @Override
  public Parqueo list(int id) {
    String query ="SELECT * FROM parqueo WHERE id="+id;
    try {
      con = cn.getConexion();
      ps = con.prepareStatement(query);
      rs = ps.executeQuery();
      while(rs.next()){
        pa.setId(rs.getInt("id"));
        pa.setParqueo(rs.getString("parqueo"));
        pa.setNivel(rs.getInt("nivel"));
        pa.setDescripcion(rs.getString("descripcion"));
        pa.setCondicion(rs.getString("condicion"));
        pa.setEstado(rs.getBoolean("estado"));
      }
    } catch (ClassNotFoundException e) {
    } catch (SQLException e) {
    }
    return pa;
  }

  /**
   *
   * @param pa
   * @return resp
   */
  @Override
  public boolean agregar(Parqueo pa) {
    String query = "INSERT INTO parqueo(parqueo, descripcion, nivel, condicion) VALUES('"+pa.getParqueo()+"','"+pa.getDescripcion()+"',"+pa.getNivel()+",'"+pa.getCondicion()+"')";
    try {
      con = cn.getConexion();
      ps = con.prepareStatement(query);
      if(ps.executeUpdate() > 0){
        resp = true;
      }
    } catch (ClassNotFoundException e) {
      Logger.getLogger(ParqueoDAO.class.getName()).log(Level.SEVERE, null, e);
    } catch (SQLException e) {
    }
   return resp;
  }

  /**
   *
   * @param pa
   * @return
   */
  @Override
  public boolean editar(Parqueo pa) {
    String query = "UPDATE parqueo SET parqueo='"+pa.getParqueo()+"', descripcion='"+pa.getDescripcion()+"', nivel="+pa.getNivel()+",condicion='"+pa.getCondicion()+"' WHERE id="+pa.getId()+"";
    try {
      con = cn.getConexion();
      ps = con.prepareStatement(query);
      if(ps.executeUpdate() > 0){
        resp = true;
      }
    } catch (ClassNotFoundException e) {
      Logger.getLogger(ParqueoDAO.class.getName()).log(Level.SEVERE, null, e);
    } catch (SQLException e) {
    }
   return resp;
  }

  /**
   *
   * @return cantidad
   */
  @Override
  public int parqueoActivos() {
    String query = "SELECT COUNT(parqueo) AS cantidad FROM parqueo WHERE estado=true";
    int cantidad = 0;
    try {
       con = cn.getConexion();
       ps = con.prepareStatement(query);
       rs =ps.executeQuery();
       while(rs.next()){
         cantidad = rs.getInt("cantidad");
       }
    } catch (ClassNotFoundException e) {
    } catch (SQLException e) {
    }
    return cantidad;
  }

  /**
   *
   * @return cantidad
   */
  @Override
  public int cantParqueos() {
    String query = "SELECT COUNT(parqueo) AS cantidad FROM parqueo";
    int cantidad = 0;
    try {
       con = cn.getConexion();
       ps = con.prepareStatement(query);
       rs =ps.executeQuery();
       while(rs.next()){
         cantidad = rs.getInt("cantidad");
       }
    } catch (ClassNotFoundException e) {
    } catch (SQLException e) {
    }
    return cantidad;
  }
  
}
