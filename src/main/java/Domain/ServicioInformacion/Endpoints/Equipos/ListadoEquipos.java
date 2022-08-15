package Domain.ServicioInformacion.Endpoints.Equipos;

import java.util.List;
import java.util.Optional;

public class ListadoEquipos {
  private static ListadoEquipos instance = null;
  /**public List<Equipo> equipos;

  public static ListadoEquipos getInstance(){
    if(instance == null){
      instance = new ListadoEquipos();
    }
    return instance;
  }

  public Optional<Equipo> getEquipoById(String id){
    return  this.equipos.stream()
        .filter(unEquipo -> unEquipo.getId().equals(id))
            .findFirst();
  }

  public Optional<Equipo> getEquipoByName(String name){
    return this.equipos.stream()
        .filter(unEquipo -> unEquipo.getName().equals(name))
        .findFirst();
  }


  public void setEquipos(List<Equipo> equipos){
    this.equipos = equipos;
  }

  public List<Equipo> getEquipos(){
    return equipos;
  }**/

}