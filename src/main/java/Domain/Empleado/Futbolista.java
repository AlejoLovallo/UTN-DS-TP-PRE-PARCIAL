package Domain.Empleado;

import Domain.Entrenamiento.Entrenamiento;
import java.util.ArrayList;

public class Futbolista extends Empleado {
    private Double altura;
    private Double peso;
    private ArrayList<Entrenamiento> entrenamientosPersonales;

    public void altaEntrenamiento(Entrenamiento _entrenamiento){
        this.entrenamientosPersonales.add(_entrenamiento);
    }

}