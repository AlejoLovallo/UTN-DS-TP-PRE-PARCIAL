package Domain.Usuarios;


public class UsuarioFifa extends Usuario {
  //////////////////////////////////  VARIABLES
  private RepositorioTorneos repositorioTorneos;

  //////////////////////////////////  CONSTRUCTORES
  public UsuarioFifa(String username, String email, String contra, boolean validado) {
    super(username, email, contra, validado);
  }


  //////////////////////////////////  GETTERS


  //////////////////////////////////  SETTERS


  //////////////////////////////////  INTERFACE

  public void registrarTorneo(Torneo torneo){
    this.repositorioTorneos.registrarTorneo(torneo);
  }

}