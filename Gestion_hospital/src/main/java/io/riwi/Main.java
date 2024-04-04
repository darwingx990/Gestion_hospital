package io.riwi;

import io.riwi.entity.Medico;
import io.riwi.model.ModelMedico;

public class Main {
    public static void main(String[] args) {
//        Especialidad especialidad = new Especialidad("Endocrinologia", "Se encargar analizar las hormonas de tiroides.");
//        ModelEspecialidad.agregarEspecialidad(especialidad);
//        Especialidad espModificar = new Especialidad(1, "Nutricionista", "Encargado de la alimentacion saludable.");
//        ModelEspecialidad.modificarEspecialidad(espModificar);
//        ModelEspecialidad.listarEspecialidades();
//        Especialidad espEliminar = new Especialidad(1);
//        ModelEspecialidad.eliminarEspecialidad(espEliminar);
//        ModelEspecialidad.listarEspecialidades();

        ModelMedico.listarMedicos();
        Medico medicoEliminar = new Medico(6, "Johan", "Mosquera", 3);
        ModelMedico.modificarMedico(medicoEliminar);
        ModelMedico.listarMedicos();
//        Medico medico = new Medico("Vanessa","Andrade", 3);
//        ModelMedico.agregarMedico(medico);
        ModelMedico.listarMedicos();
    }
}