package Beans;

public class BVirus {
    private int idVirus;
    private String nombreVirus;

    public BVirus(int idVirus, String nombreVirus) {
        this.idVirus = idVirus;
        this.nombreVirus = nombreVirus;
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
