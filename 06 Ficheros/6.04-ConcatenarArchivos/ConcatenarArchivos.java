import java.io.FileOutputStream;
import java.io.FileInputStream;

class ConcatenarArchivos {

    public static void main(String[] args) {

        try {
            FileInputStream fichEntrada1 = new FileInputStream("archivo1.txt");
            FileInputStream fichEntrada2 = new FileInputStream("archivo2.txt");
            FileOutputStream fichSalida = new FileOutputStream("archivo3.txt");

            int c = 0;
            long tamFich1 = fichEntrada1.available();
            long tamFich2 = fichEntrada2.available();
            long tam = tamFich1 + tamFich2;
            long cont = 0;

            while ((c = fichEntrada1.read()) != -1) {
                fichSalida.write((byte)c);
                cont++;
                System.out.print(cont*100/tam + "% completado\r");
            }
            while ((c = fichEntrada2.read()) != -1) {
                fichSalida.write((byte)c);
                cont++;
                System.out.print(cont*100/tam + "% completado\r");
            }
            fichEntrada1.close();
            fichEntrada2.close();
            fichSalida.close();
            System.out.println("Archivo3.txt generado con éxito");
        }
        catch(Exception e) {
            System.out.println("Error al procesar los archivos");
            e.printStackTrace();
        }

    }    
}