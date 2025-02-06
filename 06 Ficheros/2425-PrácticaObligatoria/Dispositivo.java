import java.io.*;
import java.util.*;

/**
 * Esta clase maneja un dispositivo informático genérico.
 * Los dispositivos se almacenan en un archivo binario.
 */
public class Dispositivo {
    private int id;
    private int tipo;        // 0 = dispositivo genérico, 1 = ordenador, 2 = impresora, etc.
    private int idAjeno;     // Clave ajena para dispositivo hijo (ordenador, impresora, etc.). Será -1 si no tiene.
    private String marca;
    private String modelo;
    private boolean estado;  // true = funciona, false = no funciona
    private boolean borrado; // true = borrado, false = no borrado
    private final int TAM_REG = 4 + 4 + 4 + 50 + 50 + 1 + 1;  // Tamaño del registro (longitud fija)

    /**
     * Constructor para crear un nuevo dispositivo calculando automáticamente el id.
     * @param marca La marca del dispositivo.
     * @param modelo El modelo del dispositivo.
     * @param estado El estado del dispositivo (true = funciona, false = no funciona).
     */
    public Dispositivo(String marca, String modelo, boolean estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.tipo = 0;        // Valor predeterminado para dispositivo genérico
        this.borrado = false; // No está borrado por defecto
        this.idAjeno = -1;    // No tiene id ajeno por defecto
        this.id = obtenerMaxId() + 1; // Asigna el id más alto + 1
    }

    /**
     * Constructor para cargar un dispositivo por id.
     * @param id El id del dispositivo a cargar.
     */
    public Dispositivo(int id) {
        this.id = id;
        this.marca = " ";
        this.modelo = " ";
        this.estado = true;
        this.tipo = 0;
        this.borrado = false;
        this.idAjeno = -1;
    }

    /**
     * Obtiene el id del dispositivo.
     * @return El id del dispositivo.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene la marca del dispositivo.
     * @return La marca del dispositivo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del dispositivo.
     * @param marca La nueva marca del dispositivo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el modelo del dispositivo.
     * @return El modelo del dispositivo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del dispositivo.
     * @param modelo El nuevo modelo del dispositivo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el estado del dispositivo.
     * @return El estado del dispositivo (true = funciona, false = no funciona).
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * Establece el estado del dispositivo.
     * @param estado El nuevo estado del dispositivo (true = funciona, false = no funciona).
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el tipo de dispositivo.
     * @return El tipo de dispositivo (0 = dispositivo genérico, 1 = ordenador, 2 = impresora, etc.).
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de dispositivo.
     * @param tipo El nuevo tipo de dispositivo.
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Verifica si el dispositivo está marcado como borrado.
     * @return true si el dispositivo está marcado como borrado, false en caso contrario.
     */
    public boolean getBorrado() {
        return borrado;
    }

    /**
     * Establece el estado de borrado del dispositivo.
     * @param borrado El estado de borrado (true = borrado, false = no borrado).
     */
    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    /**
     * Obtiene el id ajeno del dispositivo.
     * @return El id ajeno del dispositivo.
     */
    public int getIdAjeno() {
        return idAjeno;
    }

    /**
     * Establece el id ajeno del dispositivo.
     * @param idAjeno El id ajeno a asignar al dispositivo.
     */
    public void setIdAjeno(int idAjeno) {
        this.idAjeno = idAjeno;
    }

    /**
     * Devuelve una representación en cadena del dispositivo con formato.
     * Ejemplo: "Marca: HP. Modelo: ScanJet Pro 2000. Estado: funciona"
     * @return Una cadena con los detalles del dispositivo.
     */
    @Override
    public String toString() {
        String str = "ID: " + id + ". ID Ajeno: " + idAjeno + ". Tipo: ";
        switch (tipo) {
            case 1: str += "ordenador. "; break;
            case 2: str += "impresora. "; break;
            default: str += "otros. "; break;
        }
        str = str + "Marca: " + marca + ". Modelo: " + modelo + ". Estado: ";
        if (estado) str = str + "funciona.";
        else str = str + "no funciona.";
        return str;
    }

    /**
     * Guarda el dispositivo en el archivo "dispositivos.dat".
     * Si el dispositivo no existe, se añade; si ya existe, se actualiza.
     * @return 0 si la operación fue exitosa, 1 si hubo un error en la escritura.
     */
    public int save() {
        int result = 0;
        try {
            RandomAccessFile file = new RandomAccessFile("dispositivos.dat", "rw");
            if (this.id * this.TAM_REG > file.length()) {
                // Es un dispositivo nuevo, así que escribiremos al final del archivo
                file.seek(file.length());
            }
            else {
                // El dispositivo ya existe, así que saltamos al inicio de su registro
                file.seek(this.id * this.TAM_REG);
            }
            file.writeInt(id);
            file.writeInt(tipo);
            file.writeInt(idAjeno);
            escribirStringLongitudFija(file, marca, 50);   // Escribimos la marca para que ocupe siempre 50 bytes
            escribirStringLongitudFija(file, modelo, 50);  // Lo mismo con el modelo, porque queremos registros de longitud fija
            file.writeBoolean(estado);
            file.writeBoolean(borrado);
            result = 0; // Todo fue bien
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            result = 1; // Error en la escritura
        }
        return result;
    }

    /**
     * Carga los atributos del dispositivo desde el archivo "dispositivos.dat" basándose en su id.
     * @return 0 si la operación tiene éxito, 1 si hay un error.
     */
    public int load() {
        int result = 0;    // Resultado de la lectura (lo pondremos a 1 si hay algún error)
        try {
            RandomAccessFile file = new RandomAccessFile("dispositivos.dat", "rw");
            long fileLength = file.length();
            file.seek(this.id * TAM_REG);    // Saltamos al inicio del registro
            if (file.getFilePointer() < fileLength) {
                // Leemos el registro
                file.readInt();  // Consumimos el ID
                int tipoTemp = file.readInt();
                int idAjenoTemp = file.readInt();
                String marcaTemp = leerStringLongitudFija(file, 50);
                String modeloTemp = leerStringLongitudFija(file, 50);
                boolean estadoTemp = file.readBoolean();
                boolean borradoTemp = file.readBoolean();
                if (borradoTemp) {
                    result = 1; // El dispositivo está marcado como borrado
                } else {
                    // El dispositivo no está borrado. Actualizamos los atributos del objeto
                    this.tipo = tipoTemp;
                    this.idAjeno = idAjenoTemp;
                    this.marca = marcaTemp;
                    this.modelo = modeloTemp;
                    this.estado = estadoTemp;
                    this.borrado = borradoTemp;
                }
            } else {
                result = 1; // No se encontró el dispositivo en el fichero
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            result = 1; // Error de lectura
        }
        return result;
    }

    /**
     * Marca el dispositivo como borrado en el archivo "dispositivos.dat".
     * No elimina físicamente el registro, solo cambia su estado a "borrado".
     * @return 0 si la operación fue exitosa, 1 si hubo un error o no se encontró el dispositivo.
     */
    public int delete() {
        int result = 0;
        try (RandomAccessFile file = new RandomAccessFile("dispositivos.dat", "rw")) {
            // Posición del fichero donde debería estar el byte "borrado"
            long posicionSalto = (this.id * this.TAM_REG) + (TAM_REG - 1); 
            if (posicionSalto < file.length()) {
                // Saltamos al byte "borrado" del registro que queremos borrar
                file.seek(posicionSalto); 
                file.writeBoolean(true); // Marcamos como borrado en el fichero
                this.borrado = true; // Actualizamos el atributo del objeto
                result = 0; // Dispositivo borrado correctamente
            }
            else { 
                result = 1;  // Error al borrar (registro fuera del archivo)
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            result = 1; // Error al borrar
        }
        return result;
    }

    /**
     * Obtiene el id más alto actualmente presente en el archivo "dispositivos.dat".
     * Utilizado para calcular el id del próximo dispositivo.
     * @return El id más alto en el archivo, o 0 si no hay dispositivos.
     */
    private int obtenerMaxId() {
        int maxId = 0;
        try {
            RandomAccessFile file = new RandomAccessFile("dispositivos.dat", "rw");
            long fileLength = file.length();
            if (fileLength > TAM_REG) {
                file.seek(fileLength - TAM_REG);   // Saltamos al inicio del último registro
                if (file.getFilePointer() < fileLength) {
                    maxId = file.readInt(); // Leemos el id de este último registro
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxId;
    }

    /**
     * Escribe en un RandomAccessFile un String, ocupando una longitud fija
     * @param raf El flujo abierto con el archivo
     * @param str El String que se quiere escribir
     * @param longitud Número de bytes que debe ocupar el String en el archivo
     */
    protected void escribirStringLongitudFija(RandomAccessFile raf, String str, int longitud) throws IOException {
        long posIni = raf.getFilePointer();
        raf.writeUTF(str);
        long posFin = raf.getFilePointer();
        long bytesEscritos = posFin - posIni;  // El String ha ocupado estos bytes en el archivo
        // Vamos a rellenar con ceros hasta el total de bytes que se deben escribir
        for (int i = 0; i < longitud - bytesEscritos; i++) {
            raf.writeByte(0);
        }
    }

    /**
     * Lee un campo de tipo String de longitud fija de un RandomAccessFile abierto
     * y deja el cursor justo al final del campo para que se pueda continuar la lectura.
     * 
     * @param raf El RandomAccessFile, que debe de estar abierto
     * @param longitud El número de bytes que ocupa el campo de forma fija
     */
    protected String leerStringLongitudFija(RandomAccessFile raf, int longitud) throws IOException  {
        long pos = raf.getFilePointer();  // Posición antes de leer el String
        String str = raf.readUTF();
        raf.seek(pos + longitud);    // Colocamos el cursor al final de campo de longitud fija
        return str;
    }
}