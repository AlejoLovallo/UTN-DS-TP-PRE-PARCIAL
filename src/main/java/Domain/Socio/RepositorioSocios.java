package Domain.Socio;

public class RepositorioSocios {
    //////////////////////////////////  VARIABLES
  private static RepositorioSocios instance = null;
  private ArrayList<Socio> socios;

    //////////////////////////////////  CONSTRUCTORES
  private RepositorioSocios(){
      this.socios = new ArrayList<>();
  }

  public static RepositorioSocios GetInstance(){
      if(instance == null){
        instance = new RepositorioSocios();
      }
      return instance;
  }
    //////////////////////////////////  GETTERS
  public ArrayList<Socio> getSocios() {
    return socios;
}

    //////////////////////////////////  SETTERS

    //////////////////////////////////  INTERFACE

  public void registrarSocio(Socio socio){
      this.socios.add(socio);
  }

}