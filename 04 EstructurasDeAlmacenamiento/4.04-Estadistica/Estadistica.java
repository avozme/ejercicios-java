import java.util.Scanner;

class Estadistica {

    public static void main(String[] args)  {
        final int TAM = 10;             // El tamaño del array
        int numeros[] = new int[TAM];   // El array con los números

        // Leemos los números por teclado
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < TAM; i++) {
            System.out.print("Introduce el número " + i + " de " + TAM + ": ");
            numeros[i] = sc.nextInt();
        }

        // Calculamos la media
        int suma = 0;
        for (int i = 0; i < TAM; i++) {
            suma = suma + numeros[i];
        }
        double media = (double)suma / TAM;
        System.out.println("Media: " + media);

        // Mostramos los que están por debajo de la media
        System.out.println("Valores por debajo de la media:");
        for (int i = 0; i < TAM; i++) {
            if (numeros[i] < media) {
                System.out.print(numeros[i] + " ");
            }
        }
        System.out.println();

        // Mostramos los que están por encima de la media
        System.out.println("Valores por encima de la media:");
        for (int i = 0; i < TAM; i++) {
            if (numeros[i] > media) {
                System.out.print(numeros[i] + " ");
            }
        }
        System.out.println();

    }
}