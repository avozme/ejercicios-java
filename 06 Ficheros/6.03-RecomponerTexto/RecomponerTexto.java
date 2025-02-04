import java.io.FileInputStream;

class RecomponerTexto {

    public static void main(String[] args) {

        System.out.println("Texto recuperado del fichero salida.txt:");
        try 
        { 
            FileInputStream fis = new FileInputStream("salida.txt");
            int c;
            while ((c = fis.read()) != -1) {           
                if ((char)c == '\n') System.out.print(" ");
                else System.out.print((char)c);
            }
            fis.close();
        }
        catch (Exception e) { 
                System.out.println("Error al leer el fichero");
                //e.printStackTrace(); 
        }             
        System.out.println();
   }    
}