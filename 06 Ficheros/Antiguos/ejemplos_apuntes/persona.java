public class persona implements java.io.Serializable
{
   protected String nombre;
   protected int edad;
   public persona(String n, int e)
   {
      nombre = n;
      edad = e;
   }
   public void mostrar()
   {
      System.out.println("Hola, soy una persona. Estos son mis datos:");
      System.out.println("Nombre " + nombre + "edad " + edad);
   }
}
