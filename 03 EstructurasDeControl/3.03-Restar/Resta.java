class Resta {

  public static void main(String[] args) {
	int n1, n2, r;
	System.out.println("Por favor, escriba dos números enteros y los restaré: ");
	n1 = Integer.parseInt(System.console().readLine());
	n2 = Integer.parseInt(System.console().readLine());

	if (n1 > n2) {
		r = n1 - n2;
	}
	else {
		r = n2 - n1;
	}
	System.out.println("El resultado es: " + r);    
  }
}
