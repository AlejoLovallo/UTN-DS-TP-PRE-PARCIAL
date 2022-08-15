package Domain.ServicioInformacion;

import Domain.ServicioInformacion.Endpoints.Api;
import Domain.ServicioInformacion.Endpoints.Equipos.EquipoResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class ServicioEquipo extends ServicioBusquedaInformacion{

  public ServicioEquipo(String apiKey){
    super(apiKey);
  }

  @Override
  public void buscarInformacion() throws IOException {
    System.out.println("1");
    Api apiService = this.servicioApi.getRetrofit().create(Api.class);
    System.out.println("2");
    Call<EquipoResponse> request = apiService.equipos(this.servicioApi.getApiKey(),"39","2021","England");
    System.out.println("3");
    Response<EquipoResponse> response = request.execute();
    EquipoResponse e = response.body();
    System.out.println(e.getGet());
    System.out.println(e.getErrors());
    System.out.println(e.getParameters());
    System.out.println(e.getResults());
    System.out.println(e.getResponse());
    System.out.println("4");
    System.out.println("IT IS FUCKING WORKING");
    System.out.println(response.toString());
    System.out.println(response.body());
  }

  public static void main(String[] args) throws IOException {
    ServicioEquipo s = new ServicioEquipo("2d273a4263msh56ddabaa895a5adp1d5434jsnb6ef9f225011");
    System.out.println("------- STARTING HERE -----");
    s.buscarInformacion();
    System.out.println("------- ENDING HERE --------");
  }

}