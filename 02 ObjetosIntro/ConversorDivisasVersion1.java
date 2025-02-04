// Conversor de divisas: convierte de libras a euros y viceversa
// VERSIÓN 1: son métodos constructores

public class ConversorDivisasVersion1 {

   // Convierte de libras a euros
   public double librasAEuros(double libras) {
      double euros = libras * 0.85;
      return euros;
   }

   // Convierte de euros a libras
   public double eurosALibras(double euros) {
      double libras = euros / 0.85;
      return libras;
   }
}
