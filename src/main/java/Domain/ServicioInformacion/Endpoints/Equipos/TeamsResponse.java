package Domain.ServicioInformacion.Endpoints.Equipos;

import java.util.List;

public class TeamsResponse {
  private String get;
  private List<Object> errors = null;
  private Integer results;
  private List<EquipoResponse> response = null;

  public String getGet() {
    return get;
  }

  public void setGet(String get) {
    this.get = get;
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

  public List<EquipoResponse> getResponse() {
    return response;
  }

}