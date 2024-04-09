package io.riwi.model;

import io.riwi.database.ConfigDB;
import io.riwi.entity.Medico;
import io.riwi.entity.Paciente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelPaciente {
    public static List<Paciente> listarPaciente() {
        List<Paciente>pacientes = new ArrayList<>();
        PreparedStatement psPaciente;
        ResultSet rsPaciente;
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM paciente ORDER BY id_paciente;";
        try {
            psPaciente = connection.prepareStatement(sql);
            rsPaciente = psPaciente.executeQuery();

            while (rsPaciente.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rsPaciente.getInt("id_paciente"));
                paciente.setNombrePaciente(rsPaciente.getString("nombre"));
                paciente.setApellidosPaciente(rsPaciente.getString("apellidos"));
                paciente.setFechaNaciemiento(rsPaciente.getString("fecha_nacimiento"));
                paciente.setDocumentoIdentidad(rsPaciente.getString("documento_identidad"));



                pacientes.add(paciente);
            }
//            JOptionPane.showMessageDialog(null, pacientes);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar los datos. " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
            return pacientes;
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
            JOptionPane.showMessageDialog(null,"Registro eliminado exitosamente");
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar medico >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }


//    public static void main(String[] args) {
//        listarPaciente();
//
////        Paciente paciente1 = new Paciente("Gabriel", "Serna", "1996-06-01", "1077481554");
////        agregarPaciente(paciente1);
////        listarPaciente();
//
////        Paciente pcteModificar = new Paciente(1, "Ayda", "Serna", "2008-07-25", "356012015");
////        modificarPaciente(pcteModificar);
////        listarPaciente();
//
//        Paciente pcteEliminar = new Paciente(5);
//        eliminarPaciente(pcteEliminar);
//        listarPaciente();
//
//    }

}

