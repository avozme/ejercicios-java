class ConjuntoTest {
	public static void main(String[] args) {
	  ConjuntoDeEnteros c1 = new ConjuntoDeEnteros();

	  c1.insertarElemento(Integer.valueOf(5));
	  c1.insertarElemento(Integer.valueOf(8));
      System.out.println("¿El número 5 está en el conjunto? " + c1.esta(Integer.valueOf(5)));
      System.out.println("¿El número 6 está en el conjunto? " + c1.esta(Integer.valueOf(6)));
	  System.out.println("¿Cuántos elementos hay en el conjunto? " + c1.contarElementos());

	  ConjuntoDeStrings c2 = new ConjuntoDeStrings();
	  c2.insertarElemento("Pepito");
	  c2.insertarElemento("Grillo");
	  System.out.println("¿La cadena Grillo está en el conjunto? " + c2.esta("Grillo"));
	  System.out.println("¿La cadena Giusseppe está en el conjunto? " + c2.esta("Giusseppe"));
	  System.out.println("¿Cuántos elementos hay en el conjunto? " + c2.contarElementos());

	}
}
