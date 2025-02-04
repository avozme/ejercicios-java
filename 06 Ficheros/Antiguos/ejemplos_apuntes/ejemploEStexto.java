import java.io.*;

public class ejemploEStexto
{
   public static void main(String[] args)
   {
      int c = 0;
      try
      {
         FileReader finput = new FileReader("fichero_origen.txt");
         FileWriter foutput = new FileWriter("fichero_destino.txt");

         // El valor c == -1 indicará fin del fichero de entrada
         while (c != -1)
         {
            c = finput.read();
            if (c != -1) {
	      System.out.print((char)c);
	      foutput.write(c);
	    }
         }
         if (finput != null) finput.close();
         if (foutput != null) foutput.close();
         System.out.println();

         foutput = new FileWriter("fichero_mostruo.txt");
         while (1 == 1) {
	      foutput.write('a');
	 }
      }
      catch (IOException e) { e.printStackTrace(); }
      
      
   }
}
