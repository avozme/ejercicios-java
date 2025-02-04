class EnteroGiganteTest {
	public static void main(String[] args) {
	  EnteroGigante eg1 = new EnteroGigante();
	  EnteroGigante eg2 = new EnteroGigante();
	  System.out.println("Escribe el primer entero gigante");
	  String n = System.console().readLine();
	  eg1.leer(n);

	  System.out.println("Escribe el segundo entero gigante");
	  n = System.console().readLine();
	  eg2.leer(n);
	  	  
	  EnteroGigante eg3 = eg1.sumar(eg2);
	  System.out.println("La suma vale:");
	  eg3.imprimir();
	  
	}
}