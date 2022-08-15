package Domain.Repositories.Factories;

import Domain.Entrenamiento.*;
import Domain.Config.Config;
import Domain.Repositories.*;
import Domain.Repositories.Handlers.HibernateHandler;
import Domain.Repositories.Handlers.MemoriaHandler;
import Domain.Repositories.testMemoData.Data;

public class FactoryRepositorioEjercicios {
    private static RepositorioDeEjercicios repo;

    static {
        repo = null;
    }

    public static RepositorioDeEjercicios get(){
        if(repo == null){
            if(Config.useDataBase){
                HibernateHandler<Ejercicio> hibernate = new HibernateHandler<>(Ejercicio.class);
                repo = new RepositorioDeEjercicios(hibernate);
            }
            else{
                repo = new RepositorioDeEjercicios(new MemoriaHandler<>(Data.getData(Ejercicio.class)));
            }
        }
        return repo;
    }
}