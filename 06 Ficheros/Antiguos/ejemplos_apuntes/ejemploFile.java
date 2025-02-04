import java.io.*;

public class ejemploFile 
{
   public static void main(String[] args) 
   {
      File f = null;
      String[] strs = {"test1.txt", "test2.txt"};
      try{
         // Para cada String en el array strs... 
         for(String s:strs )
         {
            // Crea el flujo
            f= new File(s);
            
            // Si el fichero no existe, lo creamos
            if (!f.exists()) 
               f.createNewFile();

            // Comprueba si el fichero tiene permisos de escritura
            boolean w = f.canWrite();
            
            // Recupera la ruta absoluta
            String p = f.getAbsolutePath(); 
            
            // Muestra los datos recuperados
            System.out.print("Ruta: " + p + ". Permiso escritura: " + w);
         } 
      }
      catch(Exception e) { e.printStackTrace(); }
   }
}
