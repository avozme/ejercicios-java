// Versión de GeneraVocales SIN uso de instrucciones condicionales

public class GeneraVocales2 {
  
  public static char getVocal() {
    long vocales = (long)'A' + (long)'E' << 8 + (long)'I' << 16 + (long)'O' << 24 + (long)'U' << 32;
    int aleat = 0;
    char caracter = ' ';
    
    aleat = (int)(Math.random() * 5);
    
    caracter = (char)(vocales >> aleat);
    System.out.println("vocales = " + vocales + ", aleat = " + aleat + ", caracter = " + caracter);

    return caracter;
  }

  public static void main(String[] args) {
    System.out.println(getVocal());
    System.out.println(getVocal());
    System.out.println(getVocal());
    System.out.println(getVocal());
  }
}
  
  