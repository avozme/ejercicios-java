import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ordenador extends Dispositivo {
    private String procesador;
    private int ram;
    private int disco;
    private int idOrdenador;
    private final int TAM_REGISTRO = 62;   // 4 bytes para ram, 4 bytes para disco, 4 bytes para idOrdenador, 50 bytes para procesador

    public Ordenador(String marca, String modelo, boolean tipo, String procesador, int ram, int disco) {
        super(marca, modelo, tipo);
        this.procesador = procesador;
        this.ram = ram;
        this.disco = disco;
        this.idOrdenador = obtenerMaxId() + 1;
    }

    public Ordenador(int id) {
        super(id);
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDisco() {
        return disco;
    }

    public void setDisco(int disco) {
        this.disco = disco;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + procesador + " - " + ram + " - " + disco;
    }

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

    @Override
    public int load() {
        int result = 0;
        super.load();
        try {
            FileReader fr = new FileReader("ordenadores.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(" - ");
                if (Integer.parseInt(campos[0]) == getId()) {
                    setMarca(campos[1]);
                    setModelo(campos[2]);
                    setTipo(Boolean.parseBoolean(campos[3]));
                    procesador = campos[4];
                    ram = Integer.parseInt(campos[5]);
                    disco = Integer.parseInt(campos[6]);
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            result = 1;
        }
        return result;
    }

    /**
     * Obtiene el último id asignado en el archivo ordenadores.dat
     */
    private int obtenerMaxId() {
        int maxId = -1;
        try {
            // Abrimos el archivo binario ordenadores.dat con un RandomAccessFile
            RandomAccessFile raf = new RandomAccessFile("ordenadores.dat", "r");
            // Saltamos al último registro
            raf.seek(raf.length() - TAM_REGISTRO);
            // Leemos el último id
            maxId = raf.readInt();
            // Cerramos el archivo
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
            maxId = -1;
        }
        return maxId;
    }
}
