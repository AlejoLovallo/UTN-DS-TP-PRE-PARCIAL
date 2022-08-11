package Domain.Entrenamiento;

public class RepositorioEjercicios {
    //////////////////////////////////  VARIABLES
  private static RepositorioEjercicios instance = null;
  private ArrayList<Ejercicio> ejercicios;

    //////////////////////////////////  CONSTRUCTORES
  private RepositorioEjercicios(){
      this.ejercicios = new ArrayList<>();
  }

  public static RepositorioEjercicios GetInstance(){
      if(instance == null){
        instance = new RepositorioEjercicios();
      }
      return instance;
  }
    //////////////////////////////////  GETTERS
  public ArrayList<Ejercicio> getEjercicios() {
    return ejercicios;
}

    //////////////////////////////////  SETTERS

    //////////////////////////////////  INTERFACE

  public void registrarEjercicio(Ejercicio ejercicio){
      this.ejercicios.add(ejercicio);
  }
}