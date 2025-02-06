import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Esta clase maneja los datos de un ordenador, añadiendo al Dispositivo base los campos procesador (String), ram (int) y disco (int).
 * Permite guardar y cargar los datos de un ordenador en un archivo binario.
 */
public class Ordenador extends Dispositivo {
    private int idOrdenador;
    private String procesador;
    private int ram;
    private int disco;
    private final int TAM_REGISTRO = 4+ 50 + 4 + 4;   // 4 bytes para ram, 4 bytes para disco, 4 bytes para idOrdenador, 50 bytes para procesador

    /**
     * Constructor para crear un ordenador nuevo a partir de los datos tecleados por el usuario.
     * @param marca Marca del ordenador
     * @param modelo Modelo del ordenador
     * @param procesador Procesador del ordenador
     * @param ram Cantidad de RAM en GB
     * @param disco Capacidad del disco duro en GB
     */
    public Ordenador(String marca, String modelo, String procesador, int ram, int disco) {
        super(marca, modelo, true);  // Ponemos "funciona" a true por defecto
        this.procesador = procesador;
        this.ram = ram;
        this.disco = disco;
        this.idOrdenador = obtenerMaxId() + 1;
        super.setTipo(1);  // Ponemos el tipo de dispositivo a 1 (= ORDENADOR)
        super.setIdAjeno(this.idOrdenador);
    }

    /**
     * Constructor para cargar los datos de un ordenador ya almacenado en el archivo ordenadores.dat
     * @param id ID del ordenador a cargar
     */
    public Ordenador(int id) {
        super(id);
        this.procesador = "";
        this.ram = 0;
        this.disco = 0;
        super.setTipo(1);  // Ponemos el tipo de dispositivo a 1 (= ORDENADOR)
        this.idOrdenador = super.getIdAjeno();
    }

    /**
     * Devuelve el id del ordenador
     * @return El id del ordenador
     */
    public String getProcesador() {
        return procesador;
    }

    /**
     * Establece el procesador del ordenador
     * @param procesador El procesador del ordenador
     */
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    /**
     * Devuelve la cantidad de RAM del ordenador
     * @return La cantidad de RAM del ordenador
     */
    public int getRam() {
        return ram;
    }

    /**
     * Establece la cantidad de RAM del ordenador
     * @param ram La cantidad de RAM del ordenador
     */
    public void setRam(int ram) {
        this.ram = ram;
    }

    /**
     * Devuelve la capacidad del disco duro del ordenador
     * @return La capacidad del disco duro del ordenador
     */
    public int getDisco() {
        return disco;
    }

    /**
     * Establece la capacidad del disco duro del ordenador
     * @param disco La capacidad del disco duro del ordenador
     */
    public void setDisco(int disco) {
        this.disco = disco;
    }

    /**
     * Devuelve una cadena con los datos del ordenador
     */
    @Override
    public String toString() {
        return super.toString() + " ID Ordenador: " + idOrdenador + 
                ". Procesador: " + procesador + ". RAM: " + ram + " GB. Disco duro: " + disco + " GB.";
    }

    /**
     * Guarda los datos del ordenador en el archivo ordenadores.dat
     */
    @Override
    public int save() {
        int result = 0;
        super.save();
        try {
            // Usamos un RandomAccessFile
            RandomAccessFile raf = new RandomAccessFile("ordenadores.dat", "rw");
            // Si el idOrdenador es mayor que el último, nos situamos al final del archivo para añadir el nuevo registro.
            // Si el idOrdenador el menor que el último, significa que el registro ya existe, y nos situamos en su posición.
            if (idOrdenador > obtenerMaxId()) {
                raf.seek(raf.length());
            } else {
                raf.seek(idOrdenador * TAM_REGISTRO);
            }
            // Escribimos los datos
            raf.writeInt(this.idOrdenador);
            escribirStringLongitudFija(raf, this.procesador, 50);
            raf.writeInt(this.ram);
            raf.writeInt(this.disco);
            // Cerramos el archivo
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
            result = 1;
        }
        return result;
    }

    /**
     * Carga los datos del ordenador con el id = this.id desde el archivo ordenadores.dat
     * @return 0 si se ha cargado correctamente, 1 si ha habido algún error
     */
    @Override
    public int load() {
        int result = 0;
        super.load();
        this.idOrdenador = super.getIdAjeno();
        try {
            RandomAccessFile raf = new RandomAccessFile("ordenadores.dat", "r");
            raf.seek(this.idOrdenador * TAM_REGISTRO);
            raf.readInt();  // Consumimos el ID
            this.procesador = leerStringLongitudFija(raf, 50);
            this.ram = raf.readInt();
            this.disco = raf.readInt();
            raf.close();
            result = 0;
        } catch (IOException e) {
            e.printStackTrace();
            result = 1;
        }
        return result;
    }

    /**
     * Obtiene el último id asignado en el archivo ordenadores.dat
     * @return Último id asignado en el archivo ordenadores.dat
     */
    private int obtenerMaxId() {
        int maxId = -1;
        try {
            // Abrimos el archivo binario ordenadores.dat con un RandomAccessFile
            RandomAccessFile raf = new RandomAccessFile("ordenadores.dat", "rw");
            if (raf.length() > 0) {
                // Saltamos al último registro
                raf.seek(raf.length() - TAM_REGISTRO);
                // Leemos el último id
                maxId = raf.readInt();
            }
            // Cerramos el archivo
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
            maxId = -1;
        }
        return maxId;
    }
}
