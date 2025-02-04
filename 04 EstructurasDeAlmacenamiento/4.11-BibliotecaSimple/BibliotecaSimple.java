import java.util.Scanner;

public class BibliotecaSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Array para almacenar los títulos de los libros
        String[] libros = {"El señor de los anillos", "1984", "Orgullo y prejuicio", "La sombra del viento", "Cien años de soledad",
                "Matar a un ruiseñor", "La carretera", "Ventajas de viajar en tren", "Crimen y castigo", "Johnny cogió su fusil"};

        // Bucle principal de la biblioteca
        boolean continuar = true;
        while (continuar) {
            // Pedimos al usuario el título del libro
            System.out.print("¿Qué libro quieres? (escribe 'salir' para terminar): ");
            String titulo = sc.nextLine();

            // Comprobamos si el usuario quiere salir
            if (titulo.equals("salir")) {
                continuar = false;
            }
            else  {
                // Buscamos el libro en el array
                boolean encontrado = false;
                for (int i = 0; i < libros.length; i++) {
                    if (libros[i].equalsIgnoreCase(titulo)) {
                        libros[i] = "Prestado";
                        System.out.println("El libro '" + titulo + "' se ha marcado como 'prestado'.");
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Ese libro no está disponible en la biblioteca.");
                }
            }
        } // while
    }
}