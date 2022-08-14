package Domain.Equipo;

import Domain.Entrenamiento.*;;

public class EstadoVerde extends Estado {

    // CONSTRUCTOR

    public EstadoVerde(Equipo equipo) {
        super(equipo);
    }

    // METHODS
    
    public void modificarEntrenamiento(){
        // Si está estado verde no modifica en nada los entrenamientos
    }  
}