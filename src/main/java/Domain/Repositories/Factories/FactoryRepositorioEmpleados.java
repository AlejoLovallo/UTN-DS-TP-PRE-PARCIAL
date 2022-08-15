package Domain.Repositories.Factories;

import Domain.Empleado.*;
import Domain.Config.Config;
import Domain.Repositories.*;
import Domain.Repositories.Handlers.HibernateHandler;
import Domain.Repositories.Handlers.MemoriaHandler;
import Domain.Repositories.testMemoData.Data;

public class FactoryRepositorioEmpleados {
    private static RepositorioDeEmpleados repo;

    static {
        repo = null;
    }

    public static RepositorioDeEmpleados get(){
        if(repo == null){
            if(Config.useDataBase){
                HibernateHandler<Empleado> hibernate = new HibernateHandler<>(Empleado.class);
                repo = new RepositorioDeEmpleados(hibernate);
            }
            else{
                repo = new RepositorioDeEmpleados(new MemoriaHandler<>(Data.getData(Empleado.class)));
            }
        }
        return repo;
    }
}
