/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligafutbol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Esta clase es la implementación de la vista (interfaz de usuario) de la liga de fútbol.
 * Se ha separado del resto del sistema para poder cambiar el interfaz sin afectar al resto.
 * La implementación actual utiliza la consola de texto como medio de interacción con el usuario.
 */
public class Vista {

    /**
     * Lee por teclado los datos de un equipo.
     * @param msj El mensaje informativo que se ofrece al usuario antes de pedirle los datos del equipo
     * @return Un objeto Equipo con los datos introducidos por el usuario.
     */
    public static Equipo entrarDatosEquipo(String msj) {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        int pj, pg, pe, pp;
        Equipo equipo = null;
        System.out.println(msj);

        try {
            // Pide los datos del equipo por teclado
            System.out.print("   Nombre del equipo > ");
            nombre = buff.readLine();
            System.out.print("   Partidos jugados > ");
            pj = Integer.parseInt(buff.readLine());
            System.out.print("   Partidos ganados > ");
            pg = Integer.parseInt(buff.readLine());
            System.out.print("   Partidos perdidos > ");
            pp = Integer.parseInt(buff.readLine());
            pe = pj - pg - pp;  // Los partidos empatados no hace falta preguntarlos porque se pueden calcular

            // Crea un objeto Equipo con los datos introducidos por teclado
            equipo = new Equipo(nombre, pj, pg, pe, pp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return equipo;
    }

    /**
     * Muestra el menú de opciones y lee la opción elegida por el usuario
     *
     * @return La opción elegida, o -1 si hay un error de lectura de teclado
     */
    public static int mostrarMenu() {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int opcion = -1;

        System.out.println("\n\nLIGA DE FÚTBOL - MENÚ PRINCIPAL");
        System.out.println("  1. Mostrar lista.");
        System.out.println("  2. Añadir equipo.");
        System.out.println("  3. Buscar equipo.");
        System.out.println("  4. Modificar equipo.");
        System.out.println("  5. Borrar equipo.");
        System.out.println("  6. Ordenar datos.");
        System.out.println();
        System.out.println("  0. Salir.\n");
        System.out.print("Elija una opción > ");

        try {
            opcion = Integer.parseInt(buff.readLine());
        } catch (Exception e) {
            e.printStackTrace();
            opcion = -1;
        }
        return opcion;

    }

    /**
     * Muestra la cabecera de la tabla de la lista de equipos.
     */
    public static void mostrarCabeceraTabla() {
        System.out.println("\nLISTA DE EQUIPOS");
        System.out.println("Nombre               Jug Gan Emp Per Pun");
        System.out.println("----------------------------------------");
    }

    /**
     * Muestra una de las filas de la tabla de la lista de equipos
     * @param eq El equipo cuyos datos deben mostrarse en esta fila
     */
    public static void mostrarEquipo(Equipo eq) {
        System.out.format("%20s %3d %3d %3d %3d %3d\n", eq.getNombre(), eq.getJugados(), eq.getGanados(), eq.getEmpatados(), eq.getPerdidos(), eq.getGanados() * 3 + eq.getEmpatados());
    }

    /**
     * Lee por teclado el nombre de un equipo.
     * (para la operación de búsqueda, modificación, borrado, etc)
     * @param msj El mensaje informativo que se ofrece al usuario antes de pedirle los datos del equipo.
     * @return 
     */
    public static String leerNombreEquipo(String msj) {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String nombre = null;

        System.out.println(msj + "\nPor favor, introduzca el nombre del equipo:");

        try {
            // Pide el nombre del equipo a buscar
            System.out.print("   Nombre del equipo > ");
            nombre = buff.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombre;
    }

    /**
     * Muestra un mensaje informativo en la consola.
     * La implementación es igual que la del mensaje de error, pero se separan para poder
     * hacerlos diferentes con facilidad sin afectar al resto del programa.
     * @param msj El texto del mensaje.
     */
    public static void mensaje(String msj) {
        System.out.println(msj);
    }

    /**
     * Muestra un mensaje de error en la consola.
     * La implementación es igual que la del mensaje informativo, pero se separan para poder
     * hacerlos diferentes con facilidad sin afectar al resto del programa.
     * @param msj El texto del mensaje.
     */
    public static void error(String msj) {
        System.out.println(msj);
    }
}
