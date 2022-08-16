package Domain.Entrada;

import Domain.BaseDeDatos.EntidadPersistente;

public abstract class EntradaDecorator extends EntidadPersistente implements Entrada {
    
    private Entrada entrada;

    // CONSTRUCTOR

    public EntradaDecorator(EntradaComun entrada) {
        this.entrada = entrada;
    }

    // GETTERS

    public Entrada getEntrada() {
        return entrada;
    }

    // SETTERS

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    // METHODS

    public void accederEstadio(){

    }

   

}