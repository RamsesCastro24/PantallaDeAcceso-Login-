package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {

    public String[] leerUsuarios() {
        ArrayList<String> lista = new ArrayList();
        try {
            Scanner lector
                    = new Scanner(new FileInputStream("src/Registro/Alumnos.txt"));
            while (lector.hasNext()) {
                lista.add(lector.nextLine());
            }
        } catch (FileNotFoundException e) {
        }
        return lista.toArray(new String[lista.size()]);
    }

    public void escribirUsuarios(String[] coleccion) {
        try {
            File f = new File("src/Registro/Alumnos.txt");
            FileWriter fw = new FileWriter(f);

            for (String x : coleccion) {
                fw.write(x + "\n");
            }
            fw.close();
        } catch (IOException e) {
        }
    }

}
