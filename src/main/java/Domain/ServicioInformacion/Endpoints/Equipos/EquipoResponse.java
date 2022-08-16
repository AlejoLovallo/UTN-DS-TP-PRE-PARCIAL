package Domain.ServicioInformacion.Endpoints.Equipos;

import Domain.ServicioInformacion.Endpoints.Common.Team;

public class EquipoResponse {
  private Team team;
  private Venue venue;
  public Team getTeam() {
    return team;
  }
  public void setTeam(Team team) {
    this.team = team;
  }
  public Venue getVenue() {
    return venue;
  }
}
