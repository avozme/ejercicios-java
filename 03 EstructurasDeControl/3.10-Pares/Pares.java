
class Pares {

  public static void main(String[] args) {
    int a = Integer.parseInt(System.console().readLine());
    int b = Integer.parseInt(System.console().readLine());
    System.out.println("Los números pares entre " + a + " y " + b + " son:");

    if (a % 2 == 1) {
      // El número a es impar. Lo convertimos en par.c
      a = a + 1;
    }

    while (a <= b) {
      System.out.println(a);
      a = a + 2;
    }



    
  }
  
}