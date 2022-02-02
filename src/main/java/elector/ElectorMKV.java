package elector;

import org.apache.commons.lang3.ArrayUtils;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

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

            System.out.println("!Se ha conectado a la base de datos¡");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado el driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos " + e.getMessage());
        }

        try {
            //Coge la cuenta de filas en la tabla
            assert connection != null;
            Statement statement1 = connection.createStatement();
            ResultSet numCol = statement1.executeQuery("SELECT COUNT(*) AS rowcount FROM Listado");
            numCol.next();
            int count = numCol.getInt("rowcount");
            numCol.close();

            //Coge los datos de "Alumnos" y los mete en resultados
            Statement statement2 = connection.createStatement();
            ResultSet resultados = statement2.executeQuery("SELECT * FROM Listado");

            //Se guarda cada fila de la tabla "Listado"
            String[] listaAlumnos = new String[count];
            for (int i = 0; i < listaAlumnos.length; i++) {
                resultados.next();
                listaAlumnos[i] = resultados.getString("nombre") + " " + resultados.getString("apellido1") +
                        " " + resultados.getString("apellido2");
            }

            //Arraylists
            ArrayList<String> listaNegativos = new ArrayList<>();
            ArrayList<String> listaPositivos = new ArrayList<>();

            //Variables
            String resultado;
            int respuesta = 1;
            int numero;

            //Bucle
            while (respuesta == JOptionPane.NO_OPTION || respuesta == JOptionPane.YES_OPTION) {

                numero = (int) (Math.random() * listaAlumnos.length);
                resultado = listaAlumnos[numero];

                respuesta = JOptionPane.showConfirmDialog(null, "Le ha tocado a " + resultado +
                        "\n¿Has hecho los deberes, " + resultado + "?\n\nPulsa cancelar para finalizar");

                //Condiciones del bucle
                if (respuesta == JOptionPane.NO_OPTION) listaNegativos.add(resultado);
                else if (respuesta == JOptionPane.YES_OPTION) listaPositivos.add(resultado);

                listaAlumnos = ArrayUtils.remove(listaAlumnos, numero);
                if (ArrayUtils.isEmpty(listaAlumnos)) break;
            }

            //Condiciones resultado del bucle
            if (listaNegativos.isEmpty() && listaPositivos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fin de programa");
            } else if (listaNegativos.isEmpty()) {
                StringBuilder datosArray = new StringBuilder();
                for (String elemento : listaPositivos) {
                    datosArray.append(elemento).append("\n");
                }
                JOptionPane.showMessageDialog(null, datosArray + "\nHan hecho los deberes");
                JOptionPane.showMessageDialog(null, "Fin de programa");
            } else if (listaPositivos.isEmpty()) {
                StringBuilder datosArray = new StringBuilder();
                for (String elemento : listaNegativos) {
                    datosArray.append(elemento).append("\n");
                }
                JOptionPane.showMessageDialog(null, datosArray + "\nNo han hecho los deberes");
                JOptionPane.showMessageDialog(null, "Fin de programa");
            } else {
                StringBuilder datosArray1 = new StringBuilder();
                for (String elemento : listaPositivos) {
                    datosArray1.append(elemento).append("\n");
                }
                StringBuilder datosArray2 = new StringBuilder();
                for (String elemento : listaNegativos) {
                    datosArray2.append(elemento).append("\n");
                }
                UIManager.put("OptionPane.okButtonText", "Siguiente");
                JOptionPane.showMessageDialog(null, datosArray1 + "\nHan hecho los deberes.");
                UIManager.put("OptionPane.okButtonText", "Fin");
                JOptionPane.showMessageDialog(null, datosArray2 + "\nNo han hecho los deberes.");
            }

        } catch (SQLException e) {
            System.out.println("No se ha podido sacar los datos de la base de datos " + e.getMessage());
        }
    }
}


