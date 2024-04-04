package io.riwi.model;

import io.riwi.database.ConfigDB;
import io.riwi.entity.Cita;
import io.riwi.entity.Medico;
import io.riwi.entity.Paciente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelCita {
    public static List<Cita> listarPaciente() {
        List<Cita >citas = new ArrayList<>();
        PreparedStatement psPaciente;
        ResultSet rsPaciente;
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM cita INNER JOIN paciente ON paciente.id_paciente = cita.fk_id_paciente " +
                "INNER JOIN medico ON medico.id_medico = cita.fk_id_medico ORDER BY id_paciente;";
        try {
            psPaciente = connection.prepareStatement(sql);
            rsPaciente = psPaciente.executeQuery();

            while (rsPaciente.next()) {
                Cita cita = new Cita();
                Medico medico  = new Medico();
                Paciente paciente = new Paciente();

                cita.setIdCitas(rsPaciente.getInt("cita.id_cita"));
                cita.setFechaCita(rsPaciente.getString("cita.fecha_cita"));
                cita.setHoraCita(rsPaciente.getString("cita.hora_cita"));
                cita.setIdPaciente(rsPaciente.getInt("cita.fk_id_paciente"));
                cita.setIdMedico(rsPaciente.getInt("cita.fk_id_medico"));
                cita.setMotivoCita(rsPaciente.getString("cita.motivo_cita"));


                paciente.setIdPaciente(rsPaciente.getInt("paciente.id_paciente"));
                paciente.setNombrePaciente(rsPaciente.getString("paciente.nombre"));
                paciente.setApellidosPaciente(rsPaciente.getString("paciente.apellidos"));
                paciente.setFechaNaciemiento(rsPaciente.getString("paciente.fecha_nacimiento"));
                paciente.setDocumentoIdentidad(rsPaciente.getString("paciente.documento_identidad"));

                medico.setIdMedico(rsPaciente.getInt("medico.id_medico"));
                medico.setNombre(rsPaciente.getString("medico.nombre"));
                medico.setApellidos(rsPaciente.getString("medico.apellidos"));
                medico.setIdEspecialidad(rsPaciente.getInt("medico.fk_id_especialidad"));

                cita.setObjPaciente(paciente);
                cita.setObjMedico(medico);
                citas.add(cita);
            }
            JOptionPane.showMessageDialog(null, citas);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar los datos. " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
            return citas;
    }

    public static boolean agregarPaciente(Paciente paciente) {
        PreparedStatement psPaciente;
        Connection connection = ConfigDB.openConnection();
        String sql = "INSERT INTO paciente(nombre, apellidos, fecha_nacimiento,documento_identidad) VALUES (?, ?, ?, ?);";
        try {
            psPaciente = connection.prepareStatement(sql);

            psPaciente.setString(1, paciente.getNombrePaciente());
            psPaciente.setString(2, paciente.getApellidosPaciente());
            psPaciente.setString(3, paciente.getFechaNaciemiento());
            psPaciente.setString(4, paciente.getDocumentoIdentidad());
            psPaciente.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar paciente >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

    public static boolean modificarPaciente(Paciente paciente) {
        PreparedStatement psPaciente;
        Connection connection = ConfigDB.openConnection();
        String sql = "UPDATE paciente SET nombre=?, apellidos=?, fecha_nacimiento=?,documento_identidad=? WHERE id_paciente=?;";
        try {
            psPaciente = connection.prepareStatement(sql);

            psPaciente.setString(1, paciente.getNombrePaciente());
            psPaciente.setString(2, paciente.getApellidosPaciente());
            psPaciente.setString(3, paciente.getFechaNaciemiento());
            psPaciente.setString(4, paciente.getDocumentoIdentidad());
            psPaciente.setInt(5, paciente.getIdPaciente());
            psPaciente.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar paciente >>" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

    public static boolean eliminarPaciente(Paciente paciente) {
        PreparedStatement psPaciente;
        Connection connection = ConfigDB.openConnection();
        String sql = "DELETE FROM paciente WHERE id_paciente=?;";
        try {
            psPaciente = connection.prepareStatement(sql);
            psPaciente.setInt(1, paciente.getIdPaciente());
            psPaciente.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar medico >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

    public static void main(String[] args) {
        listarPaciente();

//        Paciente paciente1 = new Paciente("Gabriel", "Serna", "1996-06-01", "1077481554");
//        agregarPaciente(paciente1);
//        listarPaciente();

//        Paciente pcteModificar = new Paciente(1, "Ayda", "Serna", "2008-07-25", "356012015");
//        modificarPaciente(pcteModificar);
//        listarPaciente();

        Paciente pcteEliminar = new Paciente(5);
        eliminarPaciente(pcteEliminar);
        listarPaciente();

    }

}

