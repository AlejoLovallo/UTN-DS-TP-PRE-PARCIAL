package Domain.Entrada;

import javax.persistence.*;

import Domain.BaseDeDatos.EntidadPersistente;

@Entity
@Table(name="EntradaComun")

public class EntradaComun extends EntidadPersistente implements Entrada  {

    @Column
    public Double precio;

    @Column
    public String platea;

    @Column
    public String sector;

    @Column
    public int asiento;

    public void accederEstadio(){

    }
    
}