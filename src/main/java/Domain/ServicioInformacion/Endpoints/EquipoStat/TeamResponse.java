package Domain.ServicioInformacion.Endpoints.EquipoStat;
import Domain.ServicioInformacion.Endpoints.Common.Team;

public class TeamResponse {

  private League league;
  private Team team;
  private String form;
  private Fixtures fixtures;

  public League getLeague() {
    return league;
  }

  public void setLeague(League league) {
    this.league = league;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public String getForm() {
    return form;
  }

  public void setForm(String form) {
    this.form = form;
  }

  public Fixtures getFixtures() {
    return fixtures;
  }

  public void setFixtures(Fixtures fixtures) {
    this.fixtures = fixtures;
  }

}