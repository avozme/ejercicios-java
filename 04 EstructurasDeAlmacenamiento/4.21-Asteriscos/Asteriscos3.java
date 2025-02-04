
/**
 * Esta clase sustituye las vocales de una frase por asteriscos.
 * En esta solución utilizamos un String y los métodos propios de esta clase
 * para hacer la búsqueda y sustitución.
 * 
 */
public class Asteriscos3 {
    
    String frase;
    
    public Asteriscos3() {
        EntradaDatos b = new EntradaDatos();
        frase = b.leer("Introduce el texto: ");
    }
    
    /**
     * 
     * En este metodo se muestra el contenido del array de caracteres
     * 
     */
    public void mostrar(){
        System.out.println(frase);
    }
    
    /**
     * 
     * En este metodo se seleccionan las vocales del arrays para convertirlas en '*'
     * 
     */
    public void convertir(){
        frase = frase.replace('a', '*');
        frase = frase.replace('e', '*');
        frase = frase.replace('i', '*');
        frase = frase.replace('o', '*');
        frase = frase.replace('u', '*');
    }
}
