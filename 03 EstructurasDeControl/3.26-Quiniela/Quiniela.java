// Genera combinaciones para la quiniela de fútbol
public class Quiniela {
	// Este método genera la combinación de la quiniela
	public static void main(String[] args) {
		borrarPantalla();  // NO es imprescindible, pero queda bien

		for (int i = 1; i <= 14; i++)  {
			int resultado = (int)(Math.random() * 3);
			if (resultado == 0) {
				System.out.print("X");
			}
			else {
				System.out.print(resultado);
			}
			if (i < 14)
				System.out.print(" - ");
		} // for iç
		System.out.println();
	}

	// Este método borra la pantalla de texto
	public static void borrarPantalla() {
		for (int i = 1; i < 100; i++) {
			System.out.println();
		}
	}
}
