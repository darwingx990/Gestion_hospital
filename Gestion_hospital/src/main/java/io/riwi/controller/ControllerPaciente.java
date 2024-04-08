package io.riwi.controller;

import io.riwi.entity.Especialidad;
import io.riwi.entity.Paciente;
import io.riwi.model.ModelEspecialidad;
import io.riwi.model.ModelPaciente;
import io.riwi.utils.Utils;

import javax.swing.*;

public class ControllerPaciente {
    public static void insertarPaciente() {
        String name = JOptionPane.showInputDialog("Ingrese el nombre del paciente:");
        String apellidos = JOptionPane.showInputDialog("Ingrese apellidos del paciente:");
        String fechaNaciemiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del paciente:");
        String documentoIdentidad = JOptionPane.showInputDialog("Ingrese documento de identidad del paciente:");

        Paciente paciente = new Paciente(name, apellidos, fechaNaciemiento,documentoIdentidad);
        ModelPaciente.agregarPaciente(paciente);
        JOptionPane.showMessageDialog(null, "Paciente agregado correctamente.");
    }

    public static void listarPaciente() {
        String listaPaciente = """
                ========================
                    LISTA PACIENTES
                ========================
                """;
//        List<Paciente> listPacientes = ModelPaciente.listarPaciente();
        for (Paciente paciente : ModelPaciente.listarPaciente()) {
            listaPaciente += paciente;
        }
        JOptionPane.showMessageDialog(null, listaPaciente);
    }

    public static void modificarPaciente() {
        Object[] options = Utils.listToArray(ModelPaciente.listarPaciente());
        Paciente pacienteModificar = (Paciente) JOptionPane.showInputDialog(null, "Seleecione el Paciente que quiere modificar:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        String name = JOptionPane.showInputDialog("Ingrese el nombre del paciente:");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del paciente");
        String fechaNaciemiento = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del paciente (AAAA-MM-DD):");
        String documentoIdentidad = JOptionPane.showInputDialog("Ingrese documento de identidad del paciente:");

        pacienteModificar.setNombrePaciente(name);
        pacienteModificar.setApellidosPaciente(apellidos);
        pacienteModificar.setFechaNaciemiento(fechaNaciemiento);
        pacienteModificar.setDocumentoIdentidad(documentoIdentidad);

        ModelPaciente.modificarPaciente(pacienteModificar);
        JOptionPane.showMessageDialog(null, "Paciente actualizado correctamente.");
    }

    public static void eliminarPaciente() {
        try {
            Paciente idPaciente = new Paciente(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del Paciente a eliminar\n" + ModelPaciente.listarPaciente())));
            ModelPaciente.eliminarPaciente(idPaciente);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Paciente.");
        }

    }

    public static void deletePaciente() {
        Object[] options = Utils.listToArray(ModelPaciente.listarPaciente());
        Paciente pacienteEliminar = (Paciente) JOptionPane.showInputDialog(null, "Seleecione un paciente:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        ModelPaciente.eliminarPaciente(pacienteEliminar);
        JOptionPane.showMessageDialog(null, "Paciente eliminado Correctamente.");
    }
}
