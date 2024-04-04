package io.riwi.entity;

public class Paciente {
    private int idPaciente;
    private String nombrePaciente;

    private String apellidosPaciente;
    private String fechaNaciemiento;
    private String documentoIdentidad;

    public Paciente(){}
    public Paciente(int idPaciente) {
        this.idPaciente = idPaciente;}

    public Paciente( String nombrePaciente, String apellidosPaciente, String fechaNaciemiento, String documentoIdentidad) {
        this.nombrePaciente = nombrePaciente;
        this.apellidosPaciente = apellidosPaciente;
        this.fechaNaciemiento = fechaNaciemiento;
        this.documentoIdentidad = documentoIdentidad;
    }

    public Paciente(int idPaciente, String nombrePaciente, String apellidosPaciente, String fechaNaciemiento, String documentoIdentidad) {
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.apellidosPaciente = apellidosPaciente;
        this.fechaNaciemiento = fechaNaciemiento;
        this.documentoIdentidad = documentoIdentidad;
    }
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public String getFechaNaciemiento() {
        return fechaNaciemiento;
    }

    public void setFechaNaciemiento(String fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", nombre= '" + nombrePaciente + '\'' +
                ", apellidos= '" + apellidosPaciente + '\'' +
                ", fecha de naciemiento= '" + fechaNaciemiento + '\'' +
                ", documento de Identidad= " + documentoIdentidad +
                "}\n";
    }
}
