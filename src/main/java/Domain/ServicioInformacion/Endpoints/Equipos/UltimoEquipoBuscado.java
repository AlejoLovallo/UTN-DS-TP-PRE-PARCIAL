package Domain.ServicioInformacion.Endpoints.Equipos;
import Domain.ServicioInformacion.Endpoints.Common.Team;

public class UltimoEquipoBuscado {
  private static UltimoEquipoBuscado instance = null;
  private static Team team;

  public static UltimoEquipoBuscado getInstance() {
    if(instance == null){
      instance = new UltimoEquipoBuscado();
    }
    return instance;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    UltimoEquipoBuscado.team = team;
  }
}
