class InicializarArray {
    
  public static void main(String[] args) {
      int a[] = new int[100];

      for (int i = 0; i < 100; i++) {
        a[i] = -1;
      }
      
      for (int i = 0; i < 100; i++) {
          System.out.println("La posición " + i + " del array contiene el valor: " + a[i]);
      }
  }
} 
