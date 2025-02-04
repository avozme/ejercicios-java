// Ejercicio 17
// Una clase para calcular el máximo, el mínimo y la media de un conjunto de 10 números
// Versión 1: SIN ARRAYS

public class EstadisticaBasica {

    public static void main(String[] args) {
        int n, i;
        int suma = 0;                   // Acumulador para calcular la suma de los 10 números
        int maximo = Integer.MIN_VALUE; // Aquí guardaremos el número más grande encontrado hasta el momento
        int minimo = Integer.MAX_VALUE; // Aquí guardaremos el número más pequeño encontrado hasta el momento
        double media;                   // Aquí guardaremos la media de los 10 números

        System.out.println("Por favor, introduzca 10 números enteros positivos: ");
        for (i = 1; i <= 10; i++) {
            System.out.print("Número " + i + ": ");
            n = Integer.parseInt(System.console().readLine());
            if (n > maximo) {  // Miramos a ver si n es mayor que el máximo
                maximo = n;
            }
            if (n < minimo) {  // Miramos a ver si n es menor que el mínimo
                minimo = n;
            }
            suma = suma + n;   // Acumulamos n a la suma total
        }

        // Mostramos los resultados. Atención: con esta solución NO es posible calcular la mediana ni la desviación típica
        System.out.println("Máximo:     " + maximo);	
        System.out.println("Mínimo:     " + minimo);	
        media = (double)suma/10;
        System.out.println("Media:      " + media);	
    }
}
