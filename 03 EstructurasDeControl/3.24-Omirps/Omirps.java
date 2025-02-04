class Omirps {


    /* ALGORITMO PRINCIPAL (main) */
    public static void main(String[] args) {
        System.out.println("Introduce un número");
        int limite = Integer.parseInt(System.console().readLine());
        System.out.println("Estos son los números Omipr que existen entre 2 y " + limite + ":");


        for (int n = 2; n <= limite; n++) {
            boolean primo = esPrimo(n);
            int nInvertido = invertir(n);
            boolean primoInvertido = esPrimo(nInvertido);
            if (primo && primoInvertido) System.out.print(n + " ");
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

    /* SUBALGORITMO invertir(): le da la vuelta a un número entero
       y devuelve el número invertido */
    public static int invertir(int numero) {

        int invertido = 0;

        while (numero != 0) {
            // Extraemos el último dígito
            int digito = numero % 10;
            // Movemos los dígitos existentes a la izquierda y agregamos el nuevo dígito
            invertido = invertido * 10 + digito;
            // Eliminamos el último dígito del número original
            numero = numero / 10;
        }

        return invertido;

	    /* También se puede resolver mediante conversión del número en String, así:
	    StringBuilder str = new StringBuilder(n);
	    String inverso = str.reverse().toString();
	    int invertido = Integer.parseInt(inverso);
	    return invertido;
	    */        
    }
}
