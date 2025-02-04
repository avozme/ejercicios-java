// Genera combinaciones para la lotería primitiva
// SOLUCIÓN 1: no mira si los números se repiten

public class LoteriaPrimitiva {

	public static void main(String[] args) {
		borrarPantalla();
		System.out.println("+--------------------------+");
		System.out.println("|     LOTERIA PRIMITIVA    |");
		System.out.println("+--------------------------+");
		for (int i = 1; i <= 6; i++)  {
			int num = (int)(Math.random() * 49) + 1;
			System.out.printf("|            %2d            |\n", num);
		}
		System.out.println("+--------------------------+");
	}

	// Este método borra la pantalla de texto
	public static void borrarPantalla() {
		for (int i = 1; i < 100; i++) {
			System.out.println();
		}
	}	
}

