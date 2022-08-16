package Domain.Repositories.Handlers;

import Domain.BaseDeDatos.EntidadPersistente;
import Domain.BaseDeDatos.EntityManagerHelper;
import Domain.Repositories.BusquedaCondicional;

import javax.persistence.NoResultException;
import java.util.List;

public class MemoriaHandler<T> implements DbHandler<T> {
    private List<EntidadPersistente> entidades;

    public MemoriaHandler(List<EntidadPersistente> entidades){
        this.entidades = entidades;
    }

    @Override
    public List<T> buscarTodos() {
        return (List<T>) this.entidades;
    }

    @Override
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
    public T buscar(int id) {
        return (T) this.entidades
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public T buscar(BusquedaCondicional condicional) {
        return (T) this.entidades
                .stream()
                .filter(condicional.getCondicionPredicado())
                .findFirst()
                .get();
    }

    @Override
    public void agregar(Object unObjeto) {
        this.entidades.add((EntidadPersistente) unObjeto);
    }

    @Override
    public void modificar(Object unObjeto) {

    }

    @Override
    public void eliminar(Object unObjeto) {
        this.entidades.remove(unObjeto);
    }
}
