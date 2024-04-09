package io.riwi.entity;

public class Medico {
    private int idMedico;
    private String nombre;
    private String apellidos;
    private int idEspecialidad;

    private Especialidad especialidadMedico;

    public Medico() {
    }

    public Medico(int idMedico) {
        this.idMedico = idMedico;
    }

    public Medico(String nombre, String apellidos, int idEspecialidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idEspecialidad = idEspecialidad;
    }

    public Medico(int idMedico, String nombre, String apellidos, int idEspecialidad) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idEspecialidad = idEspecialidad;
    }

    public Medico(String nombre, String apellidos, int idEspecialidad, Especialidad especialidadMedico) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idEspecialidad = idEspecialidad;
        this.especialidadMedico = especialidadMedico;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public Especialidad getEspecialidadMedico() {
        return especialidadMedico;
    }

    public void setEspecialidadMedico(Especialidad especialidadMedico) {
        this.especialidadMedico = especialidadMedico;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Override
    public String toString() {
        return "\nnombre Medico: " + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", Especialidad: " + especialidadMedico.getNombre();
    }
}
