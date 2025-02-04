import java.util.Scanner;

/**
 * Este programa lee una cadena por teclado y averigua si los caracteres están
 * escritos en orden alfabético.
 */
public class CadenaOrdenada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe una frase: ");
        String cadena = sc.nextLine();

        // Vamos a recorrer el string del principio al final comparando
        // los caracteres adyacentes, a ver si todas las letras están ordenadas
        boolean ordenado = true;
        for (int i = 1; i < cadena.length(); i++) {
            if (cadena.charAt(i) < cadena.charAt(i - 1)) {
                ordenado = false;
            }
        }

        if (ordenado) {
            System.out.println("Los caracteres están en orden alfabético.");
        } else {
            System.out.println("Los caracteres no están en orden alfabético.");
        }
    }
}