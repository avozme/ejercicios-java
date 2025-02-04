class ParesImpares {
    
  public static void main(String[] args) {
      int pares[] = new int[100];
      int impares[] = new int[100];
     
      int p = 2;
      for (int i = 0; i < 100; i++) {
        pares[i] = p;
        p = p + 2;
      }

      int imp = 1;
      for (int i = 0; i < 100; i++) {
        impares[i] = imp;
        imp = imp + 2;
      }      
      
      System.out.println("PARES:");
      for (int i = 0; i < 100; i++) {
          System.out.println("pares[" + i + "] = " + pares[i]);
      }
      System.out.println("IMPARES:");
      for (int i = 0; i < 100; i++) {
          System.out.println("impares[" + i + "] = " + impares[i]);
      }
  }
}
