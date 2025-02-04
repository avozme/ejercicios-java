// Programa para probar la clase MiNumero.
// Construiremos un par de objetos de tipo MiNumero
// para probar los diferentes métodos.

class MiNumeroPrueba
{
   public static void main(String[] args)
   {
      MiNumero n1 = new MiNumero();    // Crea un número con valor 0

      System.out.print("Por favor, introduzca un número entero: ");
      int x = Integer.parseInt(System.console().readLine());
      MiNumero n2 = new MiNumero(x);   // Crea un número con valor x
      
      n1.cambiaNumero(5);              // Asigna un nuevo valor (5) al número n1
      n1.resta(1);                     // Resta 1 al número n1 (ahora n1 valdrá 4)
      n2.suma(n1.getValor());          // Suma a n2 el valor de n1 (ahora n2 valdrá 11)
      
      System.out.println("\n\nPROBANDO LA CLASE miNumero\n\n");

      System.out.println("NÚMERO n1");
      System.out.println("  Valor actual = " + n1.getValor());
      System.out.println("  Doble = " + n1.getDoble());
      System.out.println("  Triple = " + n1.getTriple());
      System.out.println("  Cuádruple = " + n1.getCuadruple() + "\n");

      System.out.println("NÚMERO n2");
      System.out.println("  Valor actual = " + n2.getValor());
      System.out.println("  Doble = " + n2.getDoble());
      System.out.println("  Triple = " + n2.getTriple());
      System.out.println("  Cuádruple = " + n2.getCuadruple() + "\n");
    }
}
