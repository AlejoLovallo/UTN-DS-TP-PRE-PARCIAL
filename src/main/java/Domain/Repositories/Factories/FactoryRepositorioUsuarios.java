package Domain.Repositories.Factories;

import Domain.Usuarios.*;
import Domain.Config.Config;
import Domain.Repositories.*;
import Domain.Repositories.Handlers.HibernateHandler;
import Domain.Repositories.Handlers.MemoriaHandler;
import Domain.Repositories.testMemoData.Data;

public class FactoryRepositorioUsuarios {
    private static RepositorioDeUsuarios repo;

    static {
        repo = null;
    }

    public static RepositorioDeUsuarios get(){
        if(repo == null){
            if(Config.useDataBase){
                HibernateHandler<Usuario> hibernate = new HibernateHandler<>(Usuario.class);
                repo = new RepositorioDeUsuarios(hibernate);
            }
            else{
                repo = new RepositorioDeUsuarios(new MemoriaHandler<>(Data.getData(Usuario.class)));
            }
        }
        return repo;
    }
}
