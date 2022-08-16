package Domain.Empleado;

import Domain.Equipo.Equipo;
import Domain.Usuarios.*;

import Domain.BaseDeDatos.EntidadPersistente;

import javax.persistence.*;


@Entity
@Table(name="Empleado")

public abstract class Empleado extends EntidadPersistente implements Cloneable {

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String nacionalidad;

    @Column
    private Integer edad;

    @ManyToOne
	@JoinColumn(name="equipo_id", referencedColumnName = "id")
    private Equipo equipo;

    @OneToOne
	@JoinColumn(name="usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @Column
    protected String employeeName; // ??

    // CONSTRUCTOR
    public Empleado(){

    }

    public void initialize(String _nombre,String _apellido, String _nacionalidad, Integer _edad, Equipo _equipo){
        this.nombre = _nombre;
        this.apellido = _apellido;
        this.nacionalidad = _nacionalidad;
        this.edad = _edad;
        this.equipo = _equipo;
    }

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    // GETTERS

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Integer getEdad() {
        return edad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public String getTipoEmpleado(){
        return this.employeeName;
    }

    // SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    // METHODS

    

    

}