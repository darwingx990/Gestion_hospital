package io.riwi.entity;

public class Cita {
    private int idCitas;
    private int idPaciente;
    private int idMedico;
    private String fechaCita;
    private String horaCita;
    private String motivoCita;

    private Medico objMedico;
    private Paciente objPaciente;

    public Cita(){

    }

    public Cita(int idCitas) {
        this.idCitas = idCitas;
    }

    public Cita(int idCitas, int idPaciente, int idMedico, String fechaCita, String horaCita, String motivoCita) {
        this.idCitas = idCitas;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.motivoCita = motivoCita;
    }

    public int getIdCitas() {
        return idCitas;
    }

    public void setIdCitas(int idCitas) {
        this.idCitas = idCitas;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public Medico getObjMedico() {
        return objMedico;
    }

    public void setObjMedico(Medico objMedico) {
        this.objMedico = objMedico;
    }

    public Paciente getObjPaciente() {
        return objPaciente;
    }

    public void setObjPaciente(Paciente objPaciente) {
        this.objPaciente = objPaciente;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCitas=" + idCitas +
                ", fechaCita='" + fechaCita + '\'' +
                ", horaCita='" + horaCita + '\'' +
                ", motivoCita='" + motivoCita + '\'' +
                ", Medico='" + objMedico.getNombre() + '\'' +
                ", Paciente='" + objPaciente.getNombrePaciente() + '\'' +
                "}\n";
    }
}
