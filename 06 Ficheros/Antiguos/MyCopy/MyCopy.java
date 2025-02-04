import java.io.*;

public class MyCopy
{
    public static void copy(String nombreOrigen, String nombreDestino) {
        FileInputStream finput = null;
        FileOutputStream foutput = null;
        try {
            finput = new FileInputStream(nombreOrigen);
            foutput = new FileOutputStream(nombreDestino);
            int b;
            int cont = 0;
            int tamFichero = finput.available();
            int porcentaje, porcentajeAnterior = 0;
            
            while ((b = finput.read()) != -1) {
                 foutput.write((byte)b);
                 cont++;
                 porcentaje = (int)((double)cont/tamFichero * 100);
                 if (porcentaje != porcentajeAnterior)
		    System.out.format("%3d %% copiado\r", porcentaje);
                 porcentajeAnterior = porcentaje;
            }
        }
        catch (IOException e) { 
            System.out.println("¡Ooops! Ha ocurrido algún error al procesar el archivo");
            e.printStackTrace();
        }
        finally {
            try {
                if (finput != null) finput.close();
                if (foutput != null) foutput.close();
            }
            catch (IOException e2) {
                System.out.println("¡Ahí va! Ha ocurrido algún error al cerrar los archivos");
            }
	}
    }

}
