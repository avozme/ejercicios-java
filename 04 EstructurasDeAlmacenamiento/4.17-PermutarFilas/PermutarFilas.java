import java.util.Scanner;

public class PermutarFilas {

    // Definir la matriz 
    final static int ALTO = 3;   // Número de filas
    final static int ANCHO = 5;  // Número de columnas
    static int[][] matriz;

    /**
     * Programa principal. Crea la matriz, pide los valores y permuta las filas
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matriz = new int[ALTO][ANCHO];
        
        // Pedir al usuario que introduzca los valores
        System.out.println("Introduce los valores para la matriz:");
        for (int f = 0; f < ALTO; f++) {
            for (int c = 0; c < ANCHO; c++) {
                // Control de excepciones para garantizar que el usuario teclea un número entero
                boolean error = true;
                while (error) {
                    try {
                        System.out.print("Introduce el valor para la posición (" + f + "," + c + "): ");
                        matriz[f][c] = scanner.nextInt(); 
                        error = false; // Si no hay excepción, salir del bucle
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
                        scanner.nextLine();  // Limpiar buffer del teclado
                    }
                }
            }
        }

        // Mostrar la matriz original
        System.out.println("Matriz original:");
        imprimirMatriz();

        // Permutar el contenido de la fila 0 con la fila ALTO-1
        int[] temp = matriz[0];
        matriz[0] = matriz[ALTO-1];
        matriz[ALTO-1] = temp;

        // Mostrar la matriz después de la permutación
        System.out.println("Matriz después de permutar filas:");
        imprimirMatriz();
    }

    /**
     *  Método para imprimir la matriz
     */
    public static void imprimirMatriz() {
        for (int f = 0; f < ALTO; f++) {
            for (int c = 0; c < ANCHO; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }
    }
}