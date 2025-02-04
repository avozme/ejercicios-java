import java.util.Scanner;

/**
 * Esta clase implementa un programa para averiguar si una cadena es un palíndromo
 * (es decir, una frase capicúa, que se lee igual de izquierda a derecha y de derecha a izquierda)
 */
public class Palindromo {
    /**
     * Método principal. Lanza el programa y ejecuta el algoritmo principal para
     * pedir un string al usuario y decir si es palíndromo o no.
     * @param args Argumentos en la línea de comandos (no se usa)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una palabra o una frase: ");
        String frase = sc.nextLine();
        String fraseLimpia = limpiar(frase);
        if (esPalindromo(fraseLimpia)) {
            System.out.println(frase + " es un palíndromo");
        } else {
            System.out.println(frase + " NO es un palindromo");
        }
    }


    /**
     * Este método elimina espacios en blanco, signos de puntuación y tildes de un String.
     * También lo convierte todo a minúsculas.
     * @param s El String que se quiere limpiar.
     * @return El String limpio, sin espacios ni tildes.
     */
    public static String limpiar(String s) {     
        // Convertimos todo a minúsculas
        s = s.toLowerCase();
        
        // Sustituios caracteres especiales
        char caracteresALimpiar[] =   { 'á', 'é', 'í', 'ó', 'ú', ',', '.', '¿', '?' };
        char caracteresSustitutos[] = { 'a', 'e', 'i', 'o', 'u', ' ', ' ', ' ', ' '};
        for (int i = 0; i < caracteresALimpiar.length; i++) {
            s = s.replace(caracteresALimpiar[i], caracteresSustitutos[i]);
        }

        // Eliminamos los espacios en blanco
        s = s.replaceAll(" ", "");
        return s;
    }


    /**
     * Este método devuelve true si un string es palíndromo.
     * Utiliza un StringBuilder para dar la vuelta a la frase con reverse()
     * @param s El String que se quiere comprobar
     * @return true si el String es un palíndromo y false si no lo es
     */
    public static boolean esPalindromo(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s1 = sb.toString();
        return s.equals(s1);
    }
}