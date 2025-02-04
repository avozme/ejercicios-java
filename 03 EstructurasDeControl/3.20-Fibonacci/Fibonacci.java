public class Fibonacci {
	public static void main(String[] args){
		int numElementos;
		long numeroActual, numeroSiguiente;

		System.out.print("Introduzca el numero para calcular su sucesión de Fibonacci: ");
		numElementos = Integer.parseInt(System.console().readLine());

		while (numElementos <= 1) {
			System.out.print("ERROR!!!!!\nEl numero introducido debe ser mayor que 0 y 1. Introduzca un nuevo numero: ");
			numElementos = Integer.parseInt(System.console().readLine());
		}

		numeroActual = 0;
		numeroSiguiente = 1;
		System.out.print(numeroActual + " - ");

		for (int i = 2; i < numElementos; i++) {
			System.out.print(numeroSiguiente + " - ");
			int aux = numeroActual;
			numeroActual  = numeroSiguiente;
			numeroSiguiente = aux + numeroSiguiente; 
		}
		System.out.println();
	}
}