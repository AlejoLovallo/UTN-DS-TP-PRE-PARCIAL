package Domain.ServicioInformacion.Endpoints.EquipoStat;

public class Parameters {

  private String league;
  private String team;
  private String season;

  public String getLeague() {
    return league;
  }

  public void setLeague(String league) {
    this.league = league;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public String getSeason() {
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

}