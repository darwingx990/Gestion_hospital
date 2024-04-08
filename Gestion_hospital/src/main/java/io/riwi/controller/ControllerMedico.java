package io.riwi.controller;
import io.riwi.entity.Especialidad;
import io.riwi.entity.Medico;
import io.riwi.model.ModelEspecialidad;
import io.riwi.utils.Utils;

import javax.swing.*;

public class ControllerMedico {

    public static void insertarMedico() {
        String name = JOptionPane.showInputDialog("Ingrese el nombre de la especialidad:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del medico:");
       Object[] options = Utils.listToArray(ModelEspecialidad.listarEspecialidades());
//Especialidad idEspecialidad = (String) options;
        Medico nuevoMedico = new Medico(name, apellido, Integer.parseInt(options));

        ModelEspecialidad.agregarEspecialidad(nuevoMedico);
        JOptionPane.showMessageDialog(null, "Especialidad agregada correctamente.");
    }

    public static void listarEspecialidad() {
        String listaEspecialidades = """
                ========================
                  LISTA ESPECIALIDADES
                ========================
                """;
//        List<Especialidad> listaEsp = ModelEspecialidad.listarEspecialidades();
        for (Especialidad especialidad : ModelEspecialidad.listarEspecialidades()) {
            listaEspecialidades += especialidad;
        }
        JOptionPane.showMessageDialog(null, listaEspecialidades);
    }

    public static void modificarEspecialidad() {
        Object[] options = Utils.listToArray(ModelEspecialidad.listarEspecialidades());
        Especialidad espModificar = (Especialidad) JOptionPane.showInputDialog(null, "Seleecione la especialidad que quiere modificar:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        String nombre = JOptionPane.showInputDialog("Ingrese la nueva especialidad:");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion");

        espModificar.setNombre(nombre);
        espModificar.setDescripcion(descripcion);

        ModelEspecialidad.modificarEspecialidad(espModificar);
        JOptionPane.showMessageDialog(null, "Especialidad actualizada correctamente.");


//        PRIMER INTENTO. POCO EFECTIVO.
//        List<Especialidad> listaEsp = ModelEspecialidad.listarEspecialidades();
//        Especialidad idModificar = new Especialidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la esecialidad a modificar:\n" + ModelEspecialidad.listarEspecialidades())));
//        if (listaEsp.contains(idModificar.getIdEspecialidad())) {
//            String nombre = JOptionPane.showInputDialog("Ingrese la nueva especialidad:");
//            String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion");
//            Especialidad espModificar = new Especialidad(idModificar.getIdEspecialidad(), nombre, descripcion);
//            boolean modificado = ModelEspecialidad.modificarEspecialidad(espModificar);
//        } else {
//            JOptionPane.showMessageDialog(null, "Error al modificar especialidad.");
//        }
    }

    public static void eliminarEspecialidad() {
        try {
            Especialidad idEspecialidad = new Especialidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del medico a eliminar\n" + ModelEspecialidad.listarEspecialidades())));
            ModelEspecialidad.eliminarEspecialidad(idEspecialidad);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar especialista.");
        }

    }

    public static void deleteEspecialista() {
        Object[] options = Utils.listToArray(ModelEspecialidad.listarEspecialidades());
        Especialidad espEliminar = (Especialidad) JOptionPane.showInputDialog(null, "Seleecione una especialidad:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        ModelEspecialidad.eliminarEspecialidad(espEliminar);
    }
}
