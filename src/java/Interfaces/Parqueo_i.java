
package Interfaces;

import Modelo.Parqueo;
import java.util.List;


public interface Parqueo_i {
  public List listar();
  public Parqueo list(int id);
  public boolean agregar(Parqueo us);
  public boolean editar(Parqueo us);
}
