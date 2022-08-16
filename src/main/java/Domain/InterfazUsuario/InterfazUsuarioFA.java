package Domain.InterfazUsuario;

import Domain.FA.*;
import Domain.Usuarios.Usuario;

public class InterfazUsuarioFA {

  private InterfazUsuarioFA instance = null;
  private Usuario usuario;
  private FA fa;

  public InterfazUsuarioFA getInstance(){
    if (instance == null){
      instance =  new InterfazUsuarioFA();
    }
    return instance;
  }


  public Boolean ingresarUsuario(){
    return true;
  }

  public Boolean crearUsuario(String _nombre, String _password){
    return true;
  }

  public void devolverUsuarioIncorrecto(){

  }

  public void devolverUsuarioCorrecto(){

  }
}
