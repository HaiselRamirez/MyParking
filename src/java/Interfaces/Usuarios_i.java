
package Interfaces;

import Modelo.Usuarios;
import java.util.ArrayList;
import java.util.List;


public interface Usuarios_i {
  public ArrayList<Usuarios> listar();
  public Usuarios list(int id);
  public boolean agregar(Usuarios us);
  public boolean editar(Usuarios us);
  public boolean eliminar(int id);
  public Usuarios validar(Usuarios us);
}
