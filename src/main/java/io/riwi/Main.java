package io.riwi;

import io.riwi.database.ConfigDB;
import io.riwi.entities.Especialidad;
import io.riwi.models.ModelEspecialidad;

public class Main {
    public static void main(String[] args) {
//        Especialidad especialidad = new Especialidad("Endocrinologia", "Se encargar analizar las hormonas de tiroides.");
//        ModelEspecialidad.agregarEspecialidad(especialidad);
        Especialidad espModificar = new Especialidad(1, "Nutricionista", "Encargado de la alimentacion saludable.");
        ModelEspecialidad.modificarEspecialidad(espModificar);
        ModelEspecialidad.listarEspecialidades();
        Especialidad espEliminar = new Especialidad(1);
        ModelEspecialidad.eliminarEspecialidad(espEliminar);

        ModelEspecialidad.listarEspecialidades();
    }
}