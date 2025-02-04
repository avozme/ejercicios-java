class AcumuladorInteractivo {

   public static void main(String[] args) {
      int suma, i;
      int a, b;       // Los números inicial y final para el acumulador
      int numValores; // La cantidad de valores que se han introducido por teclado

      a = 0;
      suma = 0;
      numValores = 0;
      while (a >= 0) {
          System.out.println("Dime un número (negativo para terminar)");
          a = Integer.parseInt(System.console().readLine());
          suma = suma + a;
          numValores++;
      }
      System.out.println("La media es: " + (double)suma/numValores);
   }
}
