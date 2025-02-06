import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Esta clase maneja los datos de una impresora, añadiendo al Dispositivo base los campos tipo (int), color (boolean) y scanner (boolean).
 * Permite guardar y cargar los datos de una impresora en un archivo binario.
 */
public class Impresora extends Dispositivo {

    private int idImpresora;
    private int tipoImpresora;  // Tipo de impresora (¡no confundir con super.tipo!) -> 1 = láser, 2 = inyección de tinta, 3 = otros
    private boolean color;
    private boolean scanner;
    private final int TAM_REGISTRO = 4 + 4 + 1 + 1; // 4 bytes para tipo, 4 bytes para idImpresora, 1 byte para color, 1 byte para scanner

    /**
     * Constructor para crear una impresora nueva a partir de los datos tecleados por el usuario.
     * Asignará un id de impresora automáticamente y se lo pasará a la clase madre para que lo use como idAjeno.
     * @param marca Marca de la impresora
     * @param modelo Modelo de la impresora
     * @param tipoImpresora Tipo de impresora (1 = láser, 2 = inyección de tinta, 3 = otros)
     * @param color Indica si la impresora es a color
     * @param scanner Indica si la impresora tiene scanner
     */
    public Impresora(String marca, String modelo, int tipoImpresora, boolean color, boolean scanner) {
        super(marca, modelo, true);   // Ponemos "funciona" a true por defecto
        this.tipoImpresora = tipoImpresora;
        this.color = color;
        this.scanner = scanner;
        this.idImpresora = this.obtenerMaxId() + 1;
        super.setTipo(2);  // Ponemos el tipo de dispositivo a 2 (= IMPRESORA)
        super.setIdAjeno(this.idImpresora);
    }

    /**
     * Constructor para cargar los datos de una impresora ya almacenada en el archivo impresoras.dat
     * @param id ID de la impresora a cargar
     */
    public Impresora(int id) {
        super(id);
        this.tipoImpresora = 0;
        this.color = false;
        this.scanner = false;
        super.setTipo(2);  // Ponemos el tipo de dispositivo a 2 (= IMPRESORA)
        this.idImpresora = super.getIdAjeno();
    }

    /**
     * Devuelve el id de la impresora
     */
    public int getTipoImpresora() {
        return tipoImpresora;
    }

    /**
     * Establece el tipo de impresora
     */
    public void setTipoImpresora(int tipo) {
        this.tipoImpresora = tipo;
    }

    /**
     * Devuelve true si la impresora imprime en color o false en otro caso
     * @return true si imprime en color, false en otro caso
     */
    public boolean getColor() {
        return color;
    }

    /**
     * Establece si la impresora imprime en color o no
     * @param color true si imprime en color, false en otro caso
     */
    public void setColor(boolean color) {
        this.color = color;
    }

    /**
     * Devuelve true si la impresora tiene scanner o false en otro caso
     * @return true si tiene scanner, false en otro caso
     */
    public boolean getScanner() {
        return scanner;
    }

    /**
     * Establece si la impresora tiene scanner o no
     * @param scanner true si tiene scanner, false en otro caso
     */
    public void setScanner(boolean scanner) {
        this.scanner = scanner;
    }

    /**
     * Devuelve una cadena con los datos de la impresora
     */
    @Override
    public String toString() {
        String str = super.toString() + " ID Impresora: " + idImpresora + ". Tipo: ";
        switch (tipoImpresora) {
            case 1: str += "láser. "; break;
            case 2: str += "inyección de tinta. "; break;
            default: str += "otro. "; break;
        }
        if (color) { str += "Color: sí. ";} 
        else { str += "Color: no. "; }
        if (scanner) { str += "Tiene scanner: sí."; } 
        else { str += "Tiene scanner: no."; }

        return str;
    }

    /**
     * Guarda los datos de la impresora en los archivos impresoras.dat y dispositivos.dat
     */
    @Override
    public int save() {
        int result = 0;
        super.save();
        try {
            RandomAccessFile file = new RandomAccessFile("impresoras.dat", "rw");
            // Vamos a ver si la impresora ya existe
            if (this.idImpresora * this.TAM_REGISTRO > file.length()) {
                // Impresora nueva. La añadimos al final
                file.seek(file.length());
            } else {
                // Impresora existente. La sobreescribimos
                file.seek(this.idImpresora * this.TAM_REGISTRO);
            }
            file.writeInt(this.idImpresora);
            file.writeInt(this.tipoImpresora);
            file.writeBoolean(this.color);
            file.writeBoolean(this.scanner);
            file.close();
            result = 0;
        } catch (IOException e) {
            e.printStackTrace();
            result = 1;
        }
        return result;
    }

    /**
     * Carga los datos de la impresora con el id = this.id desde el archivo impresoras.dat
     */
    @Override
    public int load() {
        int result = 0;
        super.load();
        this.idImpresora = super.getIdAjeno();
        try {
            RandomAccessFile raf = new RandomAccessFile("impresoras.dat", "r");
            raf.seek(this.idImpresora * TAM_REGISTRO);
            raf.readInt();  // Consumimos el ID
            this.tipoImpresora = raf.readInt();
            this.color = raf.readBoolean();
            this.scanner = raf.readBoolean();
            raf.close();
            result = 0;
        } catch (IOException e) {
            e.printStackTrace();
            result = 1;
        }
        return result;
    }

    /**
     * Obtiene el último id asignado en el archivo impresoras.dat
     * @return Último id asignado en el archivo impresoras.dat
     */
    private int obtenerMaxId() {
        int maxId = -1;
        try {
            RandomAccessFile raf = new RandomAccessFile("impresoras.dat", "rw");
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
