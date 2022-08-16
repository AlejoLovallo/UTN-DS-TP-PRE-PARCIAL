package Domain.Empleado;

import Domain.Entrenamiento.*;
//import Domain.ServicioInformacion.ServicioFutbolista;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="Futbolista")

public class Futbolista extends Empleado {

    @Column
    private Double altura;

    @Column
    private Double peso;

    @ManyToMany(cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            }, fetch = FetchType.LAZY)
    @JoinTable(name = "entrenamiento_x_futbolista",joinColumns = @JoinColumn(name = "futbolista_id"),inverseJoinColumns = @JoinColumn (name = "entrenamiento_id"))
    private ArrayList<Entrenamiento> entrenamientosPersonales;

    ServicioFutbolista servicio;

    // CONSTRUCTOR
    
    public Futbolista(Double altura, Double peso, ArrayList<Entrenamiento> entrenamientosPersonales) {
        this.altura = altura;
        this.peso = peso;
        this.entrenamientosPersonales = entrenamientosPersonales;
    }

    public Futbolista(){
        this.employeeName = "Futbolista";
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

    public Double duracionEntrenamientos(){
        Double duracion = 0.0;
        for(Entrenamiento entrenamiento : this.getEntrenamientosPersonales()){
            duracion += entrenamiento.duracionEntrenamiento();
        }
        return duracion;
    }

    public void altaEntrenamiento(Entrenamiento _entrenamiento){
        
        if((this.duracionEntrenamientos() + _entrenamiento.duracionEntrenamiento()) <= 240){
            this.entrenamientosPersonales.add(_entrenamiento);
        }else{
            System.out.println("No se puede agregar el entrenamiento. La duracion total excede las 4 horas diarias");
        }
           
    }

    public int cantGolesEnTemporada(){
        return servicio.buscarInformacion(this.getNombre());
    }
    
   
}