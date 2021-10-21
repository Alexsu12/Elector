package sinGoogle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Lector
{
    public static void main(String[] args) {
        String line;
        String splitBy = "\n";
        ArrayList<String> listaAlumnos = new ArrayList<>();

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
        System.out.println(listaAlumnos.get(0));
    }
}
