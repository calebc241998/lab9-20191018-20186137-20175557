package Beans;

public class BVirus {
    private int idVirus;
    private String nombreVirus;

    public BVirus(int idVirus, String nombreVirus, int idVariante, String nombre_var) {
    }

    public int getIdVirus() {
        return idVirus;
    }

    public void setIdVirus(int idVirus) {
        this.idVirus = idVirus;
    }

    public String getNombreVirus() {
        return nombreVirus;
    }

    public void setNombreVirus(String nombreVirus) {
        this.nombreVirus = nombreVirus;
    }
}
