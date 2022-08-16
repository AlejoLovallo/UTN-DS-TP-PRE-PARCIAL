package Domain.ServicioInformacion.Endpoints.Futbolista;

import java.util.List;

public class Response {
  private List<PlayerResponse> response = null;

  public List<PlayerResponse> getResponse() {
    return response;
  }

  public void setResponse(List<PlayerResponse> response) {
    this.response = response;
  }
}
