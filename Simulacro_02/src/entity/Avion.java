package entity;

public class Avion {
    private int idAvion;
    private String modeloAvion;
    private int capacidadAvion;

    public Avion() {
    }

    public Avion(int idAvion, String modeloAvion, int capacidadAvion) {
        this.idAvion = idAvion;
        this.modeloAvion = modeloAvion;
        this.capacidadAvion = capacidadAvion;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public String getModeloAvion() {
        return modeloAvion;
    }

    public void setModeloAvion(String modeloAvion) {
        this.modeloAvion = modeloAvion;
    }

    public int getCapacidadAvion() {
        return capacidadAvion;
    }

    public void setCapacidadAvion(int capacidadAvion) {
        this.capacidadAvion = capacidadAvion;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "idAvion=" + idAvion +
                ", modeloAvion='" + modeloAvion + '\'' +
                ", capacidadAvion=" + capacidadAvion +
                '}';
    }
}
