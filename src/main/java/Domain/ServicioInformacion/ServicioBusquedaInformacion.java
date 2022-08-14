package Domain.ServicioBusquedaInformacion;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public abstract class ServicioBusquedaInformacion {
  private static String apiKey;
  private Retrofit retrofit;

  public ServicioBusquedaInformacion(String _url){
      this.retrofit = new Retrofit.Builder()
          .baseUrl(_url)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
  }

  public static void setApiKey(String _apiKey){
    apiKey = _apiKey;
  }

  public abstract void buscarInformacion() throws IOException;

  //ENDPOINTS DE BUSQUEDA DE DATOS PARA LA BUSQUEDA DE INFORMACION
  //DE ACUERDO A CADA API QUE SE UTILICE

}
