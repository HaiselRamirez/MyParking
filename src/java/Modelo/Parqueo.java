
package Modelo;


public class Parqueo {
  int id;
  String parqueo;
  int nivel;
  String descripcion;
  String condicion;
  boolean estado;

  public Parqueo() {
  }

  public Parqueo(int id, String parqueo, int nivel, String descripcion, String condicion, boolean estado) {
    this.id = id;
    this.parqueo = parqueo;
    this.nivel = nivel;
    this.descripcion = descripcion;
    this.condicion = condicion;
    this.estado = estado;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getParqueo() {
    return parqueo;
  }

  public void setParqueo(String parqueo) {
    this.parqueo = parqueo;
  }

  public int getNivel() {
    return nivel;
  }

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getCondicion() {
    return condicion;
  }

  public void setCondicion(String condicion) {
    this.condicion = condicion;
  }

  public boolean isEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }
  
}
