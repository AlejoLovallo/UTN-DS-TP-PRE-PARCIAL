package Domain.ServicioInformacion;

import Domain.ServicioInformacion.Endpoints.Api;
import Domain.ServicioInformacion.Endpoints.EquipoStat.*;
import Domain.ServicioInformacion.Endpoints.Equipos.TeamsResponse;
import Domain.ServicioInformacion.Endpoints.Equipos.EquipoResponse;
import Domain.ServicioInformacion.Endpoints.Equipos.ListadoEquipos;
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
    Api apiService = this.servicioApi.getRetrofit().create(Api.class);
    
    Call<TeamsResponse> requestEngland = apiService.equipos(this.servicioApi.getApiKey(),"39","2021","England");
    Call<TeamsResponse> requestItaly = apiService.equipos(this.servicioApi.getApiKey(),"135","2021","Italy");
    Response<TeamsResponse> responseEngland = requestEngland.execute();
    Response<TeamsResponse> responseItaly = requestItaly.execute();

    TeamsResponse equiposIngleses = responseEngland.body();
    TeamsResponse equiposItalianos = responseItaly.body();

    assert equiposIngleses != null;
    List<EquipoResponse> equiposEng = equiposIngleses.getResponse();
    ListadoEquipos listadoEquiposIngleses = ListadoEquipos.getInstance();
    listadoEquiposIngleses.setEquipos(equiposEng);
    listadoEquiposIngleses.printEquipos();

    equiposEng.forEach((unEquipo -> {

    }));

    System.out.println("--------------------------------------");

    assert equiposItalianos != null;
    List<EquipoResponse> equiposIta = equiposItalianos.getResponse();
    ListadoEquipos listadoEquiposItalianos = ListadoEquipos.getInstance();
    listadoEquiposItalianos.setEquipos(equiposIta);
    listadoEquiposItalianos.printEquipos();

  }

  public void buscarInfoEquipo(String _idEquipo) throws IOException{
    Api apiService = this.servicioApi.getRetrofit().create(Api.class);

    Call<EquipoStatResponse> request = apiService.estadisticaEquipo(this.servicioApi.getApiKey(),"33","2021","39");
    Response<EquipoStatResponse> response = request.execute();

    System.out.println(response.body().getResults());
    System.out.println(response.body());
    TeamResponse equipoRes = response.body().getResponse();

    assert equipoRes != null;

    System.out.println("---- 1 ----");
    System.out.println(equipoRes);
    System.out.println();

    System.out.println(equipoRes.getTeam().getName());

    Wins ganados = equipoRes.getFixtures().getWins();
    Draws empatados = equipoRes.getFixtures().getDraws();
    Loses perdidos = equipoRes.getFixtures().getLoses();

    System.out.println(ganados.toString());
    System.out.println(empatados.toString());
    System.out.println(perdidos.toString());

    System.out.println("--------------------------------------");


  }

  public static void main(String[] args) throws IOException {
    ServicioEquipo s = new ServicioEquipo("2d273a4263msh56ddabaa895a5adp1d5434jsnb6ef9f225011");
    System.out.println("------- STARTING HERE -----");
    s.buscarInformacion();
    System.out.println("------- ENDING HERE --------");

    s.buscarInfoEquipo();

    System.out.println("----");

  }

}