package Domain.Repositories;

import Domain.Torneo.*;
import Domain.Repositories.Handlers.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeTorneos extends Repositorio<Torneo> {

    public RepositorioDeTorneos (DbHandler<Torneo> handler) {
        super(handler);
      }

    public Boolean existe(int torneo_id){
        return buscarTorneo(torneo_id) != null;
    }

    public Torneo buscarTorneo(int torneo_id){
        return this.handler.buscar(torneo_id);
    }

}