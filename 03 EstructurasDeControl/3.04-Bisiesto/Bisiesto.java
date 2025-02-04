class Bisiesto {

  public static void main(String[] args) {
	int a;
	System.out.print("Escriba un año: ");
	a = Integer.parseInt(System.console().readLine());
	
	if (a % 4 == 0) {
		if (a % 100 == 0) {
			if (a % 400 == 0) {  // El año es divisible entre 4, entre 100 y entre 400
				System.out.println("Ese año SÍ es bisiesto");
			}
			else { // El año es divisible entre 4 y entre 100 y no es divisible entre 400
				System.out.println("Ese año NO es bisiesto");
			}
		}
		else { // El año es divisible entre 4 pero no entre 100
			System.out.println("El año SI es bisiesto");

		}
	}
	else { // No es divisible entre 4
		System.out.println("El año NO es bisiesto");
	}
  
}
