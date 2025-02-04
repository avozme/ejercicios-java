// Ejercicio 14
// Tabla de multiplicar de un número N

public class TablaMultiplicar {

   public static void main(String[] args) {
      int n, i;
      System.out.print("Escriba un número entero: ");
      n = Integer.parseInt(System.console().readLine());    
      System.out.println("Tabla de multiplicar del número " + n);

      i = 1;
      while (i <= 10) {
         System.out.println(n + " x " + i + " = " + n * i);
         i++;  // Esto es lo mismo que i = i + 1
      }
   }
}
