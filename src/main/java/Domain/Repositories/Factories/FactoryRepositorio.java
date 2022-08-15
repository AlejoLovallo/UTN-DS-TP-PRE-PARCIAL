package Domain.Repositories.Factories;

import Domain.Repositories.Repositorio;
import Domain.Repositories.Handlers.*;

import java.util.HashMap;

public class FactoryRepositorio {
  private static HashMap<String, Repositorio> repos;

  static {
    repos = new HashMap<>();
  }

  public static <T> Repositorio<T> get(Class<T> type){
    Repositorio<T> repo;
    if(repos.containsKey(type.getName())){
      repo = repos.get(type.getName());
    }
    else{
        DbHandler<T> dao = new HibernateHandler<>(type);
        repo = new Repositorio<>(dao);
        repos.put(type.toString(), repo);
    }
    return repo;
  }
}

