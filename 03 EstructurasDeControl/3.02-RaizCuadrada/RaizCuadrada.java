/* Ejercicio 2
Calcular la raíz cuadrada de un número introducido por teclado. Hay que tener la precaución de
comprobar que el número sea positivo.
*/

public class RaizCuadrada {

  public static void main(String[] args) {
    double n, raiz;
    
    System.out.println("Escribe un número real: ");
    n = Double.parseDouble(System.console().readLine());
    if (n >= 0) {
      raiz = Math.sqrt(n);
    }
    else {
      raiz = -1.0;
    }
    if (raiz == -1.0) {
      System.out.println("El número " + n + " no tiene raíz cuadrada");
    }
    else {
      System.out.println("La raíz cuadrada de " + n + " es " + raiz);
    }
  }

}







