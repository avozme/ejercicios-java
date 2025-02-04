import java.util.Scanner;

/**
 * Este programa lee una cadena por teclado
 * y cuenta las vocales de cada tipo que hay en la cadena.
 */
public class ContarVocales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe una frase: ");
        String cadena = sc.nextLine();

        // Inicializamos los contadores para cada vocal
        int a = 0, e = 0, i = 0, o = 0, u = 0;

        // Convertimos la cadena a minúsculas para facilitar la comparación
        cadena = cadena.toLowerCase();

        // Recorremos la cadena carácter a carácter
        for (int j = 0; j < cadena.length(); j++) {
            char caracter = cadena.charAt(j);
            switch (caracter) {
                case 'a':
                    a++;
                    break;
                case 'e':
                    e++;
                    break;
                case 'i':
                    i++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'u':
                    u++;
                    break;
            }
        }

        // Imprimimos los resultados
        System.out.println("A = " + a);
        System.out.println("E = " + e);
        System.out.println("I = " + i);
        System.out.println("O = " + o);
        System.out.println("U = " + u);
    }
}