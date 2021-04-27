
package Modelo;

public class Usuarios {
  private int id;
  private String user;
  private String clave;
  private String nombre;
  private String email;
  private String cargo;
  private String tanda;
  private boolean estado;

  public Usuarios() {
  }

  public Usuarios(int id, String user, String clave, String nombre, String email, String cargo, String tanda, boolean estado) {
    this.id = id;
    this.user = user;
    this.clave = clave;
    this.nombre = nombre;
    this.email = email;
    this.cargo = cargo;
    this.tanda = tanda;
    this.estado = estado;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public String getTanda() {
    return tanda;
  }

  public void setTanda(String tanda) {
    this.tanda = tanda;
  }

  public boolean isEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  
}
