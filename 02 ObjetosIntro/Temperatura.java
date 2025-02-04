public class Temperatura {
   // Convierte de grados C a grados F
   public double celsiusToFarenheit(double tempC) {
      double result = (1.8*tempC)+32;
      return result;
   }

   // Convierte de grados F a grados C
   public double farenheitToCelsius(double tempF) {
      double result = (tempF-32)/1.8;
      return result;
   }
}
