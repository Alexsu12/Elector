package elector;

import java.sql.*;
import java.util.Arrays;

public class ElectorMKV {
    public static void main(String[] args) {

        Connection connection = null;
        try {
            //Carga del JDBC Driver
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);


            //Crea una conexión con la base de datos "Alumnos"
            String serverName = "192.168.42.128";
            String schema = "Alumnos";
            String url = "jdbc:mysql://" + serverName + "/" + schema;
            String username = "user";
            String password = "user";

            connection = DriverManager.getConnection(url, username, password);


            System.out.println("!Se ha conectado a la base de datos¡\n");


        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado el driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos " + e.getMessage());
        }

        try {
            //Coge los datos de "Alumnos" y los mete en resultados
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT * FROM Listado");

            ResultSet numCol = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM Listado");
            numCol.next();
            int count = numCol.getInt("rowcount") ;
            numCol.close();

            String[] arrayAlumnos = new String[count];
            //Se guarda cada fila de la tabla "Listado"
            while (resultados.next()) {
                String nombre = resultados.getString("nombre");
                String apellido1 = resultados.getString("apellido1");
                String apellido2 = resultados.getString("apellido2");

                Arrays.fill(arrayAlumnos, nombre + " " + apellido1 + " " + apellido2);
            }


        } catch (SQLException e) {
            System.out.println("No se ha podido sacar los datos de la base de datos " + e.getMessage());
        }
    }
}


