package Domain.FA;

import java.util.ArrayList;

import Domain.Repositories.RepositorioDeTorneos;
import Domain.Usuarios.Usuario;

public class FA {
 
  private static FA instance = null;
  
  private RepositorioDeTorneos repoTorneos;

  private Usuario usuario;

    // CONSTRUCTORES

  public static FA GetInstance(){
    if(instance == null){
     instance = new FA();
    }
    return instance;
  }

  // GETTERS

    public RepositorioDeTorneos getRepoTorneos() {
        return repoTorneos;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    

  // SETTERS

    public void setRepoTorneos(RepositorioDeTorneos repoTorneos) {
        this.repoTorneos = repoTorneos;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
  
    // METHODS

    

}
  
