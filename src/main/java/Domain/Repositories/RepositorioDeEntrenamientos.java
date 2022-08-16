package Domain.Repositories;

import Domain.Entrenamiento.*;
import Domain.Repositories.Handlers.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeEntrenamientos extends Repositorio<Entrenamiento> {

    public RepositorioDeEntrenamientos (DbHandler<Entrenamiento> handler) {
        super(handler);
      }

    public Boolean existe(int ententrenamiento_id){
        return buscarEntrenamiento(ententrenamiento_id) != null;
    }

    public Entrenamiento buscarEntrenamiento(int ententrenamiento_id){
        return this.handler.buscar(ententrenamiento_id);
    }

}
