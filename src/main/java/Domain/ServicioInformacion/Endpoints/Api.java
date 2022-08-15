package Domain.ServicioInformacion.Endpoints;

import Domain.ServicioInformacion.Endpoints.Equipos.EquipoResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface Api {
  @GET("teams")
  //"https://api-football-beta.p.rapidapi.com/teams?league=39&season=2021&country=England"
  Call<EquipoResponse> equipos(@Header("X-RapidAPI-Key") String apiKey,
                               @Query("league") String league,
                               @Query("season") String season,
                               @Query("country")String country
  );

}
