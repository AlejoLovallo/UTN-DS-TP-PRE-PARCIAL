package Domain.Equipo;

import Domain.Entrenamiento.*;;

public class EstadoRojo extends Estado {

    // CONSTRUCTOR

    public EstadoRojo(Equipo equipo) {
        super(equipo);
    }

    // METHODS
    
    public void modificarEntrenamiento(){
    
        for (Entrenamiento entrenamiento : this.getEquipo().getEntrenamientos()){
            for (Ejercicio ejercicio : entrenamiento.getEjercicios()){
                ejercicio.aumentarDuracionEjercicio(25.0);
            }
        };
    }  
}