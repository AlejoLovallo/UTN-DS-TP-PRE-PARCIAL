package Domain.Repositories;

import Domain.Equipo.*;
import Domain.Repositories.Handlers.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeEquipos extends Repositorio<Equipo> {

    public RepositorioDeEquipos (DbHandler<Equipo> handler) {
        super(handler);
      }

    public Boolean existe(int equipo_id){
        return buscarEquipo(equipo_id) != null;
    }

    public Equipo buscarEquipo(int equipo_id){
        return this.handler.buscar(equipo_id);
    }

}