package Domain.Repositories;

import Domain.Empleado.*;
import Domain.Repositories.Handlers.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeFutbolistas extends Repositorio<Futbolista> {

    public RepositorioDeFutbolistas (DbHandler<Futbolista> handler) {
        super(handler);
      }

    public Boolean existe(int futbolista_id){
        return buscarFutbolista(futbolista_id) != null;
    }

    public Futbolista buscarFutbolista(int futbolista_id){
        return this.handler.buscar(futbolista_id);
    }

}