package Domain.Entrada;

public class ConEstacionamiento extends EntradaDecorator {
    
    private Entrada entrada;

    public ConEstacionamiento (Entrada entrada){
        super(entrada);
    }

    // METHODS

    public void accederEstacionamiento(){
        
    }
}
