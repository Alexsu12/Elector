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
        ArrayList<String> listaPresentes = new ArrayList<>();
        ArrayList<String> listaFaltas = new ArrayList<>();
        ArrayList<String> listaNegativos = new ArrayList<>();
        ArrayList<String> listaPositivos = new ArrayList<>();

        //Variables
        String resultado;
        int respuesta = 1;
        int respuestaLista = 1;
        int numero = 0;
        String line;
        String splitBy = "\n";

        //Lector de CSV
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

        //Paso de lista
        int pasarLista = JOptionPane.showConfirmDialog(null, "¿Desea pasar lista?");
        if(pasarLista == JOptionPane.YES_OPTION){
            while (respuestaLista == JOptionPane.NO_OPTION || respuestaLista == JOptionPane.YES_OPTION) {

                resultado = listaAlumnos.get(numero);
                resultado = resultado.substring(1, resultado.length() - 1);
                numero = numero + 1;
                UIManager.put("OptionPane.yesButtonText", "Presente");
                UIManager.put("OptionPane.noButtonText", "Falta");
                respuestaLista = JOptionPane.showConfirmDialog(null, resultado);

                //Condiciones del bucle
                if (respuestaLista == JOptionPane.NO_OPTION) {
                    listaFaltas.add(resultado);
                }
                else if (respuestaLista == JOptionPane.YES_OPTION) {
                    listaPresentes.add(resultado);
                }
                listaAlumnos.remove(numero);
                if (listaAlumnos.isEmpty()) break;
            }

            if (listaFaltas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nadie ha faltado");
            }
            else {
                StringBuilder datosArray = new StringBuilder();
                for (String elemento : listaFaltas) {
                    datosArray.append(elemento).append("\n");
                }
                JOptionPane.showMessageDialog(null, datosArray + "\nHan faltado");
            }

            UIManager.put("OptionPane.yesButtonText", "Si");
            UIManager.put("OptionPane.noButtonText", "No");

            while (respuesta == JOptionPane.NO_OPTION || respuesta == JOptionPane.YES_OPTION) {

                numero = (int) (Math.random() * listaPresentes.size());
                resultado = listaPresentes.get(numero);

                respuesta = JOptionPane.showConfirmDialog(null, "Le ha tocado a " + resultado
                        + "\n¿Has hecho los deberes, " + resultado + "?");

                //Condiciones del bucle
                if (respuesta == JOptionPane.NO_OPTION) listaNegativos.add(resultado);
                else if (respuesta == JOptionPane.YES_OPTION) listaPositivos.add(resultado);

                listaPresentes.remove(numero);
                if (listaPresentes.isEmpty()) break;
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

        else if (pasarLista == JOptionPane.NO_OPTION){
            //Bucle de tarea
            while (respuesta == JOptionPane.NO_OPTION || respuesta == JOptionPane.YES_OPTION) {

                numero = (int) (Math.random() * listaAlumnos.size());
                resultado = listaAlumnos.get(numero);
                resultado = resultado.substring(1, resultado.length() - 1);

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
}

