package Beans;

public class BVariante extends BVirus{
    private int idVariante;
    private String nombreVariante;
    private int casos;

    public BVariante(int idVirus, String nombreVirus, int idVariante, String nombreVariante, int casos) {
        super(idVirus, nombreVirus);
        this.idVariante = idVariante;
        this.nombreVariante = nombreVariante;
        this.casos = casos;
    }

    public int getIdVariante() {
        return idVariante;
    }

    public void setIdVariante(int idVariante) {
        this.idVariante = idVariante;
    }

    public String getNombreVariante() {
        return nombreVariante;
    }

    public void setNombreVariante(String nombreVariante) {
        this.nombreVariante = nombreVariante;
    }

    public int getCasos() {
        return casos;
    }

    public void setCasos(int casos) {
        this.casos = casos;
    }
}
