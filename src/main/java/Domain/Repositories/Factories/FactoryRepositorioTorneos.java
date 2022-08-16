package Domain.Repositories.Factories;

import Domain.Torneo.*;
import Domain.Config.Config;
import Domain.Repositories.*;
import Domain.Repositories.Handlers.HibernateHandler;
import Domain.Repositories.Handlers.MemoriaHandler;
import Domain.Repositories.testMemoData.Data;

public class FactoryRepositorioTorneos {
    private static RepositorioDeTorneos repo;

    static {
        repo = null;
    }

    public static RepositorioDeTorneos get(){
        if(repo == null){
            if(Config.useDataBase){
                HibernateHandler<Torneo> hibernate = new HibernateHandler<>(Torneo.class);
                repo = new RepositorioDeTorneos(hibernate);
            }
            else{
                repo = new RepositorioDeTorneos(new MemoriaHandler<>(Data.getData(Torneo.class)));
            }
        }
        return repo;
    }
}