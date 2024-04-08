package io.riwi.model;

import io.riwi.database.ConfigDB;
import io.riwi.entity.Especialidad;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelEspecialidad {
    public static List<Especialidad> listarEspecialidades() {
        List<Especialidad> especialidades = new ArrayList<>();
        PreparedStatement psEspecialidad;
        ResultSet rsEspcialidad;
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM especialidad ORDER BY id_especialidad;";
        try {
            psEspecialidad = connection.prepareStatement(sql);
            rsEspcialidad = psEspecialidad.executeQuery();

            while (rsEspcialidad.next()) {
                Especialidad especialidad = new Especialidad();
                especialidad.setIdEspecialidad(rsEspcialidad.getInt("id_especialidad"));
                especialidad.setNombre(rsEspcialidad.getString("nombre"));
                especialidad.setDescripcion(rsEspcialidad.getString("descripcion"));

                especialidades.add(especialidad);
            }
//            JOptionPane.showMessageDialog(null, especialidades);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar los datos. " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
            return especialidades;


    }

    public static boolean agregarEspecialidad(Especialidad especialidad) {
        PreparedStatement psEspecialidad;
        Connection connection = ConfigDB.openConnection();
        String sql = "INSERT INTO especialidad(nombre, descripcion) VALUES (?, ?);";
        try {
            psEspecialidad = connection.prepareStatement(sql);

            psEspecialidad.setString(1, especialidad.getNombre());
            psEspecialidad.setString(2, especialidad.getDescripcion());
            psEspecialidad.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar paciente >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

    public static boolean modificarEspecialidad(Especialidad especialidad) {
        PreparedStatement psEspecialidad;
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
            JOptionPane.showMessageDialog(null,"Eliminado correctamente");
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar especialidad >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

}

