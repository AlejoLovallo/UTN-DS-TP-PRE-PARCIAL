package Domain.ServicioInformacion.Endpoints.EquipoStat;

public class Draws {
  private Integer home;
  private Integer away;
  private Integer total;

  public Integer getHome() {
    return home;
  }

  public void setHome(Integer home) {
    this.home = home;
  }

  public Integer getAway() {
    return away;
  }

  public void setAway(Integer away) {
    this.away = away;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "Draws{" +
        "home=" + home +
        ", away=" + away +
        ", total=" + total +
        '}';
  }
}
