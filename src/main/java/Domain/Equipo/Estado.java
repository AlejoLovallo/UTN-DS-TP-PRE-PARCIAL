package Domain.Equipo;

public abstract class Estado {

    private Equipo equipo;

    // CONSTRUCTOR

    public Estado(Equipo equipo) {
        this.equipo = equipo;
    }

    // GETTERS

    public Equipo getEquipo() {
        return equipo;
    }
    
    // METHODS

    public abstract void modificarEntrenamiento();

}
    