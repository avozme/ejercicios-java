// Genera combinaciones para la lotería primitiva
// SOLUCIÓN 2: los números no se repiten (sin usar arrays ni listas)

public class LoteriaPrimitiva2 {

	public static void main(String[] args) {
		borrarPantalla();
        int num;
		int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0; 
		System.out.println("+--------------------------+");
		System.out.println("|     LOTERIA PRIMITIVA    |");
		System.out.println("+--------------------------+");
		for (int i = 1; i <= 6; i++)  {
            boolean numValido;
			do {
                numValido = true;
				num = (int)(Math.random() * 49) + 1;
                if ((num == num1) || (num == num2) || (num == num3) || (num == num4) || (num == num5))
                    numValido = false;
			} while (!numValido);

			System.out.printf("|            %2d            |\n", num);

            if (i == 1) num1 = num;
            if (i == 2) num2 = num;
            if (i == 3) num3 = num;
            if (i == 4) num4 = num;
            if (i == 5) num5 = num;
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

