/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfebrero15;
import java.io.*;

/**
 *
 * @author ctic
 */
public class ExamenFebrero15 {

    static short[] tablero = new short[64];
    
    public ExamenFebrero15() {
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ejercicio 1
        //convertirLetras();
        
        // Ejercicio 2
        for (short i = 0; i < 64; i++) tablero[i] = (short)(Math.random()*10);
        mostrarTablero();
        System.out.println("Contenido de la casilla (0,3) = " + getContenido(0, 3));
        /*
        // Ejercicio 3
        mostrarExpediente();
        
        // Ejercicio 4
        resetNotas(1);
        mostrarExpediente();
        */
    }
    
    /* EJERCICIO 1
     * Abrir un fichero de texto y generar otro igual, cambiando mayúsculas por minúsculas y a la inversa.
     */
    public static void convertirLetras() {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String forig = null, fdest = null;

        try {
            // Leemos los nombres de los dos ficheros
            System.out.print("Introduzca el nombre del fichero origen: ");
            forig = buff.readLine();
            System.out.print("Introduzca el nombre del fichero destino: ");
            fdest = buff.readLine();
            
            // Abrimos los ficheros
            FileReader fr = new FileReader(forig);
            FileWriter fw = new FileWriter(fdest);
            
            // Leemos el primer carácter
            int c = fr.read();
            while (c != -1) {
                // Si es mayúscula, lo convertimos a minúscula
                if (c >= 'A' && c <= 'Z') c = c + 32;
                // Si es minúscula, lo convertimos a mayúscula
                else if (c >= 'a' && c <= 'z') c = c - 32;
                // En cualquier otro caso, no tocamos el carácter (se queda igual)
                // Y ahora, lo escribimos en el fichero destino
                fw.write(c);
                // Leemos el siguiente carácter del fichero origen
                c = fr.read();
            }
            fr.close();
            fw.close();
        }
        catch (Exception e) { e.printStackTrace(); }
    }
    
    
    /* EJERCICIO 2A
     * Mostrar un tablero de 64 casillas guardado en un array unidimensional como un tablero de 8x8 bidimensional
     */
    public static void mostrarTablero() {
       for (int fila = 0; fila < 8; fila++) {
           System.out.println("+---+---+---+---+---+---+---+---+");
           for (int col = 0; col < 8; col++) {
               System.out.print("| " + getContenido(fila, col) + " ");
           }
           System.out.println("|");
       }
       System.out.println("+---+---+---+---+---+---+---+---+");
    }

    /* EJERCICIO 2B
     * Devolver el contenido de la posición (fila,col) del tablero anterior
     */
    public static short getContenido(int fila, int col) {
        return tablero[fila * 8 + col];
    }
    
    /* EJERCICIO 3
     * Mostrar el expediente de un alumno. Los datos personales están en alumnos.dat y los datos académicos en expedientes.dat
     * Ambos ficheros contienen objetos de tipo Alumno y Expediente serializados.
     */
    public static void mostrarExpediente() {
        // Pedimos el número de alumno buscado
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int codAlum = 0;
        Alumno alumno = null;
        boolean encontrado = false;

        try {
            System.out.print("Introduzca el código del alumno: ");
            codAlum = Integer.parseInt(buff.readLine());
        }
        catch (Exception e) { e.printStackTrace(); }
        
        // Buscamos el alumno en el fichero alumnos.dat
        try {
            FileInputStream fis = new FileInputStream("alumnos.dat");
            
            while (fis.available() > 0 && !encontrado) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                alumno = (Alumno)ois.readObject();
                if (alumno.getCodigo() == codAlum) {
                    encontrado = true;
                }
            }
            fis.close();
        }
        catch (Exception e) { e.printStackTrace(); }
        
        // Buscamos los expedientes del alumno (solo si hemos encontrado el alumno)
        if (encontrado) {
            System.out.println("Datos del alumno/a " + alumno.getCodigo());
            System.out.println(" - Nombre y apellidos: " + alumno.getNombre() + " " + alumno.getAp1() + " " + alumno.getAp2());
            System.out.println(" - Domicilio: " + alumno.getDomic());
            try {
                FileInputStream fis = new FileInputStream("expedientes.dat");
                while (fis.available() > 0) {
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Expediente exp = (Expediente)ois.readObject();
                    if (alumno.getCodigo() == exp.getCodigoAlumno()) {
                        exp.mostrarInfo();  // Suponemos que los expedientes tienen este método para mostrar su información
                    }
                }
                fis.close();   
            }
            catch (Exception e) { e.printStackTrace(); }
        }
        else {
            System.out.println("Alumno/a no encontrado");
        }
    }
    
    /* EJERCICIO 4
     * Pone a cero todas las notas de un expediente en el archivo expedientes.dat
     */
    public static void resetNotas(int numExpediente) {
        try {
            // Abrimos para lectura el archivo de expedientes, y lo vamos copiando en un archivo temporal
            FileInputStream fis = new FileInputStream("expedientes.dat");
            FileOutputStream fos = new FileOutputStream("temporal");
            while (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                Expediente exp = (Expediente)ois.readObject();
                // Si es el expediente buscado, ponemos las notas a 0 antes de enviarlo al fichero temporal
                if (exp.getCodigoExpediente() == numExpediente) {
                    if (exp instanceof ExpSecundaria || exp instanceof ExpBachillerato) {
                        exp.setNotaJunio(0);
                        exp.setNotaSeptiembre(0);
                    }
                    if (exp instanceof ExpFP) {
                        exp.setNotaFinal(0);
                    }
                }
                // Escribimos el expediente en el fichero temporal. 
                // Observa que todos los expedientes se guardarán idénticos a como están en expediente.dat
                // excepto el expediente que buscábamos, que se habrá puesto a 0 antes de guardarlo.
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(exp);
            }
            fis.close();
            fos.close();
            
            // Por último, eliminamos el archivo expedientes.dat y renombramos el temporal
            // para convertirlo en el nuevo expedientes.dat
            File forig = new File("expedientes.dat");
            File fnuevo = new File("temporal");
            File faux = new File("expedientes.dat");
            
            forig.delete();
            fnuevo.renameTo(faux);
        }
        catch (Exception e) { e.printStackTrace(); }
    }
         
}
