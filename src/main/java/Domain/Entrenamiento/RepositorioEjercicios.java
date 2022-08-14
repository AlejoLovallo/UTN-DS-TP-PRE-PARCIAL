package Domain.Entrenamiento;

import java.util.ArrayList;

public class RepositorioEjercicios {

  private static RepositorioEjercicios instance = null;
  private ArrayList<Ejercicio> ejercicios;

  // CONSTRUCTORES
  
  private RepositorioEjercicios(){
      this.ejercicios = new ArrayList<>();
  }

  public static RepositorioEjercicios GetInstance(){
      if(instance == null){
        instance = new RepositorioEjercicios();
      }
      return instance;
  }
  // GETTERS

  public ArrayList<Ejercicio> getEjercicios() {
    return ejercicios;
  }

  // SETTERS

  public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
    this.ejercicios = ejercicios;
  }
   
  // METHODS

  public void registrarEjercicio(Ejercicio ejercicio){
      this.ejercicios.add(ejercicio);
  }

}