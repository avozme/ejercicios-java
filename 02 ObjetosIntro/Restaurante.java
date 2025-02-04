class Restaurante {

   private int huevos;      // Número de huevos
   private int chorizo;	    // Gramos de chorizo

   // Constructor: inicializa los valores de huevos y chorizo
   Restaurante(int docenasDeHuevos, double kgDeChorizo) {
      huevos = docenasDeHuevos * 12;  // Vamos a almacenar el nº de huevos, no de docenas
      chorizo = (int) (kgDeChorizo * 1000);   // Vamos a guardar la cantidad en gramos
   }

   // Incrementa el número de huevos
   void addHuevos(int num) {
      huevos = huevos + (num * 12);
   }

   // Incrementa la cantidad de gramos de chorizo. El método recibe la
   // cantidad expresada en kg, así que la multiplicamos por 1000.
   void addChorizo(double num) {
      chorizo = (int)(chorizo + (num * 1000));
   }

   // Calcula cuántos platos se pueden cocinar con las cantidades actuales de huevos y chorizo
   int getNumPlatos() {
      // Calculamos cuántos platos se pueden preparar con los huevos actuales
      int n1 = huevos / 2;                    // Cada plato necesita 2 huevos
      // Calculamos cuántos platos se pueden preparar con los chorizos actuales
      int n2 = chorizo / 200;  		      // Cada plato necesita 200 gr de chorizo
      // El número máximo de platos que se pueden preparar será el menor entre n1 y n2
      if (n1 < n2) {
         return n1;
      }
      else {
         return n2;
      }
   }
 
   // Resta una cantidad al número de huevos y chorizos, como resultado de haber servido un plato
   // (2 huevos menos y 200 gr de chorizo menos)
   void sirvePlato() {
      huevos = huevos - 2;
      chorizo = chorizo - 200;
   }

   // Devuelve el número actual de huevos
   int getHuevos() {
      return huevos;
   }

   // Devuelve el número actual de kg de chorizo
   double getChorizo() {
      return ((double)chorizo / 1000);
   }
}











