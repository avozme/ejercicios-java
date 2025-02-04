import java.io.*;

public class ejemploFileOutputStream 
{
  public static void main(String[] args) 
  {
    FileOutputStream fop = null;
    File file;
    String content = "Esto es lo que escribiremos en el fichero";
    try 
    {
      file = new File("mi_fichero.txt");
      fop = new FileOutputStream(file);
 
      // Si el fichero no existe, lo creamos
      if (!file.exists()) 
      {
        file.createNewFile();
      }

      // Convertirmos el string en bytes para poder escribirlo
      // (FileOutputStream solo admite bytes)
      byte[] contentInBytes = content.getBytes();
 
      fop.write(contentInBytes);
      fop.flush();
      fop.close();
 
      System.out.println("Escritura realizada con éxito");
    } 
    catch (IOException e) { e.printStackTrace(); }
    finally
    {
      try 
      {
        if (fop != null) { fop.close(); }
      }
      catch (IOException e) { e.printStackTrace(); }
    }
  }
}
