package Domain.Empleado;

import Domain.Equipo.Equipo;
import Domain.Entrenamiento.*;

public class FutbolistaObserver implements Observer {

  private Futbolista futbolista;
  private Equipo equipo;

  public FutbolistaObserver(Equipo _equipo, Futbolista _futbolista){
    this.equipo = _equipo;
    this.futbolista = _futbolista;
    equipo.addObserver(this);
  }

  public void update(){
    for (Entrenamiento entrenamiento : this.futbolista.getEntrenamientosPersonales()){
        for (Ejercicio ejercicio : entrenamiento.getEjercicios()){
            ejercicio.aumentarDuracionEjercicio(5.0);
        }
    };
  }
}

