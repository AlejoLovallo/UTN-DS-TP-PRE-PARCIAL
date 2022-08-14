package Domain.Empleado;

import java.util.ArrayList;

public class RepositorioFutbolistas {

  private static RepositorioFutbolistas instance = null;
  private ArrayList<Futbolista> futbolistas;

  // CONSTRUCTORES
  
  private RepositorioFutbolistas(){
      this.futbolistas = new ArrayList<>();
  }

  public static RepositorioFutbolistas GetInstance(){
      if(instance == null){
        instance = new RepositorioFutbolistas();
      }
      return instance;
  }

  // GETTERS

  public ArrayList<Futbolista> getFutbolistas() {
    return futbolistas;
  }

  // SETTERS

  public void setFutbolistas(ArrayList<Futbolista> futbolistas) {
    this.futbolistas = futbolistas;
  }
  

  // MERHODS

  public void registrarFutbolista(Futbolista futbolista){
      this.futbolistas.add(futbolista);
  }

  public void buscarInformacionFutbolistas(){
      // TODO
  }

}