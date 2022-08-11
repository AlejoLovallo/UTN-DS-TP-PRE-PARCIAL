package Domain.Equipo;
import Domain.Empleado.Empleado;
import Domain.Entrenamiento.Entrenamiento;
import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private String pais;
    private String ciudad;
    private ArrayList<Empleado> empleados;
    private ArrayList<Entrenamiento> entrenamientos;
    private Estado estado;
    private Usuario usuario;

    public void crearEmpleado(Empleado){

    }

    public void cargarPlantel (List <Futbolista> futbolistas){

    }

    public void altaEntrenamiento (Entrenamiento entrenamiento){
        this.getEntrenamientos().add(entrenamiento);
    }

    public void obtenerEstadisticasEstado()[

    ]

    public notificarObserver(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(ArrayList<Entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}