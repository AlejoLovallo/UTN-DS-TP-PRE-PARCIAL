package Domain.Empleado;

import Domain.Entrenamiento.*;
import Domain.Equipo.Observer;
import java.util.ArrayList;


public class Futbolista extends Empleado implements Observer {

    private Double altura;
    private Double peso;
    private ArrayList<Entrenamiento> entrenamientosPersonales;

    // CONSTRUCTOR
    
    public Futbolista(Double altura, Double peso, ArrayList<Entrenamiento> entrenamientosPersonales) {
        this.altura = altura;
        this.peso = peso;
        this.entrenamientosPersonales = entrenamientosPersonales;
    }

    // GETTERS

    public Double getAltura() {
        return altura;
    }

    public Double getPeso() {
        return peso;
    }

    public ArrayList<Entrenamiento> getEntrenamientosPersonales() {
        return entrenamientosPersonales;
    }

    // SETTERS

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setEntrenamientosPersonales(ArrayList<Entrenamiento> entrenamientosPersonales) {
        this.entrenamientosPersonales = entrenamientosPersonales;
    }

    // METHODS

    public void altaEntrenamiento(Entrenamiento _entrenamiento){
        this.entrenamientosPersonales.add(_entrenamiento);
    }
    
    public void update(){
        for (Entrenamiento entrenamiento : this.getEntrenamientosPersonales()){
            for (Ejercicio ejercicio : entrenamiento.getEjercicios()){
                ejercicio.aumentarDuracionEjercicio(5.0);
            }
        };
    }
}