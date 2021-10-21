package sinGoogle;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ElectorMKIII {
    public static void main(String[] args) {

        //Arraylists
        ArrayList<String> listaAlumnos = new ArrayList<>();
        ArrayList<String> listaNegativos = new ArrayList<>();
        ArrayList<String> listaPositivos = new ArrayList<>();

        //Variables
        String resultado;
        int respuesta = 1;
        int numero;
        String line;
        String splitBy = "\n";

        try {
            BufferedReader br = new BufferedReader(new FileReader("/media/alejandro/ALEX/Proyectos Java/Elector/src/main/java/sinGoogle/listado.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] prelistado = line.split(splitBy);
                listaAlumnos.add(Arrays.toString(prelistado));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

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

