class Impares {

  public static void main(String[] args) {
    int mayor, menor, a, b;
    
    System.out.println("Escribe dos números");
    a = Integer.parseInt(System.console().readLine());
    b = Integer.parseInt(System.console().readLine());
    System.out.println("Los números pares entre " + a + " y " + b + " son:");

    if (a < b)  {
      menor = a;
      mayor = b;
    }
    else {
      menor = b;
      mayor = a;
    }

    if (menor % 2 == 0) {
        // El número menor es PAR. Lo convertimos en IMPAR
        menor = menor + 1;
    }
    // Mostramos todos los números entre a y b
    while (menor <= mayor) {
        System.out.println(menor);
        menor = menor + 2;
    }
    
    
  }
  
}