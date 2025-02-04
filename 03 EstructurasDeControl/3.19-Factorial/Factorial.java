public class Factorial{

	public static void main (String [] args){
	
		System.out.println("Introduce el numero con el que quieres operar:");
		long n = Long.parseLong(System.console().readLine());
		long fact = 1;

		for (long i = n; i > 1; i--) {
			fact = fact * i;
		}
		
		System.out.println(n + "! = " + fact); 
		
	}
}