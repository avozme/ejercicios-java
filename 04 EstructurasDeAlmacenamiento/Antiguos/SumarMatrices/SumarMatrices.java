import java.util.Scanner;

public class SumarMatrices {

    // Definir la matriz de 3x5
    final static int ALTO = 5;    // Número de filas de las matrices
    final static int ANCHO = 10;  // Número de columnas de las matrices

    /**
     * Programa principal. Crea la matriz, pide los valores y permuta las filas
     */
    public static void main(String[] args) {
        // Creamos las matrices
        int[][] m1, m2, msuma; // Matriz 1, matriz 2 y matriz con el resultado de la suma
        m1 = new int[ALTO][ANCHO];
        m2 = new int[ALTO][ANCHO];
        msuma = new int[ALTO][ANCHO];

        // Rellenamos m1 y m2 con valores aleatorios
        rellenarMatriz(m1);
        rellenarMatriz(m2);

        // Mostramos las matrices
        System.out.println("MATRIZ 1:");
        mostrarMatriz(m1);
        System.out.println("MATRIZ 2:");
        mostrarMatriz(m2);

        // Hacemos la suma
        sumarMatrices(m1, m2, msuma);

        // Mostamos la matriz suma
        System.out.println("MATRIZ SUMA:");
        mostrarMatriz(msuma);
    }


    /**
     * Método para rellenar una matriz con números aleatorios entre 0 y 99
     */
    public static void rellenarMatriz(int[][] m) {        
        // Pedir al usuario que introduzca los valores
        for (int f = 0; f < ALTO; f++) {
            for (int c = 0; c < ANCHO; c++) {
                m[f][c] = (int)(Math.random()*100);
            }
        }
    }

    /**
     *  Método para imprimir una matriz en la consola de texto
     */
    public static void mostrarMatriz(int[][] m) {
        for (int f = 0; f < ALTO; f++) {
            for (int c = 0; c < ANCHO; c++) {
                System.out.printf("%4d", m[f][c]);
            }
            System.out.println();
        }
    }

    /**
     * Método para sumar dos matrices (m1 y m2) y guardar el resultado en msuma
     */
    public static void sumarMatrices(int[][] m1, int[][] m2, int[][] msuma) {
        for (int f = 0; f < ALTO; f++) {
            for (int c = 0; c < ANCHO; c++) {
                msuma[f][c] = m1[f][c] + m2[f][c];
            }
        }
    }
}