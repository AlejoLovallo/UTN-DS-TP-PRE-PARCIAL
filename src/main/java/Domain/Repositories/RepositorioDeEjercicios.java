package Domain.Repositories;

import Domain.Entrenamiento.*;
import Domain.Repositories.Handlers.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeEjercicios extends Repositorio<Ejercicio> {

    public RepositorioDeEjercicios (DbHandler<Ejercicio> handler) {
        super(handler);
      }

    public Boolean existe(int ejercicio_id){
        return buscarEjercicio(ejercicio_id) != null;
    }

    public Ejercicio buscarEjercicio(int ejercicio_id){
        return this.handler.buscar(ejercicio_id);
    }

}