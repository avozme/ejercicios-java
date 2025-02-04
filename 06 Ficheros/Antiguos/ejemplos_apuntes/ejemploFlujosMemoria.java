import java.io.*;

public class ejemploFlujosMemoria
{
  public static void main(String[] args)
  {
    String s = new String("No por mucho madrugar amanece más temprano\n");
    s = s + "No por mucho madrugar amanece más temprano\n";
    s = s + "No por mucho madrugar amanece más temprano\n";
    s = s + "Una novela de Jack Torrance";

    char[] arr = new char[s.length()];
    int car = 0;

    StringReader flujoEntrada = new StringReader(s);
    CharArrayWriter flujoSalida = new CharArrayWriter();

    try
    {
      while ((car = flujoEntrada.read()) != -1)
      {
        flujoSalida.write(car);
      }
      arr = flujoSalida.toCharArray();
      System.out.println(arr);
    }
    catch (IOException e) { e.printStackTrace(); }
    finally
    {
      flujoEntrada.close();
      flujoSalida.close();
    }
  }
}
