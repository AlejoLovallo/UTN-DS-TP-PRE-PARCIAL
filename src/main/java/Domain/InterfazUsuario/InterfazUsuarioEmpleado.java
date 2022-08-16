package Domain.InterfazUsuario;

import Domain.Equipo.*;
import Domain.Usuarios.Usuario;



public class InterfazUsuarioEmpleado {

    private InterfazUsuarioEmpleado instance = null;
    private Usuario usuario;
    private Equipo equipo;

    public InterfazUsuarioEmpleado getInstance(){
        if (instance == null){
          instance =  new InterfazUsuarioEmpleado();
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
