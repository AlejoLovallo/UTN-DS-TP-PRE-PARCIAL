package Domain.Torneo;

public class Copa extends Torneo {

    private TipoDeCopa tipoDeCopa;
    private int cantGrupos;
    private int cantEquiClasif;

    // CONSTRUCTOR

    public Copa(TipoDeCopa tipoDeCopa, int cantGrupos, int cantEquiClasif) {
        this.tipoDeCopa = tipoDeCopa;
        this.cantGrupos = cantGrupos;
        this.cantEquiClasif = cantEquiClasif;
    }

    // GETTERS

    public TipoDeCopa getTipoDeCopa() {
        return tipoDeCopa;
    }

    public int getCantGrupos() {
        return cantGrupos;
    }

    public int getCantEquiClasif() {
        return cantEquiClasif;
    }

    // SETTERS

    public void setTipoDeCopa(TipoDeCopa tipoDeCopa) {
        this.tipoDeCopa = tipoDeCopa;
    }

    public void setCantGrupos(int cantGrupos) {
        this.cantGrupos = cantGrupos;
    }

    public void setCantEquiClasif(int cantEquiClasif) {
        this.cantEquiClasif = cantEquiClasif;
    }
    
    // METHODS

}