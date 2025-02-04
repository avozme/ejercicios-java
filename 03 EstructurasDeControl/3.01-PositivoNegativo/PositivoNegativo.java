public class PositivoNegativo {
    public static void main(String[] args) {
        int a;
        System.out.println("Dime un número");
        a = Integer.parseInt(System.console().readLine());
        if (a > 0) {
            System.out.println("El número es positivo");
        }
        else {
            System.out.println("El número es negativo");
        }
    }
}