class Eratostenes {


    /* ALGORITMO PRINCIPAL (main) */
    public static void main(String[] args) {
        System.out.println("Estos son los primos entre 2 y 1000:");

        for (int n = 2; n <= 1000; n++) {
            boolean primo = esPrimo(n);
            if (primo) System.out.print(n + " ");
        }
    }


    /* SUBALGORITMO esPrimo(): determina si un número es primo o no */
    public static boolean esPrimo(int n) {
        boolean primo;  
        primo = true;
        for (int i = 2; i <= n/2 && primo; i++) {
            if (n % i == 0) primo = false;
        }       
        return primo;        
    } 
}
