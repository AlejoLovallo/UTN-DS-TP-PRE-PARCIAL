package Domain.Entrada;

public class Comun extends EntradaDecorator {

    private Entrada entrada;

    public Comun (Entrada entrada){
        super(entrada);
    }
    
}
