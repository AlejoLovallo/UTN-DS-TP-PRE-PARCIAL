package Domain.Repositories;

import Domain.Socio.*;
import Domain.Repositories.Handlers.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeSocios extends Repositorio<Socio> {

    public RepositorioDeSocios (DbHandler<Socio> handler) {
        super(handler);
      }

    public Boolean existe(int socio_id){
        return buscarSocio(socio_id) != null;
    }

    public Socio buscarSocio(int socio_id){
        return this.handler.buscar(socio_id);
    }

}