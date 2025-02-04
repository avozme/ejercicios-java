import java.util.Scanner;

public class SumarLineas {
    public static void main(String[] args) {
        final int TAM = 3;  // Tamaño de la matriz
        int[][] matriz = new int[TAM][TAM];
        Scanner sc = new Scanner(System.in);

        // Pedir los valores de la martiz (con manejador de excepciones incluido)
        System.out.println("Introduce los valores de la matriz:");
        for (int f = 0; f < TAM; f++) {
            for (int c = 0; c < TAM; c++) {
                boolean error = true;
                while (error) {
                    try {
                        System.out.print("Dime el valor para la posición [" + f + "," + c + "]: ");
                        matriz[f][c] = sc.nextInt();
                        error = false;  // La entrada ha sido correcta
                    } catch (Exception e) {
                        System.out.println("Error: introduce solo números, por favor.");
                        sc.nextLine(); // Limpiamos el buffer del teclado
                    }
                }
            }
        }


        // Mostrar la matriz
        System.out.println("Contenido de la matriz:");
        for (int f = 0; f < TAM; f++) {
            for (int c = 0; c < TAM; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }

        // Calcular y mostrar la suma de cada fila
        System.out.println("Suma de cada fila:");
        for (int f = 0; f < TAM; f++) {
            int sumaFila = 0;
            for (int c = 0; c < TAM; c++) {
                sumaFila = sumaFila + matriz[f][c];
            }
            System.out.println("Fila " + f + ": " + sumaFila);
        }

        // Calcular y mostrar la suma de cada columna
        System.out.println("\nSuma de cada columna:");
        for (int c = 0; c < TAM; c++) {
            int sumaColumna = 0;
            for (int f = 0; f < TAM; f++) {
                sumaColumna = sumaColumna + matriz[f][c];
            }
            System.out.println("Columna " + c + ": " + sumaColumna);
        }
    }
}