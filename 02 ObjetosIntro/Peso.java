class Peso {
   private double gramos = 0;

   // Constructor. Recibe la cantidad y la unidad de medida.
   // Convierte cualquier unidad a gramos. Así será más fácil
   // hacer el resto de métodos.
   public Peso(double cantidad, String unidad) {
      if (unidad == "gr") gramos = cantidad;
      if (unidad == "kg") gramos = cantidad*1000;     // Convierte kg a gramos
      if (unidad == "lb") gramos = cantidad/0.0022;   // Convierte libras a gramos
      if (unidad == "oz") gramos = cantidad/0.0353;   // Convierte onzas a gramos
   }

   // Devuelve el peso en libras
   public double getLibras() {
      return gramos * 0.002205;
   }

   // Devuelve el peso en onzas
   public double getOnzas() { 
      return gramos * 0.035274;
   }

   // Devuelve el peso en kilogramos
   public double getPeso() {
      return gramos / 1000;
   }

   // Devuelve el peso en gramos
   public double getGramos() {
      return gramos;
   }
   
}
