package Domain.Repositories.Handlers;

import Domain.BaseDeDatos.EntityManagerHelper;
import Domain.Repositories.BusquedaCondicional;
import Domain.Repositories.Handlers.DbHandler;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class HibernateHandler<T> implements DbHandler<T> {
  private Class<T> type;

  public HibernateHandler(Class<T> type){
    this.type = type;
  }

  @Override
  public List<T> buscarTodos() {
    CriteriaBuilder builder = EntityManagerHelper.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<T> critera = builder.createQuery(this.type);
    critera.from(type);
    List<T> entities = EntityManagerHelper.getEntityManager().createQuery(critera).getResultList();
    return entities;
  }

  @Override
  public T buscar(int id) {
    return EntityManagerHelper.getEntityManager().find(type, id);
  }

  @Override
  public T buscar(BusquedaCondicional condicional) {
    try {
      return (T) EntityManagerHelper.getEntityManager()
          .createQuery(condicional.getCondicionCritero())
          .getSingleResult();
    }
    catch (NoResultException ex){
      return null;
    }
  }

  public List<T> buscarTodosPorQuery(String query) {
    try {
      return (List<T>) EntityManagerHelper.getEntityManager()
          .createQuery(query);
    }
    catch (NoResultException ex){
      return null;
    }
  }

  @Override
  public void agregar(Object unObjeto) {
    EntityManagerHelper.getEntityManager().getTransaction().begin();
    EntityManagerHelper.getEntityManager().persist(unObjeto);
    EntityManagerHelper.getEntityManager().getTransaction().commit();
  }

  @Override
  public void modificar(Object unObjeto) {
    EntityManagerHelper.getEntityManager().getTransaction().begin();
    EntityManagerHelper.getEntityManager().merge(unObjeto);
    EntityManagerHelper.getEntityManager().getTransaction().commit();
  }

  @Override
  public void eliminar(Object unObjeto) {
    EntityManagerHelper.getEntityManager().getTransaction().begin();
    EntityManagerHelper.getEntityManager().remove(unObjeto);
    EntityManagerHelper.getEntityManager().getTransaction().commit();
  }
}
