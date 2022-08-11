package Domain.Empleado;
import Domain.Equipo.Equipo;

public abstract class Empleado implements Cloneable{

    private String nombre;
    private String apellido;
    private String nacionalidad;
    private Integer edad;
    private Equipo equipo;

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

}