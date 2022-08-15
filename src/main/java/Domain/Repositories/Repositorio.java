package Domain.Repositories;

import Domain.BaseDeDatos.EntityManagerHelper;
import Domain.Repositories.Handlers.DbHandler;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class Repositorio<T> {
  protected DbHandler<T> handler;

  public Repositorio(DbHandler<T> _handler) {
    this.handler = _handler;
  }

  public void setHandler(DbHandler<T> _handler) {
    this.handler = _handler;
  }

  public void agregar(Object unObjeto){
    this.handler.agregar(unObjeto);
  }

  public void modificar(Object unObjeto){
    this.handler.modificar(unObjeto);
  }

  public void eliminar(Object unObjeto){
    this.handler.eliminar(unObjeto);
  }

  public List<T> buscarTodos(){
    return this.handler.buscarTodos();
  }

  public List<T> buscarTodosPorQuery(String query){
    return this.handler.buscarTodosPorQuery(query);
  }

  public T buscar(int id){
    return this.handler.buscar(id);
  }

  public CriteriaBuilder criteriaBuilder(){
    return EntityManagerHelper.getEntityManager().getCriteriaBuilder();
  }
}