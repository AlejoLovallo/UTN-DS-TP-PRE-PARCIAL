package Domain.Empleado;

import javax.persistence.*;

@Entity
@Table(name="Futbolista")

public class Entrenador extends Empleado {
  private String matricula;

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getMatricula() {
    return matricula;
  }

  public Entrenador(){
    this.employeeName = "Entrenador";
  }

}