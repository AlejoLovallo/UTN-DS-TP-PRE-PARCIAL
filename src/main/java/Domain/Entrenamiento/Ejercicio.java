package Domain.Entrenamiento;

import Domain.BaseDeDatos.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Ejercicio")
public class Ejercicio extends EntidadPersistente {

    @Column
    private String nombre;

    @Column
    private Double duracion;

    // CONSTRUCTOR
    public Ejercicio() {
    }

    public Ejercicio(String _nombre, Double _duracion){
        this.nombre = _nombre;
        this.duracion = _duracion;
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