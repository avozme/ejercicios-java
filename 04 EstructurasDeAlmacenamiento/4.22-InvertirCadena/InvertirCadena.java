import java.util.Scanner;

/**
 * Este programa invierte una cadena usando dos métodos:
 * 1) Recorrer el String carácter a carácter
 * 2) Convirtiendo en String en un StringBuffer y usando reverse()
 * Los dos método deben proporcionar el mismo resultado.
 */

public class InvertirCadena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe una frase: ");
        String frase = sc.nextLine();


        // Método 1: Invertimos el String caracter a caracter
        String fraseInvertida = "";
        for (int i = frase.length() - 1; i >= 0; i--) {
            fraseInvertida = fraseInvertida + frase.charAt(i);
        }
        System.out.println("La frase invertida es: " + fraseInvertida);

        // Método 2: Invertimos el String usando un StringBuffer
        StringBuffer fraseBuffer = new StringBuffer(frase);
        fraseBuffer.reverse();
        System.out.println("La frase invertida es: " + fraseBuffer);
    }
}