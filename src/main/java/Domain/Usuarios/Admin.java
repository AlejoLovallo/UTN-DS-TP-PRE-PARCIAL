package Domain.Usuarios;


public class Admin extends Usuario {
  //////////////////////////////////  VARIABLES
  private RepositorioEjercicios repositorioEjercicios;

  //////////////////////////////////  CONSTRUCTORES
  public Admin(String username, String email, String contra, boolean validado) {
    super(username, email, contra, validado);
  }


  //////////////////////////////////  GETTERS


  //////////////////////////////////  SETTERS


  //////////////////////////////////  INTERFACE
  public boolean validarUsuario(Usuario userDeAlta, boolean validacion){
    return RepositorioUsuarios.getInstance().validarUsuario(userDeAlta,validacion);
  }

  public boolean validarUsuario(String username, boolean validacion){
    return RepositorioUsuarios.getInstance().validarUsuario(username,validacion);
  }

  public void registrarEjercicio(Ejercicio ejercicio){
    this.repositorioEjercicios.registrarEjercicio(ejercicio);
  }

}
