package Domain.Equipo;
import Domain.BaseDeDatos.EntidadPersistente;
import Domain.Empleado.*;
import Domain.Entrenamiento.Entrenamiento;
import Domain.Usuarios.*;
import Domain.Socio.*;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="Equipo")
public class Equipo extends EntidadPersistente {
    
    @Column
    private String nombre;

    @Column
    private String pais;

    @Column
    private String ciudad;

    @OneToMany(mappedBy = "empleadosDelEquipo",cascade = {CascadeType.ALL})
    private ArrayList<Empleado> empleados;

    @ManyToMany(cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            }, fetch = FetchType.LAZY)
    @JoinTable(name = "entrenamiento_x_equipo",joinColumns = @JoinColumn(name = "equipo_id"),inverseJoinColumns = @JoinColumn (name = "entrenamiento_id"))
    private ArrayList<Entrenamiento> entrenamientos;
    
    @OneToMany(mappedBy = "sociosDelEquipo",cascade = {CascadeType.ALL})
    private ArrayList <Socio> socios;

    @Column
    private Estado estado;

    @OneToOne
	@JoinColumn(name="usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @Transient
    private ArrayList <Observer> observers;

    // CONSTRUCTOR

    public Equipo() {
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

    public ArrayList<Socio> socios() {
        return socios;
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

    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        notificarObservers();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // METHODS

    /**
     * ADD PARAMS TO CREATE SET EMPLEADO
     * @param _empleado
     */
    public void crearEmpleado(String _empleado, String nombre,String apellido, String nacionalidad, Integer edad, Equipo equipo){
        Empleado empleado = EmpleadoStore.getEmpleado(_empleado);
        empleado.initialize(nombre,apellido,nacionalidad,edad,equipo);
        this.empleados.add(empleado);

        if (empleado instanceof Futbolista){
            new FutbolistaObserver(this, (Futbolista) empleado);
        }
    }

    public void echarEmpleado(Empleado empleado){
        this.empleados.remove(empleado);
    }


    public void altaSocio(Socio socio){
        this.socios.add(socio);
    }

    public void bajaSocio (Socio socio){
        this.socios.remove(socio);
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

    public Double duracionEntrenamientos(){
        Double duracion = 0.0;
        for(Entrenamiento entrenamiento : this.getEntrenamientos()){
            duracion += entrenamiento.duracionEntrenamiento();
        }
        return duracion;
    }

    public void altaEntrenamiento(Entrenamiento _entrenamiento){
        
        if((this.duracionEntrenamientos() + _entrenamiento.duracionEntrenamiento()) <= 360){
            this.entrenamientos.add(_entrenamiento);
        }else{
            System.out.println("No se puede agregar el entrenamiento. La duracion total excede las 4 horas diarias");
        }
           
    }

    public Double calcularPromedioEdadPlantel(){
        Double promedio = 0.0;
        

        for(Futbolista futbolista: this.getFutbolistas()){
            promedio += futbolista.getEdad();
        }

        promedio = promedio / this.getFutbolistas().size();

        return promedio;
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

    public void notificarObservers(){
		    for (Observer obj : this.getObservers()) {
			      obj.update();
		    }
    }

    
}