package Domain.ServicioInformacion.Endpoints.Futbolista;

import java.util.List;

public class PlayerResponse {
  private Player futbolista;
  private List<Statistic> statistics = null;

  public Player getPlayer() {
    return futbolista;
  }

  public void setPlayer(Player player) {
    this.futbolista = player;
  }

  public List<Statistic> getStatistics() {
    return statistics;
  }

  public void setStatistics(List<Statistic> statistics) {
    this.statistics = statistics;
  }
}
