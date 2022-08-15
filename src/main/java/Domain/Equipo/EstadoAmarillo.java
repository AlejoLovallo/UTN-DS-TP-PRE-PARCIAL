package Domain.Equipo;

import Domain.Entrenamiento.*;;

public class EstadoAmarillo extends Estado {

    // CONSTRUCTOR

    public EstadoAmarillo(Equipo equipo) {
        super(equipo);
    }

    // METHODS
    
    public void modificarEntrenamiento(){
    
        for (Entrenamiento entrenamiento : this.getEquipo().getEntrenamientos()){
            for (Ejercicio ejercicio : entrenamiento.getEjercicios()){
                ejercicio.aumentarDuracionEjercicio(10.0);
            }
        };
    }  
}
