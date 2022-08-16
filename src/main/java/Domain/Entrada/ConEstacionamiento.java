package Domain.Entrada;

import javax.persistence.*;

@Entity
@Table(name="EntradaConEstacionamiento")

public class ConEstacionamiento extends EntradaDecorator {
    
    private Entrada entrada;

    @Column
    private int numCochera;

    // CONSTRUCTOR

    public ConEstacionamiento (EntradaComun entrada){
        super(entrada);
    }

    // GETTERS

    public Entrada getEntrada() {
        return entrada;
    }

    public int getNumCochera() {
        return numCochera;
    }

    // SETTERS

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public void setNumCochera(int numCochera) {
        this.numCochera = numCochera;
    }
    
    // METHODS

    public void accederEstacionamiento(){
        
    }

    
}
