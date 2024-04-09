import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String option;
        String option1;
        String option2;
        String option3;
        String option4;

        do {
            option = JOptionPane.showInputDialog("""
                    MENU
                    
                    1. Menu de Aviones
                    2. Menu de Vuelos
                    3. Menu de Pasajeros
                    4. Menu de Reservaciones
                    5. Exit
                    
                    Escoge una opcion:
                    """);

            switch (option){
                case "1":
                    do {
                        option1 = JOptionPane.showInputDialog("""
                                MENU DE AVIONES
                                
                                1. Añadir Avión
                                2. Listar Aviones Existentes
                                3. Eliminar Avión
                                4. Exit
                                
                                Escoge una opcion:
                                """);
                        switch (option1){
                            case "1":
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                        }

                    }while (!option1.equals("4"));
                    break;

                case "2":
                    do {
                        option2 = JOptionPane.showInputDialog("""
                                MENU DE VUELOS
                                
                                1. Añadir Vuelo
                                2. Listar Vuelos Existentes
                                3. Actualizar un Vuelo
                                4. Eliminar Vuelo
                                5. Buscar Vuelo por Destino
                                6. Exit
                                
                                Escoge una opcion:
                                """);
                        switch (option2){
                            case "1":
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                            case "5":
                                break;
                        }

                    }while (!option2.equals("6"));
                    break;

                case "3":
                    do {
                        option3 = JOptionPane.showInputDialog("""
                                MENU DE PASAJEROS
                                
                                1. Añadir Pasajero
                                2. Buscar Pasajero por Nombre
                                3. Actualizar Datos de un Pasajero
                                4. Eliminar un Pasajero
                                5. Exit
                                
                                Escoge una opcion:
                                """);
                        switch (option3){
                            case "1":
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                        }

                    }while (!option3.equals("5"));
                    break;

                case "4":
                    do {
                        option4 = JOptionPane.showInputDialog("""
                                MENU DE RESERVACIONES
                                
                                1. Añadir Reservación
                                2. Listar Todas las Reservaciones de un Vuelo
                                3. Actualizar Asiento de una Reserva
                                4. Eliminar Reservación
                                5. Exit
                                
                                Escoge una opcion:
                                """);
                        switch (option4){
                            case "1":
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                        }

                    }while (!option4.equals("5"));
                    break;
            }
        }while (!option.equals("5"));
    }
}