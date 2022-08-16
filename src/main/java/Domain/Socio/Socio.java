package Domain.Socio;

import Domain.Entrada.Entrada;

public class Socio {

    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private TipoDeSocio tipoDeSocio;
    private String dni;
    private String mail;
    private Double valorCuota;
    private Entrada entrada;

    // CONSTRUCTOR

    public Socio(String nombre, String apellido, String fechaNacimiento, TipoDeSocio tipoDeSocio, String dni,
            String mail, Double valorCuota, Entrada entrada) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDeSocio = tipoDeSocio;
        this.dni = dni;
        this.mail = mail;
        this.valorCuota = valorCuota;
        this.entrada = entrada;
    }

    // GETTERS

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public TipoDeSocio getTipoDeSocio() {
        return tipoDeSocio;
    }

    public String getDni() {
        return dni;
    }

    public String getMail() {
        return mail;
    }

    public Double getValorCuota() {
        return valorCuota;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    // SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipoDeSocio(TipoDeSocio tipoDeSocio) {
        this.tipoDeSocio = tipoDeSocio;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setValorCuota(Double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    // METHODS


}