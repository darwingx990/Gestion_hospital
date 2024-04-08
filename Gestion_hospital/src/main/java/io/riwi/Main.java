package io.riwi;

import io.riwi.controller.ControllerEspecialidad;
import io.riwi.controller.ControllerPaciente;
import io.riwi.entity.Medico;
import io.riwi.model.ModelMedico;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int option1 = 0, option2 = 0;

        do {
            try {
                option1 = Integer.parseInt(JOptionPane.showInputDialog("""
                        ========================
                            MENU DE OPCIONES
                        ========================
                        1. Administrar Especialidades
                        2. Administrar Medicos
                        3. Administrar Paciente
                        4. Administrar Citas
                        5. Salir
                                            
                        Ingrese una opción:
                        """));

                switch (option1) {
                    case 1:
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Agregar Especialidad
                                2. Listar Especialidad
                                3. Actualizar Especialidad
                                4. Eliminar Especialidad
                                5. Regresar
                                                    
                                Ingrese un opción:
                                """));
                        switch (option2) {
                            case 1:
                                ControllerEspecialidad.insertarEspecialidad();
                                break;

                            case 2:
                                ControllerEspecialidad.listarEspecialidad();
                                break;

                            case 3:
                                ControllerEspecialidad.modificarEspecialidad();
                                break;

                            case 4:
                                ControllerEspecialidad.deleteEspecialista();
                                break;

                            case 5:
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no valida.");
                                break;
                        }

                    case 3:
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Agregar Paciente
                                2. Listar Paciente
                                3. Actualizar Paciente
                                4. Eliminar Paciente
                                5. Regresar
                                                    
                                Ingrese un opción:
                                """));
                        switch (option2) {
                            case 1:
                                ControllerPaciente.insertarPaciente();
                                break;

                            case 2:
                                ControllerPaciente.listarPaciente();
                                break;

                            case 3:
                                ControllerPaciente.modificarPaciente();
                                break;

                            case 4:
                                ControllerPaciente.deletePaciente();
                                break;

                            case 5:
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no valida.");
                                break;
                        }

                    case 5:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida. Intentalo nuevamente. opttoon");
                        break;
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Opcion no valida. Intentalo nuevamente.");
            }
        } while (option1 != 5);
        JOptionPane.showMessageDialog(null, "Hasta pronto 👍");
    }
}