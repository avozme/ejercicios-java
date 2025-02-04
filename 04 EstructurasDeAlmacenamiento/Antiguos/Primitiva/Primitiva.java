import java.util.*;

public class Primitiva {

  private final static int TAM = 10;

  public static void main(String[] args) {

    int[] combinacion1 = generaPrimitivaArray();
    ArrayList combinacion2 = generaPrimitivaArrayList();
    
    System.out.println("Combinación generada con array clásico:");
    for (int i = 0; i < 6; i++) {
      System.out.print(combinacion1[i] + " ");
    }

    System.out.println("Combinación generada con ArrayList:");
    for (int i = 0; i < 6; i++) {
      System.out.print(combinacion2.get(i) + " ");
    }
    
    System.out.println("\n");
    
  }

  // Genera una combinación de lotería primitiva sin repetición de números.
  // Utiliza un array convencional.
  public static int[] generaPrimitivaArray() {
    int a = 0;
    int[] combinacion = new int[6];
    boolean repetido = false;
    
    for (int i = 0; i < 6; i++) {
      do {
        a = (int)(Math.random() * 49 + 1);
        repetido = false;
	for (int j = 0; j < i; j++) {
	  if (combinacion[j] == a) repetido = true;
	}
      }
      while (repetido);
      combinacion[i] = a;
    }
    
    return combinacion;
  }
  
  
  // Genera una combinación de lotería primitiva sin repetición de números.
  // Utiliza un ArrayList.
  public static ArrayList generaPrimitivaArrayList() {
    ArrayList<Integer> combinacion = new ArrayList<Integer>();
    int a = 0;
    
    for (int i = 0; i < 6; i++) {
      do {
	a = (int)(Math.random() * 49 + 1);	
      }
      while (combinacion.indexOf(a) != -1);
      combinacion.add(a);
    }
    
    return combinacion;
  }
  
}
