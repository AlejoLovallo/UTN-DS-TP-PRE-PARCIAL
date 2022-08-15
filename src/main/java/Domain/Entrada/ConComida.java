package Domain.Entrada;

import javax.persistence.*;

@Entity
@Table(name="EntradaConComida")

public class ConComida extends EntradaDecorator{

    private Entrada entrada;

    @Column
    private Double dineroParaComida;

    // CONSTRUCTOR

    public ConComida (EntradaComun entrada){
        super(entrada);
    }

    // GETTERS

    public Entrada getEntrada() {
        return entrada;
    }

    public Double getDineroParaComida() {
        return dineroParaComida;
    }

    // SETTERS

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public void setDineroParaComida(Double dineroParaComida) {
        this.dineroParaComida = dineroParaComida;
    }
    

    // METHODS

    public void accederRestaurante(){
        
    }
    
}
