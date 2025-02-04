class LoteriaPrimitivaPrueba {

  public static void main(String[] args) {
        LoteriaPrimitiva loto = new LoteriaPrimitiva();
        int[] combinacion = new int[];
        
        combinacion = loto.generaCombinacion();
        
        System.out.println("Combinación aleatoria para la lotería primitiva:");	
	      for (i = 1; i < 6; i++) {
		      System.out.println(combinacion[i]);
        }
  }
}
