package Domain.ServicioInformacion.Endpoints.EquipoStat;
import Domain.ServicioInformacion.Endpoints.Common.*;

public class EquipoStatResponse {
  private String get;
  private Integer results;
  private TeamResponse response;

  public String getGet() {
    return get;
  }

  public void setGet(String get) {
    this.get = get;
  }

  public Integer getResults() {
    return results;
  }

  public void setResults(Integer results) {
    this.results = results;
  }

  public TeamResponse getResponse() {
    return response;
  }

  public void setResponse(TeamResponse response) {
    this.response = response;
  }

}