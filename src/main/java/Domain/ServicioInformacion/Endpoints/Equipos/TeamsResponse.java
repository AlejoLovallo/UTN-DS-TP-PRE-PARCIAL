package Domain.ServicioInformacion.Endpoints.Equipos;

import Domain.ServicioInformacion.Endpoints.Common.Paging;

import java.util.List;

public class TeamsResponse {
  private String get;
  private Parameters parameters;
  private List<Object> errors = null;
  private Integer results;
  private Paging paging;
  private List<EquipoResponse> response = null;

  public String getGet() {
    return get;
  }

  public void setGet(String get) {
    this.get = get;
  }

  public Parameters getParameters() {
    return parameters;
  }

  public List<Object> getErrors() {
    return errors;
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

  public List<EquipoResponse> getResponse() {
    return response;
  }

}