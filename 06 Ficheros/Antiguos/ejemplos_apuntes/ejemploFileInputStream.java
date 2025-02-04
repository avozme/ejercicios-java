import java.io.*;

public class ejemploFileInputStream 
{
  public static void main(String[] args) 
  {
    File file = new File("mi_fichero.txt");
    FileInputStream fis = null;
    try 
    {
      fis = new FileInputStream(file);
      System.out.println("Tamaño del fichero: " + fis.available());
      int content;
      while ((content = fis.read()) != -1) 
      {
        // Convierte el byte leído en un carácter para mostrarlo
        System.out.print((char) content);
      }
    } 
    catch (IOException e) { e.printStackTrace(); } 
    finally 
    {
      try 
      {
        if (fis != null)
          fis.close();
      } 
      catch (IOException ex) { ex.printStackTrace(); }
    }
  }
}
