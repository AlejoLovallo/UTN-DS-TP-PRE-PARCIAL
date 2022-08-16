package Domain.ServicioInformacion.Endpoints.Futbolista;

import java.util.List;
import java.util.Optional;

public class ListadoDeFutbolistas {
  private static ListadoDeFutbolistas instance = null;
  public List<PlayerResponse> futbolistas;

  public static ListadoDeFutbolistas getInstance(){
    if(instance == null){
      instance = new ListadoDeFutbolistas();
    }
    return instance;
  }

  public Optional<PlayerResponse> getEquipoById(String id){
    return  this.futbolistas.stream()
        .filter(unFutbolista -> unFutbolista.getPlayer().equals(id))
        .findFirst();
  }

  public Optional<PlayerResponse> getPlayerByName(String name){
    return this.futbolistas.stream()
        .filter(unFutbolista -> unFutbolista.getPlayer().getName().equals(name))
        .findFirst();
  }

  public void setFutbolistas(List<PlayerResponse> futbolistas){
    this.futbolistas = futbolistas;
  }

  public List<PlayerResponse> getFutbolistas(){
    return futbolistas;
  }

  public void printFutbolistas(){
    futbolistas.forEach((unFutbolista-> System.out.println(unFutbolista.getPlayer().toString())));
  }
}
