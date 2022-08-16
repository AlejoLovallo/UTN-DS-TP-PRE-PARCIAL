package Domain.Torneo;

import java.util.ArrayList;

public class RepositorioTorneos {

  private static RepositorioTorneos instance = null;
  private ArrayList<Torneo> torneos;

  // CONSTRUCTORES

  private RepositorioTorneos(){
      this.torneos = new ArrayList<>();
  }

  public static RepositorioTorneos GetInstance(){
      if(instance == null){
        instance = new RepositorioTorneos();
      }
      return instance;
  }
  // GETTERS

  public ArrayList<Torneo> getTorneos() {
    return this.torneos;
  }

  // SETTERS

  public void setTorneos(ArrayList<Torneo> torneos) {
    this.torneos = torneos;
  }

  // METHODS

  public void registrarTorneo(Torneo torneo){
      this.torneos.add(torneo);
  }

}