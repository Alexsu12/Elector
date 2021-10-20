package sinGoogle;

import javax.swing.*;
import java.util.ArrayList;

public class Elector {
    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<>();
        String resultado;
        int respuesta = 1;
        int numero;

        lista.add("Edgardo Gabriel Allende");
        lista.add("Juan Antonio Barbero Mena");
        lista.add("Juan José Bazán Espinosa");
        lista.add("Imad El Fahssi");
        lista.add("David Fernández Fernández");
        lista.add("Domingo Flores Ortega");
        lista.add("Gabriel García Tallai");
        lista.add("Alberto Garzón Rodríguez");
        lista.add("Maximiliano Hoffmann Foyo");
        lista.add("Ismael Jerruz Jellouly");
        lista.add("Cristina del Carmen Jiménez Fernández");
        lista.add("Samuel Alejandro Jiménez Mazas");
        lista.add("Alex López Guerrero");
        lista.add("Juan Diego Marín Morales");
        lista.add("Miguel Martín Fernández");
        lista.add("Álvaro Martínez Flores");
        lista.add("Francisco José Mateos Gil");
        lista.add("Jesús Narbona Aguilar");
        lista.add("Lorena Olay Unciano");
        lista.add("Eduardo Orellana Pomares");
        lista.add("Javier Parodi Piñero");
        lista.add("Sergio David Romero Berlanga");
        lista.add("José Ignacio Salcedo Guarde");
        lista.add("Hind Samiri");
        lista.add("Victoria Sampalo García");
        lista.add("Adrián Vallejo Robles");
        lista.add("Rubén Vélez Simón");
        lista.add("Alejandro Santaella Urbano");



        while (respuesta == JOptionPane.NO_OPTION) {

            numero = (int) (Math.random() * lista.size());
            resultado = lista.get(numero);

            respuesta = JOptionPane.showConfirmDialog(null, "Le ha tocado a " + resultado
                    + "\n¿Has hecho los deberes, " + resultado + "?");

            System.out.println(lista.size());
            if (lista.size() > 1){
                lista.remove(numero);
                System.out.println(lista.size());
            }
            else {
                JOptionPane.showMessageDialog(null, "Fin de programa");
                break;
            }
        }
    }
}
