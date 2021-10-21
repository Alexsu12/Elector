package sinGoogle;

import javax.swing.*;
import java.util.ArrayList;

public class ElectorMKII {
    public static void main(String[] args) {

        //Arraylists
        ArrayList<String> listaAlumnos = new ArrayList<>();
        ArrayList<String> listaNegativos = new ArrayList<>();
        ArrayList<String> listaPositivos = new ArrayList<>();

        //Variables
        String resultado;
        int respuesta = 1;
        int numero;

        //Lista de alumnos
        listaAlumnos.add("Edgardo Gabriel Allende");
        listaAlumnos.add("Juan Antonio Barbero Mena");
        listaAlumnos.add("Juan José Bazán Espinosa");
        listaAlumnos.add("Imad El Fahssi");
        listaAlumnos.add("David Fernández Fernández");
        listaAlumnos.add("Domingo Flores Ortega");
        listaAlumnos.add("Gabriel García Tallai");
        listaAlumnos.add("Alberto Garzón Rodríguez");
        listaAlumnos.add("Maximiliano Hoffmann Foyo");
        listaAlumnos.add("Ismael Jerruz Jellouly");
        listaAlumnos.add("Cristina del Carmen Jiménez Fernández");
        listaAlumnos.add("Samuel Alejandro Jiménez Mazas");
        listaAlumnos.add("Alex López Guerrero");
        listaAlumnos.add("Juan Diego Marín Morales");
        listaAlumnos.add("Miguel Martín Fernández");
        listaAlumnos.add("Álvaro Martínez Flores");
        listaAlumnos.add("Francisco José Mateos Gil");
        listaAlumnos.add("Jesús Narbona Aguilar");
        listaAlumnos.add("Lorena Olay Unciano");
        listaAlumnos.add("Eduardo Orellana Pomares");
        listaAlumnos.add("Javier Parodi Piñero");
        listaAlumnos.add("Sergio David Romero Berlanga");
        listaAlumnos.add("José Ignacio Salcedo Guarde");
        listaAlumnos.add("Hind Samiri");
        listaAlumnos.add("Victoria Sampalo García");
        listaAlumnos.add("Adrián Vallejo Robles");
        listaAlumnos.add("Rubén Vélez Simón");
        listaAlumnos.add("Alejandro Santaella Urbano");

        //Bucle
        while (respuesta == JOptionPane.NO_OPTION || respuesta == JOptionPane.YES_OPTION) {

            numero = (int) (Math.random() * listaAlumnos.size());
            resultado = listaAlumnos.get(numero);

            respuesta = JOptionPane.showConfirmDialog(null, "Le ha tocado a " + resultado
                    + "\n¿Has hecho los deberes, " + resultado + "?");

            //Condiciones del bucle
            if (respuesta == JOptionPane.NO_OPTION) listaNegativos.add(resultado);
            else if (respuesta == JOptionPane.YES_OPTION) listaPositivos.add(resultado);

            listaAlumnos.remove(numero);
            if (listaAlumnos.isEmpty()) break;
        }

        //Condiciones resultado del bucle
        if (listaNegativos.isEmpty() && listaPositivos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fin de programa");
        }
        else if (listaNegativos.isEmpty()) {
            StringBuilder datosArray = new StringBuilder();
            for (String elemento : listaPositivos) {
                datosArray.append(elemento).append("\n");
            }
            JOptionPane.showMessageDialog(null, datosArray + "\nHan hecho los deberes");
        }
        else if (listaPositivos.isEmpty()) {
            StringBuilder datosArray = new StringBuilder();
            for (String elemento : listaNegativos) {
                datosArray.append(elemento).append("\n");
            }
            JOptionPane.showMessageDialog(null, datosArray + "\nNo han hecho los deberes");
        }
        else {
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
    }
}

