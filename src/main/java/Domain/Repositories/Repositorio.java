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
    if(!unObjeto.getClass().getSimpleName().equalsIgnoreCase("bitacora") ) {
      System.out.println("ENTRE A LA MODIFICACION ");
      this.dao.modificar(unObjeto);
      this.guardadorDeLog.GuardarEnBitacora(unObjeto, "MODIFICACION");
    }
  }

  public void eliminar(Object unObjeto){
    this.dao.eliminar(unObjeto);
    this.guardadorDeLog.GuardarEnBitacora(unObjeto, "BAJA");
  }

  public List<T> buscarTodos(){
    return this.dao.buscarTodos();
  }

  public List<T> buscarTodosPorQuery(String query){
    return this.dao.buscarTodosPorQuery(query);
  }

  public T buscar(int id){
    return this.dao.buscar(id);
  }

  public CriteriaBuilder criteriaBuilder(){
    return EntityManagerHelper.getEntityManager().getCriteriaBuilder();
  }
}