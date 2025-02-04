import java.util.Scanner;

/**
 * Este programa lee una cadena por teclado y cuenta el número de veces que aparecen ciertas letras.
 * Es una solución más general al programa que cuenta vocales, porque este programa permite
 * contar un conjunto de letras cualquiera, no solo vocales. Solo hay que cambiar el valor
 * de la variable letrasABuscar.
 */
public class ContarVocalesVersion2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String letrasABuscar = "aeiou";  // La lista de letras cuyas apariciones queremos contar
        int[] contadores = new int[letrasABuscar.length()];  // Array de contadores, para contar cada letra

        // Inicializamos los contadores
        for (int i = 0; i < contadores.length; i++)
            contadores[i] = 0;

        System.out.print("Escribe una frase: ");
        String cadena = sc.nextLine();

        // Convertimos la cadena a minúsculas para facilitar la comparación
        cadena = cadena.toLowerCase();

        // Recorremos la cadena carácter a carácter
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);

            // Vamos a ver si ese carácter está en la lista de letras a buscar
            boolean encontrado = false;
            int pos = 0;
            for (int j = 0; j < letrasABuscar.length(); j++) {
                if (letrasABuscar.charAt(j) == caracter) {
                    encontrado = true;
                    pos = j;
                }

            }
            // Lo hemos encontrado. Vamos a incrementar el contador de esa letra
            if (encontrado) {
                contadores[pos]++;
            }

        }

        // Imprimimos los resultados
        for (int i = 0; i < letrasABuscar.length(); i++) {
            System.out.println("Contador de la letra " + letrasABuscar.charAt(i) + ": " + contadores[i]);
        }
    }
}
