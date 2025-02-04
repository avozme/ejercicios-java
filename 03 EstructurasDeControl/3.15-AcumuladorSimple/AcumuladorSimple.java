class AcumuladorSimple {

   public static void main(String[] args) {
      int suma, i;
      suma = 0;
      i = 2;
      while (i <= 1000) {
        suma = suma + i;
        i = i + 2;  // Se puede abreviar como i += 2
      }
      System.out.println(suma);
   }
}
