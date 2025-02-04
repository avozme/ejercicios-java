import java.io.FileOutputStream;

class DescomponerTexto {

    public static void main(String[] args) {

        // SOLUCIÓN 1: Escribir carácter a carácter

        System.out.println("Escribe un texto:");
        String s = System.console().readLine();
        try 
        { 
            FileOutputStream fos = new FileOutputStream("salida.txt");
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') fos.write('\n');
                else fos.write(c);
            }
            fos.close();
        }
        catch (Exception e) { 
                System.out.println("Error al escribir en el fichero");
                e.printStackTrace(); 
        }             
        System.out.println("Texto salvado con éxito");


/*
        // SOLUCIÓN 2: escribir palabra a palabra
        
        System.out.println("Escribe un texto:");
        String s = System.console().readLine();
        String palabras[] = s.split(" ");
        try 
        { 
            FileOutputStream fos = new FileOutputStream("salida.txt");
            for (int i = 0; i < palabras.length; i++) {
                String pal = palabras[i] + "\n";
                fos.write(pal.getBytes());
            }
            fos.close();
        }
        catch (Exception e) { 
                System.out.println("Error al escribir en el fichero");
                e.printStackTrace(); 
        }             
        System.out.println("Texto salvado con éxito");

*/
    }    
}