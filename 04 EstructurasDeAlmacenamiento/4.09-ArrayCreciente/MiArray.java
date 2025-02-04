/**
 * Esta clase resuelve el ejercicio del array creciente
 * utilizando ARRAYS ESTÁTICOS
 */
public class MiArray {

  private int[] a;  // Este es el array
    
  /**
   * Genera un array de tamaño tam con valores aleatorios crecientes entre min y max
   */ 
  public void generar(int tam, int min, int max) {
    // Creamos el array
    a = new int[tam];
    // Rellenamos el array completamente al azar
    for (int i = 0; i < a.length; i++) {
      a[i] = (int)(Math.random()*(max-min+1)) + min;
    }
    // Ordenamos el array para que los números sean crecientes
    ordenar();
  }
  
  /**
   * Devuelve el contenido del array convertido en un String
   */ 
  public String toString() {
    String str = "";
    for (int i = 0; i < a.length; i++) {
      str = str + a[i] + " - ";
    }
    return str;
  }
 
  /**
   * Ordena por el método de la burbuja
   * (también se puede hacer con Arrays.sort(a))
   */ 
  public void ordenar() {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length-1; j++) {
        if (a[j] > a[j+1]) {
          int aux = a[j];
          a[j] = a[j+1];
          a[j+1] = aux;
        }
      } // for j
    } // for i
  }  

  /**
   * Inserta el número n en el array sin desordenarlo
   */ 
  public void insertarOrdenado(int n) {
      int pos = buscarPosicionInsercion(n);
      desplazarArrayDerecha(pos);
      a[pos] = n;
  }
  
  /**
   * Localiza la posición de inserción del número n
   */ 
  private int buscarPosicionInsercion(int n) {
      int i = a.length - 1;
      int posicion = 0;
      while (i >= 0 && posicion == 0) {
         if (a[i] < n) posicion = i+1;
         i--;
      }
      return posicion;
      
  }
  
  /**
   * Desplaza todo el array hacia la derecha a partir de la posición pos
   */ 
  private void desplazarArrayDerecha(int pos) {
      for (int i = a.length - 1; i > pos; i--) {
        a[i] = a[i-1];
      }
  }
    
}
