package Domain.Empleado;

import java.util.HashMap;
import java.util.Map;

public class EmpleadoStore {
  private static Map<String,Empleado> employeeMap = new HashMap<String,Empleado>();

  static {
    employeeMap.put("Futbolista",new Futbolista());
    employeeMap.put("Entrenador",new Entrenador());
  }

  public static Empleado getEmpleado(String _employeeName){
    return (Empleado) employeeMap.get(_employeeName);
  }

}
