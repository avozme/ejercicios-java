public class InicializarMatriz {
    public static void main(String[] args) {
        int[][] m = new int[10][10];

        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                // Inicialización simple (Ejercicio 4.14):
                // m[f][c] = -1;               
                // Inicialización más compleja (Ejercicio 4.15):
                if (f % 2 == 0) m[f][c] = 0;   // Fila par
                else m[f][c] = -1;             // Fila impar
            }
        }

        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                System.out.print(m[f][c] + " ");
            }
            System.out.println();
        }

    }
}

