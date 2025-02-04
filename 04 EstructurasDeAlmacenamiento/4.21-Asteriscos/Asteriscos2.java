
/**
 * Esta clase sustituye las vocales de una frase por asteriscos.
 * En esta solución utilizamos un StringBuffer.
 * 
 */
public class Asteriscos2 {
    
    StringBuffer frase;
    
    public Asteriscos2() {
        EntradaDatos b = new EntradaDatos();
        String str = b.leer("Introduce el texto: ");
        frase = new StringBuffer(str);
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
        
        for(int i = 0; i < frase.length(); i++){
            
            if (frase.charAt(i)=='a'||frase.charAt(i)=='e'||frase.charAt(i)=='i'||frase.charAt(i)=='o'||frase.charAt(i)=='u'){
                frase.replace(i, i, "*");
            }
        }
    }
}
