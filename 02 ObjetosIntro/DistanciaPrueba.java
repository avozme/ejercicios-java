class DistanciaPrueba
{
   public static void main(String[] args)
   {
      // 1. Leer una cantidad de millas por teclado
      System.out.println("Introduce una cantidad de millas: ");
      double millas = Double.parseDouble(System.console().readLine());

      Distancia d = new Distancia();
      
      // 2. Convertir las millas a metros y guardarlo en una variable
      double metros = d.millasAMetros(millas);
      
      // 3. Convertir las millas a km y guardarlo en otra variable
      double km = d.millasAKilometros(millas);
      
      // 4. Mostrar los metros y los km
      System.out.println(m + " millas son " + metros + " metros");
      System.out.println(m + " millas son " + km + " km");
    }
}
