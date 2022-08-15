package Domain.Empleado;

import Domain.Equipo.Equipo;
import Domain.Equipo.Estado;
import Domain.Equipo.Observer;

public class FutbolistaObserver implements Observer {
  private Futbolista futbolista;
  private Equipo equipo;

  public FutbolistaObserver(Equipo _equipo){
    this.equipo = _equipo;
    equipo.addObserver(this);
  }

  public void update(){
  }
/**  public void update(){
    Estado estado = this.equipo.getEstado();
    switch (estado){
      case ...
    }
  }
**/
}

