package Domain.ServicioInformacion.Endpoints.Futbolista;
import Domain.ServicioInformacion.Endpoints.Common.Team;

public class Statistic {
  private Team team;
  private Goals goals;

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public Goals getGoals() {
    return goals;
  }

  public void setGoals(Goals goals) {
    this.goals = goals;
  }

}