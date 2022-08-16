package Domain.ServicioInformacion;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioApi {
  private static ServicioApi instance = null;
  private static String apiKey;
  private static String APP_URL = "https://api-football-beta.p.rapidapi.com/";
  private Retrofit retrofit;
  private ServicioBusquedaInformacion servicioBusquedaInformacion;

  private ServicioApi(){
    this.retrofit = new Retrofit.Builder()
        .baseUrl(APP_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public ServicioBusquedaInformacion getServicioBusquedaInformacion(){
    return servicioBusquedaInformacion;
  }

  public void setServicioBusquedaInformacion(ServicioBusquedaInformacion servicioBusquedaInformacion){
    this.servicioBusquedaInformacion = servicioBusquedaInformacion;
  }


  protected Retrofit getRetrofit(){
    return retrofit;
  }

  public String getApiKey(){
    return apiKey;
  }

  public void setApiKey(String _apiKey){
    apiKey = _apiKey;
  }

  public static ServicioApi getInstance(){
    if(instance == null){
      instance = new ServicioApi();
    }
    return instance;
  }

}
