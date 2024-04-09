package io.riwi.controller;

import io.riwi.entity.Especialidad;
import io.riwi.entity.Medico;
import io.riwi.model.ModelEspecialidad;
import io.riwi.model.ModelMedico;
import io.riwi.utils.Utils;

import javax.swing.*;

public class ControllerMedico {

    public static void insertarMedico() {
        String name = JOptionPane.showInputDialog("Ingrese el nombre de la especialidad:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del medico:");
        Object[] options = Utils.listToArray(ModelEspecialidad.listarEspecialidades());

        Especialidad especialidadMedico = (Especialidad) JOptionPane.showInputDialog(null, "Seleccione una especialidad:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        Medico nuevoMedico = new Medico(name, apellido, especialidadMedico.getIdEspecialidad(), especialidadMedico);

        ModelMedico.agregarMedico(nuevoMedico);
        JOptionPane.showMessageDialog(null, "Medico agregado correctamente.");
    }

    public static void listarMedico() {
        String listaMedico = """
                ========================
                   LISTA DE MEDICOS
                ========================
                """;
        for (Medico medico : ModelMedico.listarMedicos()) {
            listaMedico += medico;
        }
        JOptionPane.showMessageDialog(null, listaMedico);
    }

    public static void modificarMedico() {
        Object[] options = Utils.listToArray(ModelMedico.listarMedicos());
        Medico medicoModificar = (Medico) JOptionPane.showInputDialog(null, "Seleecione el medico a eliminar:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        String name = JOptionPane.showInputDialog("Ingrese el nombre de la especialidad:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del medico:");

        Object[] options2 = Utils.listToArray(ModelEspecialidad.listarEspecialidades());
        Especialidad especialidadMedico = (Especialidad) JOptionPane.showInputDialog(null, "Seleccione una especialidad:", "", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);

        medicoModificar.setNombre(name);
        medicoModificar.setApellidos(apellido);
        medicoModificar.setEspecialidadMedico(especialidadMedico);

        ModelMedico.modificarMedico(medicoModificar);
        JOptionPane.showMessageDialog(null, "Registro actualizado correctamente.");
    }


    public static void deleteMedico() {
        Object[] options = Utils.listToArray(ModelMedico.listarMedicos());
        Medico medicoEliminar = (Medico) JOptionPane.showInputDialog(null, "Seleecione el medico a eliminar:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        ModelMedico.eliminarMedico(medicoEliminar);
        JOptionPane.showMessageDialog(null,"Registro eliminado exitosamente");
    }

    public static void eliminarEspecialidad() {
        try {
            Especialidad idEspecialidad = new Especialidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del medico a eliminar\n" + ModelEspecialidad.listarEspecialidades())));
            ModelEspecialidad.eliminarEspecialidad(idEspecialidad);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar especialista.");
        }

    }
}
