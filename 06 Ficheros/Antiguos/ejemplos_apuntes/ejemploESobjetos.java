import java.io.*;

public class ejemploESobjetos
{
   static File f;
   static FileOutputStream fo;
   static ObjectOutputStream oos;
   static FileInputStream fi;
   static ObjectInputStream ois;

   public static void main(String[] args)
   {
      String[] nombres = {"Pepe Tardo", "Ana Bolizante", "Jaime Tralleta"};
      int[] edades = {15, 29, 47};
      
      // Escritura del fichero
      try
      {
         fo = new FileOutputStream("personas.txt");
         oos = new ObjectOutputStream(fo);
         for (int i = 0; i < 3; i++)
         {
            persona p = new persona(nombres[i], edades[i]);
            oos.writeObject(p);
         }
         if (oos != null)
         {
            oos.close();
            fo.close();
         }
      }
      catch (IOException e) { e.printStackTrace(); }

      // Lectura del fichero
      try
      {
         f = new File("personas.txt");
         if (f.exists())
         {
            fi = new FileInputStream(f);
            ois = new ObjectInputStream(fi);
            persona p = null;

            while (fi.available() > 0)
            {
               p = (persona)ois.readObject();
               p.mostrar();
            }
         }
      }
      catch (IOException e) { e.printStackTrace(); }
      catch (ClassNotFoundException cnf) { cnf.printStackTrace(); }
   }
}
