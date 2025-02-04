// Clase MiNumero (ejercicio 2.3)

class MiNumero {

   private int n;

   // Constructor sin parámetros: establece el número a 0
   MiNumero() {
      n = 0;
   }

   // Constructor parametrizado para establecer valor del número
   MiNumero(int num) {
      n = num;
   }

   // Asigna un nuevo valor al número
   void cambiaNumero(int num) {
      n = num;
   }

   // Suma una cantidad al número
   void suma(int num) {
      n = n + num;
   }
 
   // Resta una cantidad al número
   void resta(int num) {
      n = n - num;
   }

   // Devuelve el valor actual del número
   int getValor() {
      return n;
   }

   // Devuelve el doble del valor actual del número
   int getDoble() {
      return n*2;
   }

   // Devuelve el triple del valor actual del número
   int getTriple() {
      return n*3;
   }

   // Devuelve el cuádruple del valor actual del número
   int getCuadruple() {
      return n*4;
   }

}
