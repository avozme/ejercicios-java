class TemperaturaPrueba
{
   public static void main(String[] args)
   {
      Temperatura convTemp;         // Declaramos una  variable de tipo Temperatura
      convTemp = new Temperatura(); // Creamos un objeto de tipo Temperatura

      // Ahora vamos a probar los métodos de la clase Temperatura
      // para ver si funcionan bien.
      double temp1 = 22;
      double temp2 = 71;
      double f = convTemp.celsiusToFarenheit(temp1);   // Probamos el método celsiusToFarenheit()
      double c = convTemp.farenheitToCelsius(temp2);   // Probamos el método farenheitToCelsius()
      
      System.out.println("22 ºC = " + f + " ºF");   // Mostramos los resultados
      System.out.println("71 ºF = " + c + " ºC");
    }
}
