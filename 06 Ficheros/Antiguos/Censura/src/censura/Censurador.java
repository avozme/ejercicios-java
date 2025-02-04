/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package censura;

//import com.sun.xml.internal.ws.util.StringUtils;
import java.io.*;

/**
 *
 * @author alfredo
 */
public class Censurador {

    /**
     * Este método resuelve la primera versión del problema: censura caracteres
     * individuales sustituyéndolos por asteriscos.
     *
     * @param nombreArch El nombre del archivo que hay que censurar
     */
    public static void censurarCaracteres(String nombreArch) {
        
        String caracteresCensura = "a"; // Esta es la lista de caracteres que vamos a censurar. En realidad, el ejercicio pide leerla de otro archivo de texto.

        try {
            RandomAccessFile f = new RandomAccessFile(nombreArch, "rw");
            long cont = 0;
            int c;

            while ((c = f.read()) != -1) {
                cont++;
                if (c != -1) {
                    if (caracteresCensura.contains(Character.toString((char) c))) {
                        f.seek(cont-1);
                        f.write('*');
                    }
                }

            }
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /**
     * Este método resuelve la primera versión del problema: censura caracteres
     * individuales sustituyéndolos por asteriscos.
     *
     * @param nombreArch El nombre del archivo que hay que censurar
     */
    public static void censurarFrases(String nombreArch) {
        
        String[] frasesCensura = {"Tolkien", "tertulia", "agujero", "hobbit"}; 
                                // Esta es la lista de cadenas que vamos a censurar. En realidad, el ejercicio pide leerla de otro archivo de texto.

        try {
            RandomAccessFile f = new RandomAccessFile(nombreArch, "rw");
            long cont = 0;
            String linea = null;

            while ((linea = f.readLine()) != null) {
                if (linea != null) {
                    if (contiene(linea, frasesCensura)) {
                        String nuevaLinea = sustituye(linea, frasesCensura) + "\n";
                        f.seek(cont);
                        f.writeBytes(nuevaLinea);
                    }
                        
                }
                cont = cont + linea.length() + 1;

            }
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Comprueba si alguna de las frases o palabras censuradas están una línea del archivo
     * @param linea La línea leída del archivo
     * @param frasesCensura La lista de frases o palabras censuradas
     * @return True si alguna frase censurada está en la línea, false si no está ninguna
     */
    private static boolean contiene(String linea, String[] frasesCensura) {
        boolean esta = false;
        for (int i = 0; i < frasesCensura.length; i++) {
            if (linea.contains(frasesCensura[i]))
                esta = true;
        }
        
        return esta;
    }

    /**
     * Sustituye las frases o palabras censuradas por asteriscos en el string de una línea del archivo
     * @param linea La línea leída del archivo
     * @param frasesCensura La lista de frases o palabras censuradas
     * @return La línea del archivo con las palabras censuradas con asteriscos
     */
    private static String sustituye(String linea, String[] frasesCensura) {
        for (int i = 0; i < frasesCensura.length; i++) {
            if (linea.contains(frasesCensura[i])) {
                String s = "*";
                for (int j = 0; j < frasesCensura[i].length() - 1; j++) {
                    s = s + "*";
                }
                linea = linea.replace(frasesCensura[i], s);
            }
        }
        
        return linea;
    }
    
    
}
