package Domain.ServicioInformacion;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public abstract class ServicioBusquedaInformacion {
  protected ServicioApi servicioApi;

  public ServicioBusquedaInformacion(String apiKey){
    servicioApi = ServicioApi.getInstance();
    servicioApi.setApiKey(apiKey);
  }

  public abstract void buscarInformacion(Optional<String> param, String ...params) throws IOException;
}
