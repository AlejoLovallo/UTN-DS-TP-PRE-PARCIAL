package Domain.Equipo;

public class RepositorioEquipos {
    //////////////////////////////////  VARIABLES
  private static RepositorioEquipos instance = null;
  private ArrayList<Equipo> equipos;

    //////////////////////////////////  CONSTRUCTORES
  private RepositorioEquipos(){
      this.equipos = new ArrayList<>();
  }

  public static RepositorioEquipos GetInstance(){
      if(instance == null){
        instance = new RepositorioEquipos();
      }
      return instance;
  }
    //////////////////////////////////  GETTERS
  public ArrayList<Equipo> getEquipos() {
    return equipos;
}

    //////////////////////////////////  SETTERS

    //////////////////////////////////  INTERFACE

  public void registrarEquipo(Equipo equipo){
      this.equipos.add(equipo);
  }

  public void buscarInformacionEquipos(){
      // TODO
  }
}