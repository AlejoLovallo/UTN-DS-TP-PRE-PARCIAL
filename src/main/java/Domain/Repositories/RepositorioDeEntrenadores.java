package Domain.Repositories;

import Domain.Empleado.*;
import Domain.Repositories.Handlers.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeEntrenadores extends Repositorio<Entrenador> {

    public RepositorioDeEntrenadores (DbHandler<Entrenador> handler) {
        super(handler);
      }

    public Boolean existe(int entrenador_id){
        return buscarEntrenador(entrenador_id) != null;
    }

    public Entrenador buscarEntrenador(int entrenador_id){
        return this.handler.buscar(entrenador_id);
    }

}