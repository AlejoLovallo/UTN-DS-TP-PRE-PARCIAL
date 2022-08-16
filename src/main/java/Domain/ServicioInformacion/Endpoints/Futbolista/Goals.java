package Domain.ServicioInformacion.Endpoints.Futbolista;

public class Goals {

  private Integer total;
  private Object conceded;
  private Object assists;
  private Object saves;

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Object getConceded() {
    return conceded;
  }

  public void setConceded(Object conceded) {
    this.conceded = conceded;
  }

  public Object getAssists() {
    return assists;
  }

  public void setAssists(Object assists) {
    this.assists = assists;
  }

  public Object getSaves() {
    return saves;
  }

  public void setSaves(Object saves) {
    this.saves = saves;
  }

}
