/* 
Este programa comprueba si un número real tiene decimales o no
*/

public class ParteDecimal {

  public static void main(String[] args) {
    double num;
    double numRedondeado;
    
    System.out.println("Escribe un número (puede tener decimales o no): ");
    num = Double.parseDouble(System.console().readLine());
    numRedondeado = Math.round(num);
    if (num == numRedondeado) {
      System.out.println("El número que has introducido no tiene decimales");
    }
    else {
      System.out.println("El número que has introducido SÍ tiene decimales");
    }
  }

}







