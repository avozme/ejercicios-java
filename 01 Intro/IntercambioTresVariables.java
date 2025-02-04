public class IntercambioTresVariables {

  public static void main(String[] args) {

    int a, b, c, x;
    
    a = 1; 
    b = 2; 
    c = 3;

    x = b;
    b = a;
    a = c;
    c = x;
    
    System.out.println("El valor de las variables es:");
    System.out.println("a = " + a + ", b = " + b + ", c = " + c);
  }
}
  
  