package Domain.Usuarios;

import Domain.Torneo.*;


public class UsuarioFifa extends Usuario {
  
  private RepositorioTorneos repositorioTorneos;

  // CONSTRUCTORES

  public UsuarioFifa(String username, String email, String contra, boolean validado) {
    super(username, email, contra, validado);
  }


  // GETTERS


  // SETTERS


  // METHODS

  public void registrarTorneo(Torneo torneo){
    this.repositorioTorneos.registrarTorneo(torneo);
  }

}