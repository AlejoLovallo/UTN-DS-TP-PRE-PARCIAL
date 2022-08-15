package Domain.Repositories.Handlers;

import java.util.List;

public interface DbHandler<T> {
  List<T> buscarTodos();
  T buscar(int id);
  List<T> buscarTodosPorQuery(String query);
  void agregar(Object unObjeto);
  void modificar(Object unObjeto);
  void eliminar(Object unObjeto);
}
