import java.io.*;


/**
 * La clase círculo calcula y muestra el área y el perímetro de una circunferencia.
 * El radio se lee por consola.
 */
public class Circulo {
  
/**
 * Calcula el área y el perímetro de un círculo
 */
  public static void main (String[] args) {
    double radio = 0;		
    double area, circunf;
    radio = leeTeclado();	
    area = calculaArea(radio);	
    circunf = calculaCircunferencia(radio);
    muestraResultado(radio, area, circunf);
  }

  
/**
 * Calcula el área de un círculo
 *
 * @param  r  el radio del círculo
 * @return    el área del círculo
 */
  public static double calculaArea(double r) {
    double a;
    a = Math.PI * (r * r);
    return a;
  }
  
/**
 * Calcula el perímetro de un círculo
 *
 * @param  r  el radio del círculo
 * @return    el perímetro o longitud de circunferencia del círculo
 */
  public static double calculaCircunferencia(double r) {
    double c;
    c = 2 * Math.PI * r;
    return c;
  }

/**
 * Lee el radio del círculo por teclado
 *
 * @return   el radio del círculo
 */
  public static double leeTeclado() {
    double radio = 0;
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    System.out.printf("Escribe el valor del radio: ");
    try {
      radio = Double.parseDouble(buffer.readLine());
    }
    catch (Exception e) {
      System.out.println("Error de lectura de datos");
    }
    return radio;
  }
  
  
/**
 * Muestra el resultado
 *
 * @param  r       el radio del círculo
 * @param  area    el área del círculo
 * @param  circunf la longitud de la circunferencia
 */
  public static void muestraResultado(double r, double area, double circunf) {
    System.out.println("Radio: " + r);
    System.out.println("Área: " + area);
    System.out.format("Circunferencia: %.2f\n", circunf);
  }
  
  
  
  
  
  
  
  
  
  
}

  