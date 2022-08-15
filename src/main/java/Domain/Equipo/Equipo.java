package Domain.Equipo;
import Domain.Empleado.*;
import Domain.Entrenamiento.Entrenamiento;
import Domain.Usuarios.*;
import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private String pais;
    private String ciudad;
    private ArrayList<Empleado> empleados;
    private ArrayList<Entrenamiento> entrenamientos;
    private Estado estado;
    private Usuario usuario;
    private ArrayList <Observer> observers;

    // CONSTRUCTOR

    public Equipo(String nombre, String pais, String ciudad, ArrayList<Empleado> empleados,
            ArrayList<Entrenamiento> entrenamientos, Estado estado, Usuario usuario) {
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.empleados = empleados;
        this.entrenamientos = entrenamientos;
        this.estado = estado;
        this.usuario = usuario;
    }

    // GETTERS

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public Estado getEstado() {
        return estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }
    
    // SETTERS    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setEntrenamientos(ArrayList<Entrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // METHODS

    public void crearEmpleado(Empleado empleado){
        // Clone
    }

    public void cargarPlantel (ArrayList <Futbolista> futbolistas){
        // Clone
    }

    public ArrayList <Futbolista> getFutbolistas(){
        ArrayList <Futbolista> futbolistas = new ArrayList<>();

        for (Empleado empleado : this.getEmpleados()){
            if (empleado instanceof Futbolista){
                futbolistas.add((Futbolista) empleado);
            }
        }
        
        return futbolistas;

    }

    public void altaEntrenamiento (Entrenamiento entrenamiento){
        this.getEntrenamientos().add(entrenamiento);
    }

    public void obtenerEstadisticasEstado(){

    }

    public void addObserver(Observer obj) {
        if(obj == null)
         throw new NullPointerException("Null Observer");
		if(!observers.contains(obj))
         observers.add(obj);
    }

    public void removeObserver(Observer obj) {
        observers.remove(obj);
    }

    public void notificarObserver(){

		for (Observer obj : this.getObservers()) {
			obj.update();
		}
    }

    
}