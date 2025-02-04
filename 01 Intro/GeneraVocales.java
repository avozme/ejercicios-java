public class GeneraVocales {
  
  public static char getVocal() {
    char car = ' ';
    int aleat = 0;
    
    aleat = (int)(Math.random() * 10);
    
    if (aleat == 0) car = 'A';
    if (aleat == 1) car = 'E';
    if (aleat == 2) car = 'I';
    if (aleat == 3) car = 'O';
    if (aleat == 4) car = 'U';
    if (aleat == 5) car = 'a';
    if (aleat == 6) car = 'e';
    if (aleat == 7) car = 'i';
    if (aleat == 8) car = 'o';
    if (aleat == 9) car = 'u';

    return car;
  }

  public static void main(String[] args) {
    System.out.println(getVocal());
    System.out.println(getVocal());
    System.out.println(getVocal());
    System.out.println(getVocal());
  }
}
  
  