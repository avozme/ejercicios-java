package ligafutbol;

import java.io.*;

/**
 * Una implementación del ejercicio de la Liga de Fútbol
 */
public class LigaFutbol {

    /**
     * Controlador principal. Elige el método de alto nivel que se ejecutará
     * según la opción de menú elegida por el usuario
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion = -1;

        do {
            // Muestra el menú de opciones
            opcion = Vista.mostrarMenu();

            // Según la opción elegida, ejecutaremos un método de alto nivell
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    mostrarListaEquipos();
                    break;
                case 2:
                    anadirEquipo();
                    break;
                case 3:
                    buscarEquipo("BUSCAR EQUIPO");
                    break;
                case 4:
                    modificarEquipo();
                    break;
                case 5:
                    borrarEquipo();
                    break;
                case 6:
                    ordenarFichero();
                    break;
                default:
                    Vista.error("Error: opción no reconocida");
            }
        } while (opcion != 0);
    }


    /**
     * Muestra el contenido del archivo de datos en forma tabular
     */
    private static void mostrarListaEquipos() {
        Vista.mostrarCabeceraTabla();
        try {
            // Abre un flujo de datos de entrada
            DataInputStream dis = new DataInputStream(new FileInputStream("liga.dat"));
            // Recorre el flujo hasta el final
            while (dis.available() > 0) {
                // Lee un equipo del flujo
                Equipo eq = new Equipo();
                eq.loadFromFile(dis);
                // Si el equipo no está marcado como borrado, lo muestra
                if (!eq.isBorrado()) {
                    Vista.mostrarEquipo(eq);
                }
            }
            dis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Añade un equipo al fichero de datos.
     */
    private static void anadirEquipo() {
        Equipo eq = Vista.entrarDatosEquipo("AÑADIR EQUIPO.\nPor favor, introduzca la información del nuevo equipo:");
        try {
            // Abre el flujo de salida y escribe el equipo en el fichero
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("liga.dat", true));
            eq.saveToFile(dos);
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca un equipo (por nombre) en el fichero de datos
     * @param msj El mensaje que se mostrará al usuario antes de la búsqueda (BUSCAR, MODIFICAR, BORRAR...)
     * @return El número de registro del equipo en el fichero de datos, o -1 si
     * no existe
     */
    public static int buscarEquipo(String msj) {
        Equipo equipo;
        String nombre;
        int posicion = 0;
        boolean encontrado = false;

        try {
            // Pide el nombre del equipo a buscar
            nombre = Vista.leerNombreEquipo(msj);
            // Abre el flujo de entrada y lo recorre hasta el final, o hasta encontrar el equipo buscado
            DataInputStream dis = new DataInputStream(new FileInputStream("liga.dat"));
            while (dis.available() > 0 && !encontrado) {
                // Llevamos la cuenta de la posición (nº de registro) en el que estamos
                posicion++;
                // Lee un equipo del fichero y lo carga en la variable eq
                Equipo eq = new Equipo();
                eq.loadFromFile(dis);
                // Si el nombre del equipo coincide con el buscado y no está borrado, ya lo hemos encontrado 
                if (eq.getNombre().contains(nombre) && !eq.isBorrado()) {
                    encontrado = true;  // Para salir del bucle
                    // Muestra los datos del equipo encontrado
                    Vista.mostrarCabeceraTabla();
                    Vista.mostrarEquipo(eq);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!encontrado) {
            Vista.error("Equipo no encontrado.");
            posicion = -1;  // En caso de no encontrar el equipo, devuelve -1
        }

        // Devuelve la posición (nº de registro) en la que encontró el equipo en el fichero, o -1 si no lo encontró
        return posicion;
    }

    /**
     * Modifica un equipo directamente en el fichero de datos
     */
    public static void modificarEquipo() {
        Equipo eq = null;
        // Primero buscamos el equipo
        int posicion = buscarEquipo("MODIFICAR EQUIPO");

        // Si el equipo no está en el fichero, posición valdrá -1
        if (posicion != -1) {
            // El equipo ha sido encontrado. La variable posición nos indica el nº de registro en el que se encuentra
            try {
                // Nos situamos al inicio del registro
                RandomAccessFile raf = new RandomAccessFile("liga.dat", "rw");
                raf.seek((posicion - 1) * 39);
                // Leemos el equipo del fichero y lo cargamos en la variable eq
                eq = new Equipo();
                eq.loadFromFile(raf);
                raf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String nombre;
            int pj, pg, pe, pp;

            // Ahora pedimos de nuevo los datos del equipo, para modificarlos
            // (esto se puede mejorar. Por ejemplo, haciendo que, si pulsamos Intro, el dato
            //  en cuestión no se modifique, y solo se cambie si tecleamos algo)
            eq = Vista.entrarDatosEquipo("MODIFICAR EQUIPO.\nPor favor, introduzca los datos modificados:");

            // Una vez cambiados los datos del equipo en la variable eq, ahora vamos
            // a volcar esa variable en el fichero de nuevo.
            try {
                RandomAccessFile raf = new RandomAccessFile("liga.dat", "rw");
                // Nos posicionamos en el lugar correcto
                raf.seek((posicion - 1) * Equipo.TAM_REGISTRO);
                // Escribimos el equipo en el fichero
                eq.saveToFile(raf);
                Vista.mensaje("Registro modificado con éxito.");
                raf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Marca un equipo como borrado en el fichero de datos
     */
    public static void borrarEquipo() {
        // Primero buscamos el equipo y obtenemos su posición (nº de registro) en el fichero
        int posicion = buscarEquipo("BORRAR EQUIPO");

        if (posicion != -1) {
            // Hemos encontrado el registro. Vamos a marcarlo como borrado.
            try {
                RandomAccessFile raf = new RandomAccessFile("liga.dat", "rw");
                Equipo eq = new Equipo();
                // Nos situamos al comienzo del registro
                raf.seek((posicion - 1) * Equipo.TAM_REGISTRO);
                // Cargamos el equipo en una variable de tipo Equipo
                eq.loadFromFile(raf);
                // Ponemos el atributo de borrado a true
                eq.setBorrado(true);
                // Volvemos a posicionarnos y sobreescribimos el registro con los nuevos valores del equipo
                raf.seek((posicion - 1) * Equipo.TAM_REGISTRO);
                eq.saveToFile(raf);
                Vista.mensaje("Registro borrado con éxito.");
                raf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Ordena el fichero de datos con el método de la burbuja
     */
    public static void ordenarFichero() {
        Vista.mensaje("Ordenando fichero...");
        try {
            RandomAccessFile raf = new RandomAccessFile("liga.dat", "rw");
            Equipo eq1 = new Equipo();
            Equipo eq2 = new Equipo();
            for (int i = 1; i <= raf.length() / Equipo.TAM_REGISTRO; i++) {
                for (int j = 2; j <= raf.length() / Equipo.TAM_REGISTRO; j++) {
                    // Nos colocamos en el registro j-1 del fichero y lo leemos
                    raf.seek((j - 2) * Equipo.TAM_REGISTRO);
                    eq1.loadFromFile(raf);
                    // Nos colocamos en el registro j del fichero y lo leemos
                    raf.seek((j - 1) * Equipo.TAM_REGISTRO);
                    eq2.loadFromFile(raf);

                    if (eq1.getPuntos() < eq2.getPuntos()) {    // Los equipos estaban desordenados. Vamos a intercambiarlos.
                        // Nos colocamos en el registro j-1 del fichero y lo escribimos con el equipo que había en j
                        raf.seek((j - 2) * Equipo.TAM_REGISTRO);
                        eq2.saveToFile(raf);
                        // Nos colocamos en el registro j del fichero y lo escribimos con el equipo que había en j-1
                        raf.seek((j - 1) * Equipo.TAM_REGISTRO);
                        eq1.saveToFile(raf);
                    }

                }
            }
            Vista.mensaje("Fichero ordenado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
