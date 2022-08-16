package Domain.Torneo;

import java.util.ArrayList;


import Domain.Equipo.Equipo;;

public abstract class Torneo {

    private String nombre;
    private int año;
    private ArrayList <Equipo> equipos;

    // GETTERS

    public String getNombre() {
        return nombre;
    }

    public int getAño() {
        return año;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    // SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void setAño(int año) {
        this.año = año;
    }

    // METHODS

}