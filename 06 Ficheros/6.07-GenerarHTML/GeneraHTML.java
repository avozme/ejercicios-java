import java.io.FileOutputStream;


public class GeneraHTML{

  private static String textoTitulo, colorTitulo, tamTitulo;
  private static String textoCuerpo, colorCuerpo, tamCuerpo;

  public static void leerDatos() {
      System.out.println("Introduce el texto del título:");
      textoTitulo = System.console().readLine();
      System.out.println("Introduce el color del título:");
      colorTitulo = System.console().readLine();
      System.out.println("Introduce el tamaño del título:");
      tamTitulo = System.console().readLine();
      
      System.out.println("Introduce el texto del cuerpo:");
      textoCuerpo = System.console().readLine();
      System.out.println("Introduce el color del cuerpo:");
      colorCuerpo = System.console().readLine();
      System.out.println("Introduce el tamaño del cuerpo:");
      tamCuerpo = System.console().readLine();
  }
  
  
  public static void escribirArchivo() {
    try {
      FileOutputStream fos = new FileOutputStream("pagina.html");
      
      fos.write("<html>\n\t<head>\n\t\t<meta charset='UTF-8'>\n\t\t<title>Ejemplo Java</title>\n\t</head>\n".getBytes());
      fos.write(("<body><p style = 'font-size: " + tamTitulo + " ; color:" + colorTitulo + "'>" + textoTitulo + "</p>").getBytes());
                 
      fos.write(("<p style = 'color:" + colorCuerpo + "; font-size: " + tamCuerpo + "'>" + textoCuerpo + "</p></body></html>").getBytes());
      fos.close();
    }
    catch (Exception e) { 
      System.out.println("Error al escribir el fichero de salida"); 
    }
                
  }

  
  
  
  
  
  
  
  
  
  
  
  
  

}
