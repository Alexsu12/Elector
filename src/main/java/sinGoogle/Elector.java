package sinGoogle;

import javax.swing.*;
import java.util.ArrayList;

public class Elector {
    public static void main(String[] args) {

        ArrayList<String> listaAlumnos = new ArrayList<>();
        ArrayList<String> listaNegativos = new ArrayList<>();
        String resultado;
        int respuesta = 1;
        int numero;

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

        while (respuesta == JOptionPane.NO_OPTION) {

            numero = (int) (Math.random() * listaAlumnos.size());
            resultado = listaAlumnos.get(numero);

            respuesta = JOptionPane.showConfirmDialog(null, "Le ha tocado a " + resultado
                    + "\n¿Has hecho los deberes, " + resultado + "?");

            if (listaAlumnos.size() > 1){
                listaNegativos.add(resultado);
                listaAlumnos.remove(numero);
            }
            else {
                JOptionPane.showMessageDialog(null, "Fin de programa");
                break;
            }
        }
        JOptionPane.showMessageDialog(null, listaNegativos + "\nNo han hecho los deberes");
    }
}
