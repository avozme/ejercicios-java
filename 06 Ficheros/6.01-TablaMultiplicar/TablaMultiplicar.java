import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TablaMultiplicar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();

        // Nombre del archivo donde se guardará la tabla de multiplicar
        String nombreArchivo = "tabla_" + numero + ".txt";

        // Creamos un objeto File que representa el archivo
        File archivo = new File(nombreArchivo);

        try {
            // Creamos un objeto FileOutputStream para escribir en el archivo
            FileOutputStream fos = new FileOutputStream(archivo);

            // Escribimos la tabla de multiplicar en el archivo
            for (int i = 1; i <= 10; i++) {
                String linea = numero + " x " + i + " = " + (numero * i) + "\n";
                fos.write(linea.getBytes());
            }

            // Cerramos el flujo de salida
            fos.close();

            System.out.println("La tabla de multiplicar se ha guardado en el archivo " + nombreArchivo);

        } catch (IOException e) {
            // Si se produce algún error durante el procesamiento del archivo, lo tratamos aquí
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
