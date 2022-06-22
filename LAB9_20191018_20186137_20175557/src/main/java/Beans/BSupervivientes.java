package Beans;

public class BSupervivientes extends BHumanos {
    private Float peso;
    private Float fuerza;
    private String pareja;
    private Float carga;

    public BSupervivientes(String idHumanos, String nombre, String sexo, Float peso, Float fuerza, String pareja, Float carga) {
        super(idHumanos, nombre, sexo);
        this.peso = peso;
        this.fuerza = fuerza;
        this.pareja = pareja;
        this.carga = carga;
    }

    public BSupervivientes(String idhumano, String nombre, String sexo, Float peso, Float fuerza) {
        super(idhumano, nombre, sexo, peso, fuerza);
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

    public String getPareja() {
        return pareja;
    }

    public void setPareja(String Pareja) {
        this.pareja = Pareja;
    }
}
