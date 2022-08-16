package Domain.Repositories.Factories;

import Domain.Entrenamiento.*;
import Domain.Config.Config;
import Domain.Repositories.*;
import Domain.Repositories.Handlers.HibernateHandler;
import Domain.Repositories.Handlers.MemoriaHandler;
import Domain.Repositories.testMemoData.Data;

public class FactoryRepositorioEntrenamientos {
    private static RepositorioDeEntrenamientos repo;

    static {
        repo = null;
    }

    public static RepositorioDeEntrenamientos get(){
        if(repo == null){
            if(Config.useDataBase){
                HibernateHandler<Entrenamiento> hibernate = new HibernateHandler<>(Entrenamiento.class);
                repo = new RepositorioDeEntrenamientos(hibernate);
            }
            else{
                repo = new RepositorioDeEntrenamientos(new MemoriaHandler<>(Data.getData(Entrenamiento.class)));
            }
        }
        return repo;
    }
}