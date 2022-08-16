package Domain.Entrenamiento;

import Domain.BaseDeDatos.EntidadPersistente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Entrenamiento")

public class Entrenamiento extends EntidadPersistente {

    @Enumerated(EnumType.STRING)
    private TipoDeEntrenamiento tipoDeEntrenamiento;

    @ManyToMany(cascade =
        {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST
        }, fetch = FetchType.LAZY)
    @JoinTable(name = "entrenamiento_x_ejercicio",
               joinColumns = @JoinColumn(name = "entrenamiento_id"),
                inverseJoinColumns = @JoinColumn (name = "ejercicio_id")
    )
    private List<Ejercicio> ejercicios;

    // CONSTRUCTOR

    public Entrenamiento() {
    }

    

    // GETTERS

    public Entrenamiento(TipoDeEntrenamiento tipoDeEntrenamiento, List<Ejercicio> ejercicios) {
        this.tipoDeEntrenamiento = tipoDeEntrenamiento;
        
        Double duracion = 0.0;
        for(Ejercicio ejercicio : ejercicios){
            duracion += ejercicio.getDuracion();
        }

        if (duracion < 2.0){
            this.ejercicios = ejercicios;
        }else{
            System.out.println("No se puede crear el entrenamiento. La duracion excede las 2");
        }
        
    }



    public TipoDeEntrenamiento getTipoDeEntrenamiento() {
        return tipoDeEntrenamiento;
    }
    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
 
    // SETTERS

    public void setTipoDeEntrenamiento(TipoDeEntrenamiento tipoDeEntrenamiento) {
        this.tipoDeEntrenamiento = tipoDeEntrenamiento;
    }
    public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    // METHODS

    public Double duracionEntrenamiento(){
        Double duracion = 0.0;
        for(Ejercicio ejercicio : this.getEjercicios()){
            duracion += ejercicio.getDuracion();
        }

        return duracion;
    }

}