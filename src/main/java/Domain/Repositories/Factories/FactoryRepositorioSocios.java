package Domain.Repositories.Factories;

import Domain.Socio.*;
import Domain.Config.Config;
import Domain.Repositories.*;
import Domain.Repositories.Handlers.HibernateHandler;
import Domain.Repositories.Handlers.MemoriaHandler;
import Domain.Repositories.testMemoData.Data;

public class FactoryRepositorioSocios {
    private static RepositorioDeSocios repo;

    static {
        repo = null;
    }

    public static RepositorioDeSocios get(){
        if(repo == null){
            if(Config.useDataBase){
                HibernateHandler<Socio> hibernate = new HibernateHandler<>(Socio.class);
                repo = new RepositorioDeSocios(hibernate);
            }
            else{
                repo = new RepositorioDeSocios(new MemoriaHandler<>(Data.getData(Socio.class)));
            }
        }
        return repo;
    }
}