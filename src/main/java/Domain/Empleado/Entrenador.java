package Domain.Empleado;

import javax.persistence.*;

@Entity
@Table(name="Entrenador")

public class Entrenador extends Empleado {

  public Entrenador(){
    this.employeeName = "Entrenador";
  }

}