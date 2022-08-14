package Domain.Empleado;
import Domain.Equipo.Equipo;

public abstract class Empleado implements Cloneable{

    private String nombre;
    private String apellido;
    private String nacionalidad;
    private Integer edad;
    private Equipo equipo;

    // CONSTRUCTOR

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    // GETTERS

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Integer getEdad() {
        return edad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    // SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    // METHODS

    

    

}