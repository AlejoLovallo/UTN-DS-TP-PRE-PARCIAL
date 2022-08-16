package Domain.ServicioInformacion.Endpoints;

import Domain.ServicioInformacion.Endpoints.EquipoStat.EquipoStatResponse;
import Domain.ServicioInformacion.Endpoints.Equipos.TeamsResponse;
import Domain.ServicioInformacion.Endpoints.Futbolista.Response;
import retrofit2.Call;
import retrofit2.http.*;

public interface Api {
  @GET("teams")
  //"https://api-football-beta.p.rapidapi.com/teams?league=39&season=2021&country=England"
  Call<TeamsResponse> equipo(@Header("X-RapidAPI-Key") String apiKey,
                              @Query("league") String league,
                              @Query("season") String season,
                              @Query("country")String country,
                              @Query("name") String name
  );

  @GET("teams")
  Call<TeamsResponse> equipos(@Header("X-RapidAPI-Key") String apiKey,
                             @Query("league") String league,
                             @Query("season") String season,
                             @Query("country")String country
  );

  //https://api-football-beta.p.rapidapi.com/teams/statistics?team=33&season=2021&league=39
  @GET("teams/statistics")
  Call<EquipoStatResponse> estadisticaEquipo(@Header("X-RapidAPI-Key") String apiKey,
                                             @Query("team") String team,
                                             @Query("season") String season,
                                             @Query("league") String league
  );

  //"https://api-football-beta.p.rapidapi.com/players?season=2021&league=39&page=2"
  @GET("players")
  Call<Response> futbolistas(@Header("X-RapidAPI-Key") String apiKey,
                             @Query("season") String season,
                             @Query("league") String league,
                             @Query("page") String page
  );

  @GET("players")
  Call<Response> futbolista(@Header("") String apiKey,
                            @Query("season") String season,
                            @Query("league") String league,
                            @Query("id") String playerId

  );

}
