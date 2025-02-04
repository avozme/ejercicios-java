import java.util.Scanner;

/**
 * Esta clase permite crear una sopa de letras con una palabra insertada
 * en una posición aleatoria. La sopa de letras es generada aleatoriamente
 * y la palabra es colocada de izquierda a derecha en una fila aleatoria.
 */
public class SopaDeLetrasSimple {

    /**
     * Método principal que ejecuta el programa.
     * Solicita al usuario el tamaño de la sopa de letras (N) y una palabra,
     * luego genera la sopa y muestra el resultado.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedimos al usuario el tamaño de la sopa de letras y la palabra que quiere introducir
        System.out.print("Introduce el tamaño de la sopa de letras (N): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Introduce la palabra (máximo " + n + " caracteres): ");
        String palabra = scanner.nextLine();

        // Validamos que la palabra no tenga más de N caracteres
        if (palabra.length() > n) {
            System.out.println("La palabra no puede tener más de " + n + " caracteres.");
            return;
        }

        // Creamos la sopa de letras, inicialmente llena de letras aleatorias
        char[][] sopa = new char[n][n];
        llenarSopaConLetrasAleatorias(sopa);

        // Insertamos la palabra en una fila aleatoria
        insertarPalabra(sopa, palabra);

        // Mostramos la sopa de letras
        mostrarSopa(sopa);
    }

    /**
     * Llena una matriz de caracteres (sopa) con letras aleatorias de la A a la Z, incluida la Ñ.
     *
     * @param sopa La matriz de caracteres que representa la sopa de letras.
     */
    private static void llenarSopaConLetrasAleatorias(char[][] sopa) {
        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";   // Letras válidas para crear la sopa aleatoria

        // Recorrer cada posición de la matriz y asignar una letra aleatoria
        for (int f = 0; f < sopa.length; f++) {
            for (int c = 0; c < sopa[f].length; c++) {
                int pos = (int)(Math.random() * letras.length());
                sopa[f][c] = letras.charAt(pos);   // Ponemos en (f,c) una letra cogida al azar del string letras
            }
        }
    }

    /**
     * Inserta una palabra en una posición aleatoria de la sopa de letras, de izquierda a derecha.
     *
     * @param sopa La matriz de caracteres que representa la sopa de letras.
     * @param palabra La palabra a insertar en la sopa de letras.
     */
    private static void insertarPalabra(char[][] sopa, String palabra) {

        // Elegir una fila aleatoria en la que colocar la palabra
        int filaAleatoria = (int)(Math.random() * sopa.length);

        // Elegir una columna de inicio aleatoria en la fila, de manera que la palabra quepa
        int colInicio = (int)(Math.random() * (sopa.length - palabra.length() + 1));

        // Insertar la palabra de izquierda a derecha
        for (int i = 0; i < palabra.length(); i++) {
            sopa[filaAleatoria][colInicio + i] = palabra.charAt(i);
        }
    }

    /**
     * Muestra la sopa de letras por consola. La sopa se imprime fila por fila.
     *
     * @param sopa La matriz de caracteres que representa la sopa de letras.
     */
    private static void mostrarSopa(char[][] sopa) {
        // Recorrer la matriz y mostrar cada carácter
        for (int f = 0; f < sopa.length; f++) {
            for (int c = 0; c < sopa[f].length; c++) {
                System.out.print(sopa[f][c] + " ");
            }
            System.out.println();
        }
    }
}
