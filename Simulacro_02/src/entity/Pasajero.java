package entity;

public class Pasajero {
    private int idPasajero;
    private String nombrePasajero;
    private String apellidoPasajero;
    private String documentoIdentidadPasajero;

    public Pasajero() {
    }

    public Pasajero(int idPasajero, String nombrePasajero, String apellidoPasajero, String documentoIdentidadPasajero) {
        this.idPasajero = idPasajero;
        this.nombrePasajero = nombrePasajero;
        this.apellidoPasajero = apellidoPasajero;
        this.documentoIdentidadPasajero = documentoIdentidadPasajero;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public String getApellidoPasajero() {
        return apellidoPasajero;
    }

    public void setApellidoPasajero(String apellidoPasajero) {
        this.apellidoPasajero = apellidoPasajero;
    }

    public String getDocumentoIdentidadPasajero() {
        return documentoIdentidadPasajero;
    }

    public void setDocumentoIdentidadPasajero(String documentoIdentidadPasajero) {
        this.documentoIdentidadPasajero = documentoIdentidadPasajero;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "idPasajero=" + idPasajero +
                ", nombrePasajero='" + nombrePasajero + '\'' +
                ", apellidoPasajero='" + apellidoPasajero + '\'' +
                ", documentoIdentidadPasajero='" + documentoIdentidadPasajero + '\'' +
                '}';
    }
}
