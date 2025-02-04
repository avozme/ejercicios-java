// Genera combinaciones para la lotería primitiva

import java.io.*;

public class LoteriaPrimitiva {

    // Solución 1: genera una combinación apoyándose en el método auxiliar esta(), que decide si un número
    // ya está en la combinación generada hasta ahora.
    public static int[] generaCombinacion() { 
	int[] combinacion = new int[6];
	int i, j;
	
	// Inicializamos el array a 0
	for (i = 0; i < 6; i++)
	  combinacion[i] = 0;
	
	// Generamos la combinación
	for (i = 0; i < 6; i++) {
          // Sacamos un número al azar hasta que demos con uno que no está ya en la combinacion
	  do {
	    num = (Math.random() * 49) + 1;
	  }
	  while (esta(num, combinacion));
	  combinacion[i] = num;
	}
	
	return combinacion;
    }
    
    // Devuelve true si el número num está en el array comb
    private static boolean esta(int num, int[] comb) {
      boolean encontrado = false;
      
      for (int i = 0; i < 6; i++) {
         if (num == comb[i]) encontrado = true;
      }
      
      return encontrado;
    }
    
    
    // SOLUCIÓN ALTERNATIVA
    // Este es otro generador de combinaciones de primitiva sin repetición.
    // No utiliza ningún otro método, sino que se encarga de todo: de generar los números aleatorios (bucle i)
    // y de comprobar que no estén repetidos (bucle j)
    public int[] loteriaArray(){
		int[] v = new int[6];
		int i = 0;
		while (i < 6){
			int n =((int)(Math.random()*49)+1);
			j = 0;
			while (j < i) {
				if (n == v[j]){
					n = ((int)(Math.random()*49)+1);
					j = 0;
				}
				else {
					j++;
				}
			}
			v[i] = n;
			i++;
		}
		return v;
    }
   
}
