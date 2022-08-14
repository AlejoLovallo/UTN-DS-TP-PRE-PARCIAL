package Domain.Torneo;

public class Liga extends Torneo {

    private String pais;
    private int año;
    private int cantFechas;

    // CONSTRUCTOR
    
    public Liga(String pais, int año, int cantFechas) {
        this.pais = pais;
        this.año = año;
        this.cantFechas = cantFechas;
    }

    // GETTERS

    public String getPais() {
        return pais;
    }

    public int getAño() {
        return año;
    }

    public int getCantFechas() {
        return cantFechas;
    }

    // SETTERS

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setCantFechas(int cantFechas) {
        this.cantFechas = cantFechas;
    }

    //METHODS
    
}