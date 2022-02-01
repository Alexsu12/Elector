package elector;

import java.sql.*;

public class ElectorMKV {
    public static void main(String[] args) {

        Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);


            // Create a connection to the database
            String serverName = "192.168.42.128";
            String schema = "Alumnos";
            String url = "jdbc:mysql://" + serverName + "/" + schema;
            String username = "user";
            String password = "user";

            connection = DriverManager.getConnection(url, username, password);


            System.out.println("Successfully Connected to the database!\n");


        } catch (ClassNotFoundException e) {

            System.out.println("Could not find the database driver " + e.getMessage());
        } catch (SQLException e) {

            System.out.println("Could not connect to the database " + e.getMessage());
        }

        try {
            // Get a result set containing all data from test_table
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM Listado");


            // For each row of the result set ...
            while (results.next()) {
                String data = results.getString("idAlumno");
                System.out.println("Id" + ": " + data + " ");
                // Get the data from the current row using the column index - column data are in the VARCHAR format
                data = results.getString("nombre");
                System.out.println("Nombre" + ": " + data + " ");
                // Get the data from the current row using the column name - column data are in the VARCHAR format
                data = results.getString("apellido1");
                System.out.println("Apellido 1" + ": " + data + " ");

                data = results.getString("apellido2");
                if (data.equals("")){
                    System.out.println("\n");
                }else System.out.println("Apellido 2" + ": " + data + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Could not retrieve data from the database " + e.getMessage());
        }
    }
}


