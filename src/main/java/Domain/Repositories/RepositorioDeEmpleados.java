package Domain.Repositories;

import Domain.Empleado.*;
import Domain.Repositories.Handlers.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeEmpleados extends Repositorio<Empleado> {

    public RepositorioDeEmpleados (DbHandler<Empleado> handler) {
        super(handler);
      }

    public Boolean existe(int empleado_id){
        return buscarEmpleado(empleado_id) != null;
    }

    public Empleado buscarEmpleado(int empleado_id){
        return this.handler.buscar(empleado_id);
    }

}