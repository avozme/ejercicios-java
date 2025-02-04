class Primos {

    public static void main(String[] args) {
        int n;
        boolean primo = true;  

        System.out.println("Introduce un número:");
        n = Integer.parseInt(System.console().readLine());
        for (int i = 2; i <= n/2 && primo; i++) {
		        if (n % i == 0) primo = false;
	    }
    
	    if (primo) System.out.println("El número " + n + " ES PRIMO");
	    else System.out.println("El número " + n + " NO es primo");
    }
}
