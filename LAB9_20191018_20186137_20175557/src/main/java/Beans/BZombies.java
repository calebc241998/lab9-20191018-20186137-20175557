package Beans;

public class BZombies {
    private String idHumanos;
    private String fechaInfeccion;
    private int idVariante;
    private int idTipo;
    private int victimas;

    public BZombies(String idhumano, String nombre, String sexo, String tiempo_infeccion, int idVariante, int victimas, String nombre_tipo) {

    }

    public String getIdHumanos() {
        return idHumanos;
    }

    public void setIdHumanos(String idHumanos) {
        this.idHumanos = idHumanos;
    }

    public String getFechaInfeccion() {
        return fechaInfeccion;
    }

    public void setFechaInfeccion(String fechaInfeccion) {
        this.fechaInfeccion = fechaInfeccion;
    }

    public int getIdVariante() {
        return idVariante;
    }

    public void setIdVariante(int idVariante) {
        this.idVariante = idVariante;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getVictimas() {
        return victimas;
    }

    public void setVictimas(int victimas) {
        this.victimas = victimas;
    }
}
