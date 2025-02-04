// Programa para probar la clase de conversión de divisas

import java.util.Scanner; 

class ConversorDivisasPruebaVersion1
{
   public static void main(String[] args)
   {
      
      ConversorDivisasVersion1 conversor;   // Declaramos una  variable de tipo ConversorDivisas
      conversor = new ConversorDivisasVersion1(); // Creamos un objeto de tipo ConversorDivisas

      // Ahora vamos a probar los métodos de la clase ConversorDivisas
      // para ver si funcionan bien.
      double cant, cantConvertida;
      Scanner sc;
      sc = new Scanner(System.in);     // Objeto Scanner para hacer la entrada/salida
      System.out.print("Dime una cantidad de dinero de euros: ");
      cant = sc.nextInt();
      cantConvertida = conversor.eurosALibras(cant);
      System.out.println(cant + " euros = " + cantConvertida + " libras");

      System.out.print("Dime una cantidad de dinero de libras: ");
      cant = sc.nextInt();
      cantConvertida = conversor.librasAEuros(cant);
      System.out.println(cant + " libras = " + cantConvertida + " euros");

    }
}
