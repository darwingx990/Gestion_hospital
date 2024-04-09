package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Esta clase se encargara de establecer y cerrar la conexion de la base de datos
public class ConfigDB {

    //Este atributo tendra el estado de la conexion
    public static Connection objConnection = null;

    //Metodo para conectar la DB
    public static Connection openConnection(){
        try {
            //Llamamos el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos las variables de conexion
            String url = "jdbc:mysql://localhost:3306/aerolinea";
            String user = "root";
            String password = "juanjosef12";

            //Establecer la conexion
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Me conecte exitosamente!!");


        }catch (ClassNotFoundException error){

            System.out.println("ERROR >> Driver no instalado " + error.getMessage());
        }catch (SQLException error){
            System.out.println("ERROR >> error al conectar con la base de datos " + error.getMessage());
        }

        return objConnection;
    }

    //Finalizar conexion
    public static void closeConnection(){
        try {

            //Si hay una conexion activa la cierra
            if (objConnection != null){
                objConnection.close();
                System.out.println("Se finalizo la conexion con exito");
            }

        }catch (SQLException e){

            System.out.println("Error: " + e.getMessage());
        }

    }
}
