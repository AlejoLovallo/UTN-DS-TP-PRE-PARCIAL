package Domain.Empleado;

public class RepositorioEntrenadores {
    //////////////////////////////////  VARIABLES
  private static RepositorioEntrenadores instance = null;
  private ArrayList<Entrenador> entrenadores;

    //////////////////////////////////  CONSTRUCTORES
  private RepositorioEntrenadores(){
      this.entrenadores = new ArrayList<>();
  }

  public static RepositorioEntrenadores GetInstance(){
      if(instance == null){
        instance = new RepositorioEntrenadores();
      }
      return instance;
  }
    //////////////////////////////////  GETTERS
  public ArrayList<Entrenador> getEntrenadores() {
    return entrenadores;
}

    //////////////////////////////////  SETTERS

    //////////////////////////////////  INTERFACE

  public void registrarEntrenador(Entrenador entrenador){
      this.entrenadores.add(entrenador);
  }

  public void buscarInformacionEntrenadores(){
      // TODO
  }
}