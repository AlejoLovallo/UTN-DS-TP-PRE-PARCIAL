package Domain.ServicioInformacion.Endpoints;

import Domain.ServicioInformacion.Endpoints.EquipoStat.EquipoStatResponse;
import Domain.ServicioInformacion.Endpoints.Equipos.TeamsResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface Api {
  @GET("teams")
  //"https://api-football-beta.p.rapidapi.com/teams?league=39&season=2021&country=England"
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

}
