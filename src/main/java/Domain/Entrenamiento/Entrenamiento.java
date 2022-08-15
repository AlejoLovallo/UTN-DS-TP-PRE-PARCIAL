package Domain.Entrenamiento;

import java.util.ArrayList;

public class Entrenamiento{
    
    private TipoDeEntrenamiento tipoDeEntrenamiento;
    private ArrayList<Ejercicio> ejercicios;

    // CONSTRUCTOR

    public Entrenamiento(TipoDeEntrenamiento tipoDeEntrenamiento, ArrayList<Ejercicio> ejercicios) {
        this.tipoDeEntrenamiento = tipoDeEntrenamiento;
        this.ejercicios = ejercicios;
    }

    // GETTERS

    public TipoDeEntrenamiento getTipoDeEntrenamiento() {
        return tipoDeEntrenamiento;
    }
    public ArrayList<Ejercicio> getEjercicios() {
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

}