/**
 * Esta clase sustituye las vocales de una cadena por asteriscos.
 * En esta implementación se hace con un array de caracteres.
 */
public class Asteriscos {
    
    char[] caracteres;
    
    public Asteriscos() {
        EntradaDatos b = new EntradaDatos();
        String frase = b.leer("Introduce el texto: ");
        // convierto el string en un vector tipo char
        caracteres = frase.toCharArray();
    }
    
    /**
     * 
     * En este metodo se muestra el contenido del array de caracteres
     * 
     */
    public void mostrar(){
        
        for(int i = 0; i < caracteres.length; i++){
            
            System.out.println(caracteres[i]);
        }
    }
    
    /**
     * 
     * En este metodo se seleccionan las vocales del arrays para convertirlas en '*'
     * 
     */
    public void convertir(){
        
        for(int i = 0; i < caracteres.length; i++){
            
            if (caracteres[i]=='a'||caracteres[i]=='e'||caracteres[i]=='i'||caracteres[i]=='o'||caracteres[i]=='u'){
                caracteres[i] = '*';
            }
        }
    }
}
