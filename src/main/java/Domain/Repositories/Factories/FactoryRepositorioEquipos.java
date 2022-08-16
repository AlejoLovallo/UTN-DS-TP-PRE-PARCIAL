package Domain.Repositories.Factories;

import Domain.Equipo.*;
import Domain.Config.Config;
import Domain.Repositories.*;
import Domain.Repositories.Handlers.HibernateHandler;
import Domain.Repositories.Handlers.MemoriaHandler;
import Domain.Repositories.testMemoData.Data;

public class FactoryRepositorioEquipos {
    private static RepositorioDeEquipos repo;

    static {
        repo = null;
    }

    public static RepositorioDeEquipos get(){
        if(repo == null){
            if(Config.useDataBase){
                HibernateHandler<Equipo> hibernate = new HibernateHandler<>(Equipo.class);
                repo = new RepositorioDeEquipos(hibernate);
            }
            else{
                repo = new RepositorioDeEquipos(new MemoriaHandler<>(Data.getData(Equipo.class)));
            }
        }
        return repo;
    }
}