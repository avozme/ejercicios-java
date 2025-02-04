/** 
 * Clase FicheroFutbol
 * 
 * Esta clase contiene el interfaz con el fichero de datos, es decir, todas las rutinas
 * para leer y escribir datos del fichero. No produce ninguna salida por consola.
 */

import java.io.*;

class FicheroFutbol {

    private final String NOMBRE_FICH_DATOS = "liga.txt";  // Nombre del fichero de datos
    public final int MAX_EQUIPOS = 20;                    // Número máximo de equipos en la liga

    /**
     * Añade un equipo en al fichero de datos.
     * TODO: comprobar que nunca se guarden más de 20 equipos en el fichero.
     * 
     * @param nombreEq Nombre del equipo
     * @param partJug Partidos jugados
     * @param partGan Partidos ganados
     * @param partEmp Partidos empatados
     * @param partPer Partidos perdidos
     * @param puntos Puntos del equipo
     * 
     * @return Devuelve 0 si todo va bien o -1 en caso de error.
     */
    public int save(String nombreEq, int partJug, int partGan, int partEmp, int partPer, int puntos) {
        int resultado;
        try {
            FileWriter f = new FileWriter(NOMBRE_FICH_DATOS, true);  // Poniendo "true" añade datos al final
            f.write(nombreEq + ";" + partJug + ";" + partGan + ";" + partEmp + ";" + partPer + ";" + puntos + "\n");
            f.close();
            resultado = 0;
        }
        catch (Exception e) {
            resultado = -1;
            System.err.println("Error al escribir en el fichero de datos");
        }
        return resultado;
    }

    /**
     * Devuelve todo el contenido del fichero de datos como un array de Strings
     * (una fila del fichero en cada posición del array)
     * 
     * @return Un array de Strings con el contenido del fichero de datos
     */
    public String[] getAll() {
        String[] datos = new String[MAX_EQUIPOS];   // MAX_EQUIPOS es el máximo de equipos que podemos tener en el fichero
        try {
            FileReader f = new FileReader(NOMBRE_FICH_DATOS);
            BufferedReader br = new BufferedReader(f);
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                datos[i] = linea;
                i++;
            }
        }
        catch (Exception e) {
            System.err.println("Error al leer el fichero de datos");
            datos = null;
        }
        return datos;
    }

    /**
     * Busca un equipo en el fichero a partir de su nombre.
     * @return null si no lo encuentra o un string con la línea del fichero si lo encuentra.
     */
    public String get(String nombreEq) {
        String linea = null;
        boolean encontrado = false;
        try {
            FileReader f = new FileReader(NOMBRE_FICH_DATOS);
            BufferedReader br = new BufferedReader(f);
            while ((linea = br.readLine()) != null) {
                if (linea.contains(nombreEq)) {
                    encontrado = true;
                    break;
                }
            }
        }
        catch (Exception e) {
            System.err.println("Error al leer el fichero de datos");
            linea = null;
        }
        if (!encontrado) linea = null;
        return linea;
    }

    /**
     * Busca un equipo en el fichero a partir de su nombre y devuelve su posición en el fichero.
     * @return La posición (fila) del equipo en el fichero de datos (si lo encuentra) o -1 el equipo no existe.
     */ 
    public int getPos(String nombreEq) {
        String linea = null;
        int posicion = -1;
        int i = 0;
        try {
            FileReader f = new FileReader(NOMBRE_FICH_DATOS);
            BufferedReader br = new BufferedReader(f);
            while ((linea = br.readLine()) != null) {
                if (linea.contains(nombreEq)) {
                    posicion = i;
                    break;
                }
                i++;
            }
        }
        catch (Exception e) {
            System.err.println("Error al leer el fichero de datos");
            posicion = -1;
        }
        return posicion;
    }

    /**
     * Elimina un equipo del fichero a partir de su nombre.
     * @param nombreEq Nombre del equipo buscado para borrar.
     * @return 0 si el borrado termina con éxito o -1 en caso de error.
     */ 
    public int delete(String nombreEq) {
        int result = -1;              // Resultado del borrado
        int pos = getPos(nombreEq);   // Obtenemos la posición del equipo en el fichero
        if (pos != -1) {
            try {
                // Vamos a copiar liga.txt en un fichero temporal (llamado temp), excepto la fila que queremos borrar
                File fSource = new File(NOMBRE_FICH_DATOS);
                File fDest = new File("temp");
                BufferedReader br = new BufferedReader(new FileReader(fSource)); // Abrimos liga.txt para lectura
                FileWriter newFile = new FileWriter(fDest);                        // Creamos un fichero temporal
                int numLinea = 0;         // Contador del número de líneas
                String linea = null;
                while ((linea = br.readLine()) != null) {
                    if (numLinea != pos) {     // pos es la línea que no queremos copiar al nuevo fichero
                        newFile.write(linea + "\n");
                    }
                    numLinea++;
                }
                // Borramos el viejo fichero liga.txt y renombramos temp para que se llame liga.txt
                br.close();
                newFile.close();
                fSource.delete();
                fDest.renameTo(fSource);
                result = 0;
            }
            catch (Exception e) {
                System.err.println("Error al leer el fichero de datos");
                result = -1;
            }
        }
        return result;
    }

    /**
     * Actualiza un equipo en el fichero de datos.
     * @param pos Posición del equipo en el fichero de datos
     * @param nombreEq Nombre del equipo
     * @param partJug Partidos jugados
     * @param partGan Partidos ganados
     * @param partEmp Partidos empatados
     * @param partPer Partidos perdidos
     * @param puntos Puntos del equipo
     * @return 0 si la actualización finaliza con éxito 0 -1 en caso de error
     */ 
    public int update(int pos, String nombreEq, int partJug, int partGan, int partEmp, int partPer, int puntos) {
        int result = -1;              // Resultado del update
        try {
                // Vamos a copiar liga.txt en un fichero temporal (llamado temp), cambiando la fila que queremos actualizar
                File fSource = new File(NOMBRE_FICH_DATOS);
                File fDest = new File("temp");
                BufferedReader br = new BufferedReader(new FileReader(fSource));   // Abrimos liga.txt para lectura
                FileWriter newFile = new FileWriter(fDest);                        // Creamos un fichero temporal
                int numLinea = 0;         // Contador del número de líneas
                String linea = null;
                while ((linea = br.readLine()) != null) {
                    if (numLinea == pos) {     // pos es la línea que queremos modificar
                         newFile.write(nombreEq + ";" + partJug + ";" + partGan + ";" + partEmp + ";" + partPer + ";" + puntos + "\n");       
                    }
                    else {
                        newFile.write(linea + "\n");
                    }
                    numLinea++;
                }
                // Borramos el viejo fichero liga.txt y renombramos temp para que se llame liga.txt
                br.close();
                newFile.close();
                fSource.delete();
                fDest.renameTo(fSource);
                result = 0;
        }
        catch (Exception e) {
                System.err.println("Error al leer el fichero de datos");
                result = -1;
        }
        return result;
    }

    /**
     * Ordena el fichero de datos según el número de puntos (de mayor a menor).
     * @return  en caso de éxito o -1 si hay algún error
     */
    public int sort() {
        int result = -1;

        // Cargamos todos los datos en un array de Strings
        String datos[] = getAll();

        if (datos == null) {    // No hay datos para ordenar
            result = -1;
        }
        else {
            // Creamos un array con los puntos
            int puntos[] = new int[MAX_EQUIPOS];
            for (int i = 0; i < datos.length; i++) {
                if (datos[i] != null) {
                    puntos[i] = Integer.parseInt(datos[i].split(";")[5]);
                }
                else {
                    puntos[i] = -1;
                }
            }

            // Ordenamos el array de puntos con el método de la burbuja.
            // Cada vez que intercambiemos dos posiciones, intercambiaremos también el array con todos los datos
            for (int i = 0; i < datos.length; i++) {
                for (int j = i; j < datos.length - 1; j++) {
                    if (puntos[j] < puntos[j+1]) {
                        // Intercambiamos los puntos
                        int aux = puntos[j];
                        puntos[j] = puntos[j+1];
                        puntos[j+1] = aux;
                        // Intercambiamos equipos en el array de datos
                        String auxStr = new String(datos[j]);
                        datos[j] = datos[j+1];
                        datos[j+1] = auxStr;
                    }
                }
            }

            // Escribimos el array de datos ordenados en liga.txt, sustituyendo los datos antiguos
            try {
                FileWriter f = new FileWriter(NOMBRE_FICH_DATOS);
                for (int i = 0; i < datos.length; i++) {
                    if (datos[i] != null) {
                        f.write(datos[i] + "\n");
                    }
                }
                result = 0;
                f.close();
            }
            catch (Exception e) {
                System.err.println("Error al escibir en el fichero");
                result = -1;
            }
        }
        return result;
    }

}