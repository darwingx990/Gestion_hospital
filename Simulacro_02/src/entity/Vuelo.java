package entity;

public class Vuelo {
    private int idVuelo;
    private String destinoVuelo;
    private String fechaSalidaVuelo;
    private String horaSalidaVuelo;
    private int idAvionVuelo;
    private Avion objAvion;

    public Vuelo() {
    }

    public Vuelo(int idVuelo, String destinoVuelo, String fechaSalidaVuelo, String horaSalidaVuelo, int idAvionVuelo) {
        this.idVuelo = idVuelo;
        this.destinoVuelo = destinoVuelo;
        this.fechaSalidaVuelo = fechaSalidaVuelo;
        this.horaSalidaVuelo = horaSalidaVuelo;
        this.idAvionVuelo = idAvionVuelo;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getDestinoVuelo() {
        return destinoVuelo;
    }

    public void setDestinoVuelo(String destinoVuelo) {
        this.destinoVuelo = destinoVuelo;
    }

    public String getFechaSalidaVuelo() {
        return fechaSalidaVuelo;
    }

    public void setFechaSalidaVuelo(String fechaSalidaVuelo) {
        this.fechaSalidaVuelo = fechaSalidaVuelo;
    }

    public String getHoraSalidaVuelo() {
        return horaSalidaVuelo;
    }

    public void setHoraSalidaVuelo(String horaSalidaVuelo) {
        this.horaSalidaVuelo = horaSalidaVuelo;
    }

    public int getIdAvionVuelo() {
        return idAvionVuelo;
    }

    public void setIdAvionVuelo(int idAvionVuelo) {
        this.idAvionVuelo = idAvionVuelo;
    }

    public Avion getObjAvion() {
        return objAvion;
    }

    public void setObjAvion(Avion objAvion) {
        this.objAvion = objAvion;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "idVuelo=" + idVuelo +
                ", destinoVuelo='" + destinoVuelo + '\'' +
                ", fechaSalidaVuelo='" + fechaSalidaVuelo + '\'' +
                ", horaSalidaVuelo='" + horaSalidaVuelo + '\'' +
                ", idAvionVuelo=" + idAvionVuelo +
                ", objAvion=" + objAvion +
                '}';
    }
}
