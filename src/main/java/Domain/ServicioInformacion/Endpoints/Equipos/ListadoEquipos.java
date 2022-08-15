package Domain.ServicioInformacion.Endpoints.Equipos;

import java.util.List;
import java.util.Optional;

public class ListadoEquipos {
  private static ListadoEquipos instance = null;
  public List<EquipoResponse> equipos;

  public static ListadoEquipos getInstance(){
    if(instance == null){
      instance = new ListadoEquipos();
    }
    return instance;
  }

  public Optional<EquipoResponse> getEquipoById(String id){
    return  this.equipos.stream()
        .filter(unEquipo -> unEquipo.getTeam().getId().equals(id))
            .findFirst();
  }

  public Optional<EquipoResponse> getEquipoByName(String name){
    return this.equipos.stream()
        .filter(unEquipo -> unEquipo.getTeam().getName().equals(name))
        .findFirst();
  }

  public void setEquipos(List<EquipoResponse> equipos){
    this.equipos = equipos;
  }

  public List<EquipoResponse> getEquipos(){
    return equipos;
  }

  public void printEquipos(){
    equipos.forEach((unEquipo-> System.out.println(unEquipo.getTeam().toString())));
  }

}