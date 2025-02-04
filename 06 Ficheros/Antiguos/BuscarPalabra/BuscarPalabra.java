/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciostema6;

import java.io.*;

/**
 *
 * @author alfredo
 */
public class BuscarPalabra {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("entrada.txt");
            br = new BufferedReader(fr);
            String palabraBuscada = "pantufla";
            String linea = null;   // Leeremos líneas completas gracias al BufferedReader
            int numLinea = 1;
            
            while ((linea = br.readLine())!=null) {
                if (linea.contains(palabraBuscada)) {
                    System.out.format("Línea %d: %s\n", numLinea, linea);
                }
                numLinea++;
            }
            fr.close();
        }
        catch (Exception e) { e.printStackTrace(); }

    }
}
