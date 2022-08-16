package Domain.Equipo;

import java.util.ArrayList;

public class RepositorioEquipos {

  private static RepositorioEquipos instance = null;
  private ArrayList<Equipo> equipos;

  // CONSTRUCTORES

  private RepositorioEquipos(){
      this.equipos = new ArrayList<>();
  }

  public static RepositorioEquipos GetInstance(){
      if(instance == null){
        instance = new RepositorioEquipos();
      }
      return instance;
  }
  
  // GETTERS

  public ArrayList<Equipo> getEquipos() {
    return equipos;
  }

  //  SETTERS
  
  public void setEquipos(ArrayList<Equipo> equipos) {
    this.equipos = equipos;
  }

  //  METHODS

  public void registrarEquipo(Equipo equipo){
      this.equipos.add(equipo);
  }

  public void buscarInformacionEquipos(){
      // TODO
  }
}