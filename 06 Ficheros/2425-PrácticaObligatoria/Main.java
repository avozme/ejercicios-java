import java.io.File;
import java.util.ArrayList;

/**
 * Clase principal de la aplicación. 
 * Permite añadir, listar, buscar y borrar dispositivos, además de cambiar su estado y modificarlos.
 * Hace uso de las clases Dispositivo, Ordenador e Impresora sin necesidad de acceder nunca directamente a los archivos.
 */
public class Main {
    private static ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    /**
     * Método principal de la aplicación. Carga los datos en memoria y cede el control al menú principal.
     * @param args Argumentos de la línea de comandos. No se utilizan.
     */
    public static void main(String[] args) {
        cargarDatos();
        mainMenu();
    }

    /**
     * Menú principal de la aplicación.
     * Muestra las opciones de añadir dispositivo, listar dispositivos, buscar un dispositivo y borrar dispositivos, además de salir
     */
    public static void mainMenu() {
        int opcion;
        do {
            System.out.println("-------------------------\nGESTIÓN DE DISPOSITIVOS\n-------------------------");
            System.out.println("1. Añadir dispositivo");
            System.out.println("2. Listar dispositivos");
            System.out.println("3. Buscar dispositivo");
            System.out.println("4. Borrar dispositivo");
            System.out.println("5. Cambiar estado de dispositivo");
            System.out.println("6. Modificar dispositivo");
            System.out.println("7. Resetear datos");
            System.out.println("0. Salir");
            System.out.println("-------------------------");
            opcion = Teclado.leerEntero("Introduce una opción: ");
            System.out.println("-------------------------");
            switch (opcion) {
                case 1: addDevice(); break;
                case 2: listDevices(); break;
                case 3: searchDevice(); break;
                case 4: deleteDevice(); break;
                case 5: changeDeviceStatus(); break;
                case 6: modifyDevice(); break;
                case 7: resetData(); break;
                case 0: break;
                default: System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }


    /**
     * Carga los datos de los dispositivos desde los ficheros al array de Dispositivos
     */
    public static void cargarDatos() {
        int id = 0;
        boolean terminar = false;
        do {
            Dispositivo d = new Dispositivo(id);
            if (d.load() == 0) {
                // El dispositivo existe y se ha cargado correctamente
                switch(d.getTipo()) {
                    case 1: // Ordenador
                        Ordenador o = new Ordenador(id);
                        o.load();
                        dispositivos.add(o);
                        break;
                    case 2: // Impresora
                        Impresora i = new Impresora(id);
                        i.load();
                        dispositivos.add(i);
                        break;
                    default: // Resto (dispositivos genéricos)
                        dispositivos.add(d);
                        break;
                }
            }
            else {
                // El dispositivo no existe en el fichero de datos. Terminamos la carga
                terminar = true;
            }
            id++;
        }
        while (!terminar);
        System.out.println("Se han cargado " + dispositivos.size() + " dispositivos");
    }

    /**
     * Añade un dispositivo tanto al array de datos como a los ficheros de datos. 
     * Puede ser un dispositivo genérico o alguno de los subtipos (ordenador, impresora,...)
     * Los datos del nuevo dispositivo se piden por teclado al usuario.
     */
    public static void addDevice() {
        int tipo = Teclado.leerEntero("Introduce el tipo de dispositivo (1. Ordenador, 2. Impresora, 3. Otro): ");
        String marca = Teclado.leerCadena("Introduce la marca: ");
        String modelo = Teclado.leerCadena("Introduce el modelo: ");
        switch (tipo) {
            case 1:
                String procesador = Teclado.leerCadena("Introduce el procesador: ");
                int ram = Teclado.leerEntero("Introduce la cantidad de RAM en GB: ");
                int disco = Teclado.leerEntero("Introduce la capacidad del disco duro en GB: ");
                Ordenador o = new Ordenador(marca, modelo, true, procesador, ram, disco);
                o.save();  // Añadimos el ordenador a los ficheros de datos
                dispositivos.add(o);  // Añadimos el ordenador al array de dispositivos
                break;
            case 2:
                int tipoImpresora = Teclado.leerEntero("Introduce el tipo de impresora (1 = láser, 2 = inyección, 3 = otros): ");
                boolean color = Teclado.leerBoolean("¿Imprime en color? (s/n): ");
                boolean scanner = Teclado.leerBoolean("¿Tiene scanner? (s/n): ");
                Impresora i = new Impresora(marca, modelo, true, tipoImpresora, color, scanner);
                i.save();  // Añadimos la impresora a los ficheros de datos
                dispositivos.add(i);  // Añadimos la impresora al array de dispositivos
                break;
            default:
                Dispositivo d = new Dispositivo(marca, modelo, true);
                d.save();   // Añadimos el dispositivo a los ficheros de datos
                dispositivos.add(d);  // Añadimos el dispositivo al array de dispositivos
                break;
        }
    }


    /**
     * Muestra todos los dispositivos que existen en el array de dispositivos
     */
    public static void listDevices() {
        if (dispositivos.size() == 0) {
            System.out.println("No hay dispositivos.");
        }
        else {
            for(Dispositivo d : dispositivos) {
                System.out.println(d.toString());
            }
        }
    }

    /**
     * Busca un dispositivo en el array de dispositivos por su id
     */
    public static void searchDevice() {
        int id = Teclado.leerEntero("Introduce el id del dispositivo que quieres buscar: ");
        boolean encontrado = false;
        for(Dispositivo d : dispositivos) {
            if (d.getId() == id) {
                System.out.println(d.toString());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Dispositivo no encontrado.");
        }
    }

    /**
     * Elimina un dispositivo tanto del array de dispositivos como de los ficheros de datos
     */
    public static void deleteDevice() {
        int id = Teclado.leerEntero("Introduce el id del dispositivo a borrar: ");
        boolean encontrado = false;
        for(Dispositivo d : dispositivos) {
            if (d.getId() == id) {
                d.delete();   // Lo borramos del fichero de datos
                dispositivos.remove(d);  // Lo borramos del array de dispositivos
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("Dispositivo borrado con éxito.");
        }
        else {
            System.out.println("Dispositivo no encontrado.");
        }
    }


    /**
     * Cambia el estado de un dispositivo (activo/inactivo)
     */
    public static void changeDeviceStatus() {
        int id = Teclado.leerEntero("Introduce el id del dispositivo: ");
        boolean encontrado = false;
        for(Dispositivo d : dispositivos) {
            if (d.getId() == id) {
                d.setEstado(!d.getEstado());
                d.save();
                System.out.println(d.toString());
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("Estado del dispositivo cambiado con éxito.");
        }
        else {
            System.out.println("Dispositivo no encontrado.");
        }

    }
    
    /** Modifica un dispositivo. Muestra los datos actuales del dispositivo, tanto si es dispositivo genérico
     * como si es impresora u ordenador, y permite modificar cualquier campo excepto el ID y "borrado". Si el usuario pulsta
     * Intro, ese campo se mantiene en su valor actual
     */
    public static void modifyDevice() {
        int id = Teclado.leerEntero("Introduce el id del dispositivo a modificar: ");
        boolean encontrado = false;
        for(Dispositivo d : dispositivos) {
            if (d.getId() == id) {
                System.out.println(d.toString());
                String marca = Teclado.leerCadena("Introduce la marca [" + d.getMarca() + "]: ");
                if (!marca.equals("")) {
                    d.setMarca(marca);
                }
                String modelo = Teclado.leerCadena("Introduce el modelo [" + d.getModelo() + "]: ");
                if (!modelo.equals("")) {
                    d.setModelo(modelo);
                }
                d.save();  // Guardamos los cambios en el fichero de datos de dispositivos
                if (d.getTipo() == 1) {
                    // El dispositivo es un ordenador. Vamos a preguntar por los campos específicos
                    Ordenador o = (Ordenador) d;
                    String procesador = Teclado.leerCadena("Introduce el procesador [" + o.getProcesador() + "]: ");
                    if (!procesador.equals("")) {
                        o.setProcesador(procesador);
                    }
                    int ram = Teclado.leerEntero("Introduce la cantidad de RAM en GB [" + o.getRam() + "]: ");
                    if (ram != 0) {
                        o.setRam(ram);
                    }
                    int disco = Teclado.leerEntero("Introduce la capacidad del disco duro en GB [" + o.getDisco() + "]: ");
                    if (disco != 0) {
                        o.setDisco(disco);
                    }
                    o.save();  // Guardamos los cambios en el fichero de datos de ordenadores                  
                }
                if (d.getTipo() == 2) {
                    // El dispositivo es una impresora. Vamos a preguntar por los campos específicos
                    Impresora i = (Impresora) d;
                    int tipoImpresora = Teclado.leerEntero("Introduce el tipo de impresora (1 = láser, 2 = inyección, 3 = otros) [" + i.getTipo() + "]: ");
                    if (tipoImpresora != 0) {
                        i.setTipoImpresora(tipoImpresora);
                    }
                    boolean color = Teclado.leerBoolean("¿Imprime en color? (s/n) [" + i.getColor() + "]: ");
                    if (color != false) {
                        i.setColor(color);
                    }
                    boolean scanner = Teclado.leerBoolean("¿Tiene scanner? (s/n) [" + i.getScanner() + "]: ");
                    if (scanner != false) {
                        i.setScanner(scanner);
                    }
                    i.save();  // Guardamos los cambios en el fichero de datos de impresoras
                }
                encontrado = true;
                System.out.println("Dispositivo modificado con éxito.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Dispositivo no encontrado");
        }

    }


    /**
     * Borra todos los datos de los ficheros de dispositivos y del array. Pide confirmación previa al usuario
     */
    public static void resetData() {
        String confirmacion = Teclado.leerCadena("¿Estás seguro de que quieres borrar todos los datos (esta acción no se puede deshacer)? (S/N): ");
        if (confirmacion.equalsIgnoreCase("S")) {
            // Eliminamos los archivos de datos
            File f = new File("dispositivos.dat");
            f.delete();
            f = new File("ordenadores.dat");
            f.delete();
            f = new File("impresoras.dat");
            f.delete();
            dispositivos.clear();   // Limpiamos el array de dispositivos
            System.out.println("\nDatos borrados");
        } else {
            System.out.println("\n1Operación cancelada");
        }
    }
}