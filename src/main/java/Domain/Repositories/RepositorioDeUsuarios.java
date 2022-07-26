package Domain.Repositories;

import Domain.Usuarios.Usuario;
import Domain.Repositories.Handlers.DbHandler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class RepositorioDeUsuarios extends Repositorio<Usuario>{

  public RepositorioDeUsuarios(DbHandler<Usuario> handler) {
    super(handler);
  }

  public Boolean existe(String nombreDeUsuario, String contrasenia){
    return buscarUsuario(nombreDeUsuario, contrasenia) != null;
  }

  public Usuario buscarUsuario(String nombreDeUsuario, String contrasenia){
    return this.handler.buscar(condicionUsuarioYContrasenia(nombreDeUsuario, contrasenia));
  }

  private BusquedaCondicional condicionUsuarioYContrasenia(String nombreDeUsuario, String contrasenia){
    CriteriaBuilder criteriaBuilder = criteriaBuilder();
    CriteriaQuery<Usuario> usuarioQuery = criteriaBuilder.createQuery(Usuario.class);

    Root<Usuario> condicionRaiz = usuarioQuery.from(Usuario.class);

    Predicate condicionNombreDeUsuario = criteriaBuilder.equal(condicionRaiz.get("usuario"), nombreDeUsuario);
    Predicate condicionContrasenia = criteriaBuilder.equal(condicionRaiz.get("password"), contrasenia);

    Predicate condicionExisteUsuario = criteriaBuilder.and(condicionNombreDeUsuario, condicionContrasenia);

    usuarioQuery.where(condicionExisteUsuario);

    return new BusquedaCondicional(null, usuarioQuery);
  }
}


