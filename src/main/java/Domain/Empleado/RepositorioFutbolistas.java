package Domain.Empleado;

public class RepositorioFutbolistas {
    //////////////////////////////////  VARIABLES
  private static RepositorioFutbolistas instance = null;
  private ArrayList<Futbolista> futbolistas;

    //////////////////////////////////  CONSTRUCTORES
  private RepositorioFutbolistas(){
      this.futbolistas = new ArrayList<>();
  }

  public static RepositorioFutbolistas GetInstance(){
      if(instance == null){
        instance = new RepositorioFutbolistas();
      }
      return instance;
  }
    //////////////////////////////////  GETTERS
  public ArrayList<Futbolista> getFutbolistas() {
    return futbolistas;
}

    //////////////////////////////////  SETTERS

    //////////////////////////////////  INTERFACE

  public void registrarFutbolista(Futbolista futbolista){
      this.futbolistas.add(futbolista);
  }
}