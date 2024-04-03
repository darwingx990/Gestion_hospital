package io.riwi.model;

import io.riwi.database.ConfigDB;
import io.riwi.entity.Medico;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelMedico {
    public static List<Medico> listarMedicos() {
        List<Medico> medicos = new ArrayList<>();
        PreparedStatement psMedico;
        ResultSet rsMedico;
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM medico ORDER BY id_medico;";
        try {
            psMedico = connection.prepareStatement(sql);
            rsMedico = psMedico.executeQuery();

            while (rsMedico.next()) {
                Medico medico = new Medico();
                medico.setIdMedico(rsMedico.getInt("id_medico"));
                medico.setNombre(rsMedico.getString("nombre"));
                medico.setApellidos(rsMedico.getString("apellidos"));
                medico.setIdEspecialidad(rsMedico.getInt("fk_id_especialidad"));

                medicos.add(medico);
            }
            JOptionPane.showMessageDialog(null, medicos);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar los datos. " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
            return medicos;
    }

    public static boolean agregarMedico(Medico medico) {
        PreparedStatement psMedico;
        Connection connection = ConfigDB.openConnection();
        String sql = "INSERT INTO medico(nombre, apellidos, fk_id_especialidad) VALUES (?, ?, ?);";
        try {
            psMedico = connection.prepareStatement(sql);

            psMedico.setString(1, medico.getNombre());
            psMedico.setString(2, medico.getApellidos());
            psMedico.setInt(3, medico.getIdEspecialidad());
            psMedico.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar medico >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

    public static boolean modificarMedico(Medico medico) {
        PreparedStatement psMedico;
        Connection connection = ConfigDB.openConnection();
        String sql = "UPDATE medico SET nombre=?, apellidos=?, fk_id_especialidad=? WHERE id_medico=?;";
        try {
            psMedico = connection.prepareStatement(sql);
            psMedico.setString(1, medico.getNombre());
            psMedico.setString(2, medico.getApellidos());
            psMedico.setInt(3, medico.getIdEspecialidad());
            psMedico.setInt(4, medico.getIdMedico());
            psMedico.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar medico >>" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

    public static boolean eliminarMedico(Medico medico) {
        PreparedStatement psMedico;
        Connection connection = ConfigDB.openConnection();
        String sql = "DELETE FROM medico WHERE id_medico=?;";
        try {
            psMedico = connection.prepareStatement(sql);
            psMedico.setInt(1, medico.getIdMedico());
            psMedico.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar medico >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

}

