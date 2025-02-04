import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Desencriptar {

    /**
     * Este programa desencripta el texto de un archivo de texto cifrado con el método césar
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Pedimos al usuario los datos (fichero encriptado y clave)
        System.out.print("Introduce el nombre del archivo cifrado: ");
        String archivoEntrada = sc.nextLine();
        
        System.out.print("Introduce la clave de encriptación utilizada (un número entero): ");
        int clave = sc.nextInt();
        
        try {
            FileInputStream fis = new FileInputStream(archivoEntrada);
            
            // Leemos el archivo encriptado byte a byte
            int caracter;
            while ((caracter = fis.read()) != -1) {
                char c = (char) caracter;
                // Desencriptamos el carácter y lo mostramos por la consola
                char cDesencriptado = desencriptarCaracter(c, clave);
                System.out.print(cDesencriptado);
            }
            fis.close();
            System.out.println("\nEl archivo ha sido desencriptado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Este método desencripta un carácter mediante el método césar
     * @param c El carácter encriptado que se quiere descifrar
     * @param clave La clave de encriptación (cantidad de desplazamientos)
     * @return El carácter desencriptado
     */
    private static char desencriptarCaracter(char c, int clave) {
        String alfabeto = "abcdefghijklmnopqrstuvwxyzáéíóúüñ";
        String alfabetoMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÜÑ";
        char caracterDesencriptado = c;

        clave = clave % alfabeto.length();

        // Si la letra es un carácter en minúsculas...
        if (Character.isLowerCase(c)) {
            int pos = alfabeto.indexOf(c);
            if (pos != -1) {
                pos = pos - clave;
                if (pos < 0) pos = pos + alfabeto.length();
                caracterDesencriptado = alfabeto.charAt(pos);
            }
        // Si la letra es un carácter en mayúsculas...
        } else if (Character.isUpperCase(c)) {
            int pos = alfabetoMayus.indexOf(c);
            if (pos != -1) {
                pos = pos - clave;
                if (pos < 0) pos = pos + alfabeto.length();
                caracterDesencriptado = alfabetoMayus.charAt(pos);
            }
        }
        
        // Si no es una letra, devolver el mismo carácter sin modificarlo
        return caracterDesencriptado;
    }
}
