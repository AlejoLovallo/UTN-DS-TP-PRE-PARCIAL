package Domain.Entrenamiento;

public class Ejercicio {

    private String nombre;
    private Double duracion;

    // CONSTRUCTOR

    public Ejercicio(String nombre, Double duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    // GETTERS

    public String getNombre() {
        return nombre;
    }

    public Double getDuracion() {
        return duracion;
    }

    // SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    // METHODS

    public void aumentarDuracionEjercicio(Double porcentaje){
        setDuracion(getDuracion() + getDuracion() * porcentaje / 100);
    }

}