
package Interfaces;

import Modelo.Usuarios;
import java.util.List;


public interface Usuarios_i {
  public List listar();
  public Usuarios list(int id);
  public boolean agregar(Usuarios us);
  public boolean editar(Usuarios us);
  public Usuarios validar(String user, String pass);
  public boolean cambiarClave(int id, String nueva);
}
