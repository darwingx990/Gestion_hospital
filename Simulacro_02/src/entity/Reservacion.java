package entity;

public class Reservacion {
    private int idReservacion;
    private int idPasajeroReservacion;
    private Pasajero objPasajero;
    private int idVueloReservacion;
    private Vuelo objVuelo;
    private String fechaReservacion;
    private String asientoReservacion;

    public Reservacion() {
    }

    public Reservacion(int idReservacion, int idPasajeroReservacion, int idVueloReservacion, String fechaReservacion, String asientoReservacion) {
        this.idReservacion = idReservacion;
        this.idPasajeroReservacion = idPasajeroReservacion;
        this.idVueloReservacion = idVueloReservacion;
        this.fechaReservacion = fechaReservacion;
        this.asientoReservacion = asientoReservacion;
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public int getIdPasajeroReservacion() {
        return idPasajeroReservacion;
    }

    public void setIdPasajeroReservacion(int idPasajeroReservacion) {
        this.idPasajeroReservacion = idPasajeroReservacion;
    }

    public Pasajero getObjPasajero() {
        return objPasajero;
    }

    public void setObjPasajero(Pasajero objPasajero) {
        this.objPasajero = objPasajero;
    }

    public int getIdVueloReservacion() {
        return idVueloReservacion;
    }

    public void setIdVueloReservacion(int idVueloReservacion) {
        this.idVueloReservacion = idVueloReservacion;
    }

    public Vuelo getObjVuelo() {
        return objVuelo;
    }

    public void setObjVuelo(Vuelo objVuelo) {
        this.objVuelo = objVuelo;
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getAsientoReservacion() {
        return asientoReservacion;
    }

    public void setAsientoReservacion(String asientoReservacion) {
        this.asientoReservacion = asientoReservacion;
    }

    @Override
    public String toString() {
        return "Reservacion{" +
                "idReservacion=" + idReservacion +
                ", idPasajeroReservacion=" + idPasajeroReservacion +
                ", objPasajero=" + objPasajero +
                ", idVueloReservacion=" + idVueloReservacion +
                ", objVuelo=" + objVuelo +
                ", fechaReservacion='" + fechaReservacion + '\'' +
                ", asientoReservacion='" + asientoReservacion + '\'' +
                '}';
    }
}
