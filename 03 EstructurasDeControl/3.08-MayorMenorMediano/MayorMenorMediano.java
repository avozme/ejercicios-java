// Ejercicio 8
// Determina el orden de tres números enteros.

class MayorMenorMediano
{
   public static void main(String[] args)
   {
      int a, b, c;
      int menor, mediano, mayor;
      
      // Entrada de datos
      System.out.println("Por favor, introduzca tres números:");

      System.out.print("  Primer número: ");
      a = Integer.parseInt(System.console().readLine());

      System.out.print("  Segundo número: ");
      b = Integer.parseInt(System.console().readLine());

      System.out.print("  Tercer número: ");
      c = Integer.parseInt(System.console().readLine());

      // Procesamiento de los datos
      if ((a > b) && (b > c)) {
            mayor = a; mediano = b; menor = c;
      }
      if ((a > c) && (c > b)) {
            mayor = a; mediano = c; menor = b;
      }
      if ((b > a) && (a > c)) {
            mayor = b; mediano = a; menor = c;
      }
      if ((b > c) && (c > a)) {
            mayor = b; mediano = c; menor = a;
      }
      if ((c > a) && (a > b)) {
            mayor = b; mediano = a; menor = b;
      }
      if ((c > b) && (b > a)) {
            mayor = b; mediano = b; menor = a;
      }

      // Salida de datos
      System.out.println("El menor es: " + menor);
      System.out.println("El mediano es: " + mediano);
      System.out.println("El mayor es: " + mayor);

    }
}
