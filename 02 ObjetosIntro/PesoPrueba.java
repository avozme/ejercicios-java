class PesoPrueba
{
   public static void main(String[] args)
   {
      Peso p1 = new Peso(10, "oz");    // Instancia un objeto peso con valor 10 onzas
      Peso p2 = new Peso(10, "lb");    // Instancia un objeto peso con valor 10 libras
      Peso p3 = new Peso(10, "kg");    // Instancia un objeto peso con valor 10 kilogramos
      Peso p4 = new Peso(10, "gr");    // Instancia un objeto peso con valor 10 gramos

      System.out.println("PROBANDO EL METODO getPeso():");
      System.out.println("Diez onzas son " + p1.getPeso() +  " kg");
      System.out.println("Diez libras son " + p2.getPeso() +  " kg");
      System.out.println("Diez kilogramos son " + p3.getPeso() +  " kg");
      System.out.println("Diez gramos son " + p4.getPeso() +  " kg");

      System.out.println("PROBANDO EL RESTO DE GETTERS:");
      System.out.println("Diez kilogramos son " + p3.getOnzas() +  " oz");
      System.out.println("Diez kilogramos son " + p3.getLibras() +  " lb");
      System.out.println("Diez kilogramos son " + p3.getGramos() +  " gr");

    }
}
