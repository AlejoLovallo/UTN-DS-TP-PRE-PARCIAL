package Domain.ServicioInformacion;

import Domain.ServicioInformacion.Endpoints.Api;
import Domain.ServicioInformacion.Endpoints.Futbolista.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import retrofit2.Call;

public class ServicioFutbolista extends ServicioBusquedaInformacion {
  public ServicioFutbolista(String apiKey) {
    super(apiKey);
  }

  public void buscarInformacion(Optional<String> playerName, String... params) throws IOException {
    Api apiService = this.servicioApi.getRetrofit().create(Api.class);
    Call<Response> playersRequest;

    playersRequest = apiService.futbolistas(this.servicioApi.getApiKey(), "2021", "39", "1");
    retrofit2.Response<Response> response = playersRequest.execute();
    assert response.body() != null;
    System.out.println(response);
    List<PlayerResponse> jugadores = response.body().getResponse();

    System.out.println(jugadores.size());

    assert jugadores != null;
    System.out.println("-- EFECTIVAMENTE NO ESTA NULL --- ");
    Integer p1 = jugadores.get(10).getStatistics().size();
    Statistic s = jugadores.get(0).getStatistics().get(0);
    System.out.println(s.getGoals());
    System.out.println(s.getTeam());
    System.out.println(p1);
    System.out.println(jugadores.get(0).getPlayer().getName());
    /*ListadoDeFutbolistas listadoFutbolistas = ListadoDeFutbolistas.getInstance();
    listadoFutbolistas.setFutbolistas(jugadores);
    listadoFutbolistas.printFutbolistas();*/
  }

  public static void main(String[]args) throws IOException {
    ServicioFutbolista s = new ServicioFutbolista("2d273a4263msh56ddabaa895a5adp1d5434jsnb6ef9f225011");
    System.out.println("------- STARTING HERE -----");
    s.buscarInformacion(Optional.empty());
    System.out.println("------- ENDING HERE --------");
    System.out.println("----");
  }


}