package Beans;

public class BHumanos {
    private String idHumanos;
    private String nombre;
    private String sexo;
    private String estado;

    public BHumanos(String idHumanos, String nombre, String sexo) {
        this.idHumanos = idHumanos;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public BHumanos(String idHumanos, String nombre, String sexo, String estado) {
        this.idHumanos = idHumanos;
        this.nombre = nombre;
        this.sexo = sexo;
        this.estado = estado;
    }

    public BHumanos(String idhumano, String nombre, String sexo, Float peso, Float fuerza) {

    }

    public String getIdHumanos() {
        return idHumanos;
    }

    public void setIdHumanos(String idHumanos) {
        this.idHumanos = idHumanos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
