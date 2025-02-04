/**
 * Esta clase contiene métodos para ordenar un array estático por el método de la burbuja
 * y realizar búsquedas secuencial y binaria. También tiene un main() para probarlo todo.
 */

public class OrdenarArray {
    public static void main(String[] args) {
        int n;
        int[] a = new int[50000];

        // Generamos array desordenado
        generarArray(a);
        System.out.println("ARRAY DESORDENADO");
        mostrarArray(a);

        // Ordenamos el array y mostramos el tiempo que tarda
        long tiempoInicio = System.currentTimeMillis();
        ordenarArray(a);
        long tiempoFinal = System.currentTimeMillis();
        System.out.println("ARRAY ORDENADO");
        mostrarArray(a);
        System.out.println("Tiempo de proceso de la ordenación: " + (tiempoFinal - tiempoInicio) + " ms");

        // Hacemos búsqueda secuencial
        System.out.println("Dime qué número quieres buscar:");
        int numBuscado = Integer.parseInt(System.console().readLine());
        int pos = buscarSecuencial(a, numBuscado);
        System.out.println("RESULTADO BÚSQUEDA SENCUENCIAL:");
        if (pos >= 0) {
            System.out.println("Lo he encontrado en la posición " + pos);
        }
        else {
            System.out.println("Ese número no está en el array");
        }

        // Hacemos búsqueda binaria
        pos = buscarBinaria(a, numBuscado);
        System.out.println("RESULTADO BÚSQUEDA BINARIA:");
        if (pos >= 0) {
            System.out.println("Lo he encontrado en la posición " + pos);
        }
        else {
            System.out.println("Ese número no está en el array");
        }
    }

    /**
      * Genera un array con números al azar (desordenado)
      */
    public static void generarArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*2000000);
        }
    }

    /**
      * Muestra un array por la consola de texto
      */
    public static void mostrarArray(int[] a) {
        // Mostrar el array
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
      * Ordena un array por el método de la burbuja
      */
    public static void ordenarArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j+1]) {
                    // Intercambiamos elementos
                    int aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                }
            }
            int porcentaje = ((i*100)/a.length);
            mostrarProgreso(porcentaje);
        }
    }

    /**
      * Muestra el porcentaje de progreso del recorrido por el array a
      * El parámetro i indica qué posición del array se está procesando
      */
    public static void mostrarProgreso(int porcentaje) {
        System.out.print("[");
        for (int i = 0; i < 100; i = i + 5) {
            if (porcentaje > i) System.out.print("▓");
            else System.out.print(" ");
        }
        System.out.print("]");
        // El carácter \r es el carácter de retorno de carro para volver al inicio de la línea
        System.out.print(" " + porcentaje + "%\r");
    }

    /**
      * Busca el número numBuscado en el array a mediante búsqueda SECUENCIAL.
      * Devuelve la posición donde lo ha encontrado o -1 si no lo encuentra
      */
    public static int buscarSecuencial(int[] a, int numBuscado) {
        int posicion = -1;

        for (int i = 0; i < a.length && posicion == -1; i++) {
            if (a[i] == numBuscado) {
                posicion = i;
            }
        }
        return posicion;
    }

    /**
      * Busca el número numBuscado en el array a mediante búsqueda BINARIA.
      * Devuelve la posición donde lo ha encontrado o -1 si no lo encuentra
      */
    public static int buscarBinaria(int[] a, int numBuscado) {
        int centro, izq, der, posicion;
        boolean encontrado = false;

        izq = 0;
        der = a.length;
        centro = der/2;

        while (!encontrado && izq != centro && der != centro) {
            if (a[centro] == numBuscado) {
                encontrado = true;
            }
            else {
                if (numBuscado > a[centro]) {
                    izq = centro;
                }
                else {
                    der = centro;
                }
                centro = izq + (der - izq) / 2;
            }
        }

        if (encontrado) posicion = centro;
        else posicion = -1;

        return posicion;
    }


}
