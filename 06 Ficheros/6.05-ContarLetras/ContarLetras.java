import java.io.*;

class ContarLetras {

	private char[] abecedario = { 'A', 'a', 'Á', 'á', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'É', 'é', 'F', 'f', 'G',
			'g', 'H', 'h', 'I', 'i', 'Í', 'í', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'Ñ', 'ñ', 'O', 'o',
			'Ó', 'ó', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'Ú', 'ú', 'Ü', 'ü', 'V', 'v', 'W',
			'w', 'Z', 'z' };
	private int[] contCaracteres = new int[abecedario.length];
	private int contador = 0;
	private int contRestoCaracteres = 0;
	
	/**
	 * Constructor. Inicializa los contadores de caracteres
	 * @param nombreFich
	 */
	public void ContarLetras() {
		for (int i = 0; i < abecedario.length; i++) {
			contCaracteres[i] = 0;
		}
	}

	/**
	 * Lee el archivo byte a byte y va contando los caracteres que se encuentra
	 * en los contadores de caracteres
	 */
	public void procesarArchivo(String nombreFich) {

		try {
			// Abrir el fichero indicado en la variable nombreFich
			FileInputStream finput = new FileInputStream(nombreFich);
			// Se recorre el fichero hasta encontrar el carácter -1 que es el final del
			// archivo que marca el final del fichero
			int caract;
			while ((caract = finput.read()) != -1) {
				int pos = getPosicion(caract);  // Buscamos la posición del carácter en el array de contadores
				if (pos != -1) {				// -1 significa que es un carácter no imprimible
					contCaracteres[pos]++;		// Incrementamos el contador del carácter correspondiente
				} else {
					contRestoCaracteres++;		// Incrementamos el contador de caracteres no imprimibles
				}

				// Contamos cuantos caracteres tenemos:
				contador++;
			} // while

			// Cerramos el fichero
			if (finput != null)
				finput.close();
		} // try
		catch (IOException e) {
			System.out.println("Error de lectura del fichero " + nombreFich);
		}

	}

	/**
	 * Busca la posición de un carácter en el array de caracteres.
	 * @param car
	 * @return La posición del carácter, o -1 si el carácter no está en la lista
	 */
	private int getPosicion(int car) {
		int i = 0;
		while (i < abecedario.length && abecedario[i] != car) {
			i++;
		}
		if (i < abecedario.length)
			return i; // Devolvemos la posicion del caracter
		else
			return -1;

	}

	/**
	 * Muestra los resultados por la consola
	 */
	public void mostrarResultados() {
		System.out.println("Núm. de caracteres del archivo: " + contador);
		System.out.println("Letra     Núm.De veces que aparece        Frecuencia (%)");
		System.out.println("---------------------------------------------------------");
		int i = 0;
		// Mostramos las letras del abecedario de una en una
		while (i < abecedario.length) {
			System.out.print("     ");
			System.out.print(abecedario[i]);
			System.out.print("\t");
			int cont;
			// Para las vocales A, E, I y O, sumamos 4 contadores (p:ej, para la A, sumamos el de la A, la Á, la a y la á)
			// Esos 4 contadores son consecutivos en el array de contadores.
			if (abecedario[i] == 'A' || abecedario[i] == 'E' || abecedario[i] == 'I' || abecedario[i] == 'O') {
				cont = contCaracteres[i] + contCaracteres[i + 1] + contCaracteres[i + 2] + contCaracteres[i + 3];
				i = i + 4;
			// Pala la vocal U, sumamos 6 contadores (U, Ú, Ü, u, ú, ü). Los 6 son consecutivos en el array de contadores
			} else if (abecedario[i] == 'U') {
				cont = contCaracteres[i] + contCaracteres[i + 1] + contCaracteres[i + 2] + contCaracteres[i + 3]
						+ contCaracteres[i + 4] + contCaracteres[i + 5];
				i = i + 6;
			} else {
				// Para el resto de letras (consonantes) sumamos los contadores de la letra en mayúscula y en minúscula.
				// Esos dos contadores son consecutivos en el array de contadores.
				cont = contCaracteres[i] + contCaracteres[i + 1];
				i = i + 2;
			}
			System.out.format("%16d", cont);
			System.out.format("%28.2f\n", (double) (cont * 100) / (contador - contRestoCaracteres));
		}
		System.out.println("Resto de caracteres: " + contRestoCaracteres);
	}

}
