package Domain.ServicioInformacion;

import Domain.ServicioInformacion.Endpoints.Api;
import Domain.ServicioInformacion.Endpoints.Common.Team;
import Domain.ServicioInformacion.Endpoints.EquipoStat.*;
import Domain.ServicioInformacion.Endpoints.Equipos.TeamsResponse;
import Domain.ServicioInformacion.Endpoints.Equipos.EquipoResponse;
import Domain.ServicioInformacion.Endpoints.Equipos.ListadoEquipos;
import Domain.ServicioInformacion.Endpoints.Equipos.UltimoEquipoBuscado;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ServicioEquipo extends ServicioBusquedaInformacion{

  public ServicioEquipo(String apiKey){
    super(apiKey);
  }

  @Override
  public void buscarInformacion(Optional<String> teamName, String ...params) throws IOException {
    Api apiService = this.servicioApi.getRetrofit().create(Api.class);
    Call<TeamsResponse> teamsRequest;

    if(teamName.isPresent()){
      teamsRequest = apiService.equipo(this.servicioApi.getApiKey(),"39","2022","England", teamName.get().toString());
    }else{
      teamsRequest = apiService.equipos(this.servicioApi.getApiKey(),"39","2022","England");
    }
    Response<TeamsResponse> response = teamsRequest.execute();
    TeamsResponse equipos = response.body();

    assert equipos != null;
    List<EquipoResponse> listaEquipos = equipos.getResponse();
    if(listaEquipos.size() > 1){
      ListadoEquipos listadoEquipos = ListadoEquipos.getInstance();
      listadoEquipos.setEquipos(listaEquipos);
      listadoEquipos.printEquipos();
    }else{
      UltimoEquipoBuscado ultimoEquipo = UltimoEquipoBuscado.getInstance();
      ultimoEquipo.setTeam(listaEquipos.get(0).getTeam());
      System.out.println(listaEquipos.get(0).getTeam());
    }
  }

  public String buscarInfoEquipo(String nombreEquipo) throws IOException{
    buscarInformacion(Optional.of(nombreEquipo));
    Team equipo = UltimoEquipoBuscado.getInstance().getTeam();

    Api apiService = this.servicioApi.getRetrofit().create(Api.class);

    Call<EquipoStatResponse> request = apiService.estadisticaEquipo(this.servicioApi.getApiKey(),equipo.getId().toString(),"2021","39");
    Response<EquipoStatResponse> response = request.execute();

    assert response.body() != null;
    System.out.println(response.body().getResults());
    System.out.println(response.body());
    TeamResponse equipoRes = response.body().getResponse();
    System.out.println(equipoRes);

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

    int partidosTotales = ganados.getTotal() + empatados.getTotal() + perdidos.getTotal();

    if(ganados.getTotal() * 100 / partidosTotales >= 60){
      return "Verde";
    } else if (ganados.getTotal() * 100 / partidosTotales < 60 && ganados.getTotal() * 100 / partidosTotales >= 30){
      return "Amarillo";
    }else{
      return "Rojo";
    }
  }

  public static void main(String[] args) throws IOException {
    ServicioEquipo s = new ServicioEquipo("2d273a4263msh56ddabaa895a5adp1d5434jsnb6ef9f225011");
    System.out.println("------- STARTING HERE -----");
    //s.buscarInformacion(Optional.of("Everton"));
    /*System.out.println("------------ SPLIT SPLIT SPLIT -----------");
    s.buscarInformacion(Optional.empty());
    System.out.println("------- ENDING HERE --------");*/
    s.buscarInfoEquipo("Everton");

    System.out.println("----");

  }

}