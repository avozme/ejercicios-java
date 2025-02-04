// Programa para probar la clase de conversión de divisas

import java.util.Scanner; 

class ConversorDivisasPruebaVersion2
{
   public static void main(String[] args)
   {
      double cant, cantConvertida;
      int moneda;
      Scanner sc;
      sc = new Scanner(System.in);     // Objeto Scanner para hacer la entrada/salida
     
      // Vamos a probar el conversor de divisas
      System.out.print("Dime un tipo de moneda (1 = euros, 2 = libras): ");
      moneda = sc.nextInt();
      System.out.print("Dime una cantidad de dinero: ");
      cant = sc.nextInt();
      ConversorDivisasVersion2 conversor;   // Declaramos una  variable de tipo ConversorDivisas
      conversor = new ConversorDivisasVersion2(moneda, cant); // Creamos un objeto de tipo ConversorDivisas
      cantConvertida = conversor.convertir();

      // Mostramos el resultado
      if (moneda == 1) {  // Hemos convertido de euros a libras
            System.out.println(cant + " euros = " + cantConvertida + " libras");
      }
      else {                // Hemos convertido de libras a euros
            System.out.println(cant + " libras = " + cantConvertida + " euros");
      }
    }
}
