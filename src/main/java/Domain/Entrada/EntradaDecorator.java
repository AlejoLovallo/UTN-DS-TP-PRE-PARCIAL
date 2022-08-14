package Domain.Entrada;

public abstract class EntradaDecorator implements Entrada {
    
    private Entrada entrada;

    // CONSTRUCTOR

    public EntradaDecorator(Entrada entrada) {
        this.entrada = entrada;
    }

    // METHODS

    public void accederEstadio(){

    }

   

}