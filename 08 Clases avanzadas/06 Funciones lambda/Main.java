
import java.util.Arrays;

class Main {
    final static int TAM = 20;

    public static void main(String[] args) {
        // Creamos un array de enteros con valores aleatorios
        int[] lista = new int[TAM];
        for (int i = 0; i < TAM; i++) {
            lista[i] = (int) (Math.random() * 100);
        }

        // Probamos las operaciones con funciones tradicionales
        System.out.println("CON FUNCIONES TRADICIONALES");
        System.out.println("Lista original: ");
        mostrarLista(lista);
        System.out.println("Suma de la lista: " + sumarLista(lista));
        System.out.println("Lista multiplicada por 2: " );
        mostrarLista(multiplicarPorFactor(lista, 2));
        System.out.println("¿La lista contiene el valor 50? " + contieneValor(lista, 50));

        // Probamos las operaciones con expresiones lambda
        System.out.println("CON FUNCIONES LAMBDA");
        int suma = Arrays.stream(lista).sum();
        System.out.println("Suma de la lista: " + suma);
        int[] listaMultiplicada = Arrays.stream(lista).map(num -> num * 2).toArray();
        System.out.println("Lista multiplicada por 2: " );
        Arrays.stream(listaMultiplicada).forEach(num -> System.out.print(num + " "));
        System.out.println();
        boolean contieneValor = Arrays.stream(lista).anyMatch(num -> num == 50);
        System.out.println("¿La lista contiene el valor 50? " + contieneValor);

    }

    public static int sumarLista(int[] lista) {
        int suma = 0;
        for (int i = 0; i < lista.length; i++) {
            suma = suma + lista[i];
        }
        return suma;
    }

    public static int[] multiplicarPorFactor(int[] lista, int factor) {
        int[] resultado = new int[TAM];
        for (int i = 0; i < lista.length; i++) {
            resultado[i] = lista[i] * factor;
        }
        return resultado;
    }

    public static boolean contieneValor(int[] lista, int valor) {
        for (int i = 0; i < lista.length; i++) {
            int num = lista[i];
            if (num == valor) {
                return true;
            }
        }
        return false;
    }

    public static void mostrarLista(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }
}
