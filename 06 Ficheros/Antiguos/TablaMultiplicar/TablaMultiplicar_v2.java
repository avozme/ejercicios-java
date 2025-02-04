import java.io.*;

public class TablaMultiplicar {

    public static void main(String[] args) {
       hazTabla(3);	// Calcula la tabla de multiplicar del número pasado como parámetro
       leeArchivo();	// Lee el archivo de texto "tabla.txt" y lo muestra por la pantalla
    }

    public static void hazTabla(int n) {
        try {
            FileWriter f = new FileWriter("tabla.txt");
            for (int i = 1; i <= 10; i++) {
                f.write(n + " x " + i + " = " + n*i + "\n");
            }
            f.close();
        }
        catch (IOException e) { e.printStackTrace(); }
            
    }
    
    public static void leeArchivo() {
        try {
            FileReader f = new FileReader("tabla.txt");
            int c;
            c = f.read();
            //while ( (c = f.read()) != -1)	// Forma resumida habitual del while para recorrer ficheros
            while (c != -1) {
                if (c != -1) System.out.print((char)c);
		c = f.read();
            }
            f.close();
        }
        catch (IOException e) { e.printStackTrace(); }
    }
}
