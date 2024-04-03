package io.riwi.models;

import io.riwi.database.ConfigDB;
import io.riwi.entities.Especialidad;
import io.riwi.entities.Medico;

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

    public static boolean modificarEspecialidad(Especialidad especialidad) {
        PreparedStatement psEspecialidad;
        ResultSet rsEspcialidad;
        Connection connection = ConfigDB.openConnection();
        String sql = "UPDATE especialidad SET nombre=?, descripcion=?  WHERE id_especialidad=?;";
        try {
            psEspecialidad = connection.prepareStatement(sql);
            psEspecialidad.setString(1, especialidad.getNombre());
            psEspecialidad.setString(2, especialidad.getDescripcion());
            psEspecialidad.setInt(3, especialidad.getIdEspecialidad());
            psEspecialidad.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar especialidad >>" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

    public static boolean eliminarEspecialidad(Especialidad especialidad) {
        PreparedStatement psEspecialidad;
        Connection connection = ConfigDB.openConnection();
        String sql = "DELETE FROM especialidad WHERE id_especialidad=?;";
        try {
            psEspecialidad = connection.prepareStatement(sql);
            psEspecialidad.setInt(1, especialidad.getIdEspecialidad());
            psEspecialidad.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar especialidad >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

}

