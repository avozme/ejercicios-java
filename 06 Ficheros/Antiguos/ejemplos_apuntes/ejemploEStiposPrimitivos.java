import java.io.*;

public class ejemploEStiposPrimitivos
{
   private static FileOutputStream fOutput;
   private static FileInputStream fInput;
   private static DataOutputStream datosOutput;
   private static DataInputStream datosInput;
   private static File f;

   public static void main(String[] args)
   {
      // Escritura del fichero
      try
      {
         fOutput = new FileOutputStream("alumnado.txt");
         datosOutput = new DataOutputStream(fOutput);
         for (int i=0; i<2; i++)
         {
            System.out.println("Alumno/a núm. " + i);
            String nombre = System.console().readLine("Nombre? ");
            int edad = Integer.parseInt(System.console().readLine("Edad? "));
            datosOutput.writeUTF(nombre);
            datosOutput.writeInt(edad);
         }
         if (datosOutput != null)
         {
            datosOutput.close();
            fOutput.close();
         }
      }
      catch (IOException e) { e.printStackTrace(); }

      // Lectura del fichero
      try
      {
         f  = new File("alumnado.txt");
         if (f.exists())
         {
            fInput = new FileInputStream(f);
            datosInput = new DataInputStream(fInput);
            String nombre;
            int edad;
            System.out.println("Contenido del fichero alumnado.txt:");
            while (fInput.available() > 0)
            {
               nombre = datosInput.readUTF();
               System.out.println("Nombre: " + nombre);
               edad = datosInput.readInt();
               System.out.println("Edad: " + edad);
            }
         }
         if (datosInput != null)
         {
            datosInput.close();
            fInput.close();
         }
      }
      catch (FileNotFoundException e) 
      { 
         System.out.println("Fichero alumnado.txt no encontrado");
      }
      catch (IOException e) { e.printStackTrace(); }
   }
}
