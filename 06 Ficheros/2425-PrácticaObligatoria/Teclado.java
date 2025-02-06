import java.util.Scanner;

public class Teclado {
    /**
     * Lee un String por teclado, manejando correctamente las posibles excepciones
     */
    public static String leerCadena(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        try {
            return sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error al leer el dato. Se devolverá una cadena vacía");
            return "";
        }
    }

    /**
     * Lee un int por teclado, manejando correctamente las posibles excepciones
     * @param mensaje
     * @return
     */
    public static int leerEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error al leer el dato. Se devolverá 0");
            return 0;
        }
    }

    /**
     * Lee un booleano por teclado, manejando correctamente las posibles excepciones.
     * El usuario escribirá "s" o "n" para indicar true o false, respectivamente.
     * También aceptará mayúsculas.
     */
    public static boolean leerBoolean(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        try {
            String respuesta = sc.nextLine();
            return respuesta.equalsIgnoreCase("s");
        } catch (Exception e) {
            System.out.println("Error al leer el dato. Se devolverá false");
            return false;
        }
    }
}
