import java.util.Scanner;

public class GeneradorLaberintos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos al usuario el tamaño del laberinto
        System.out.print("Dime la ALTURA del laberinto (nº de filas): ");
        int filas = sc.nextInt();
        System.out.print("Dime la ANCHURA del laberinto (nº de columnas): ");
        int cols = sc.nextInt();
        
        // Creamos el laberinto y llenarlo de paredes
        Laberinto lab = new Laberinto(filas, cols);

        // Generamos el laberinto aleatoriamente
        lab.generarLaberinto();

        // Mostramos el laberinto por pantalla
        lab.mostrarLaberinto();
    }
}