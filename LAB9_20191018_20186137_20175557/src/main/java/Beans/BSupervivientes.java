package Beans;

public class BSupervivientes extends BHumanos {
    private Float peso;
    private Float fuerza;
    private String idPareja;

    public BSupervivientes(String idHumanos, String nombre, String apellido, String sexo, int estado, Float peso, Float fuerza, String idPareja) {
        super(idHumanos, nombre, apellido, sexo, estado);
        this.peso = peso;
        this.fuerza = fuerza;
        this.idPareja = idPareja;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getFuerza() {
        return fuerza;
    }

    public void setFuerza(Float fuerza) {
        this.fuerza = fuerza;
    }

    public String getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(String idPareja) {
        this.idPareja = idPareja;
    }
}
