package Domain.ServicioInformacion.Endpoints.EquipoStat;
import Domain.ServicioInformacion.Endpoints.Common.*;

public class EquipoStatResponse {
  private String get;
  private Parameters parameters;
  private Integer results;
  private Paging paging;
  private TeamResponse response;

  public String getGet() {
    return get;
  }

  public void setGet(String get) {
    this.get = get;
  }

  public Parameters getParameters() {
    return parameters;
  }

  public void setParameters(Parameters parameters) {
    this.parameters = parameters;
  }

  public Integer getResults() {
    return results;
  }

  public void setResults(Integer results) {
    this.results = results;
  }

  public Paging getPaging() {
    return paging;
  }

  public void setPaging(Paging paging) {
    this.paging = paging;
  }

  public TeamResponse getResponse() {
    return response;
  }

  public void setResponse(TeamResponse response) {
    this.response = response;
  }

}