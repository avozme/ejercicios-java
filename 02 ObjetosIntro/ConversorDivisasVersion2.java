// Conversor de divisas: convierte de libras a euros y viceversa
// VERSIÓN 2: con métodos constructores

public class ConversorDivisasVersion2 {

    private int tipoMoneda;  // 1 = euros, 2 = libras
    private double dinero;

   public ConversorDivisasVersion2(int tipo, double d) {
      tipoMoneda = tipo;
      dinero = d;
   }

   // Convierte de libras a euros o euros a libras, dependiendo del valor de tipoMoneda
   public double convertir() {
      double result;
      if (tipoMoneda == 1) {
        result = dinero * 0.85;   // Convierte de euros a libras
      }
      else {
        result = dinero / 0.85;   // Convierte de libras a euros
      }
      return result;

   }

}
