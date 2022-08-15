package Domain.Socio;

import java.util.ArrayList;

public class RepositorioSocios {
 
  private static RepositorioSocios instance = null;
  private ArrayList<Socio> socios;

    // CONSTRUCTORES

  private RepositorioSocios(){
      this.socios = new ArrayList<>();
  }

  public static RepositorioSocios GetInstance(){
      if(instance == null){
        instance = new RepositorioSocios();
      }
      return instance;
  }
  
  // GETTERS

  public ArrayList<Socio> getSocios() {
    return socios;
  }

  // SETTERS

  public void setSocios(ArrayList<Socio> socios) {
    this.socios = socios;
  }

  // METHODS

  public void registrarSocio(Socio socio){
      this.socios.add(socio);
  }

 
}