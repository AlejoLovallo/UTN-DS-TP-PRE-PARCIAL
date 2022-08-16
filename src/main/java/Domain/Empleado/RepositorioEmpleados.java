package Domain.Empleado;

import java.util.ArrayList;

public class RepositorioEmpleados {

  private static RepositorioEmpleados instance = null;
  private ArrayList<Empleado> empleados;

  // CONSTRUCTORES

  private RepositorioEmpleados(){
      this.empleados = new ArrayList<>();
  }

  public static RepositorioEmpleados GetInstance(){
      if(instance == null){
        instance = new RepositorioEmpleados();
      }
      return instance;
  }
  
  // GETTERS

  public ArrayList<Empleado> getEmpleados() {
    return empleados;
  }

  // SETTERS

  public void setEmpleados(ArrayList<Empleado> empleados) {
    this.empleados = empleados;
  }

  // METHODS

  public void registrarEmpleado(Empleado empleado){
      this.empleados.add(empleado);
  }

}