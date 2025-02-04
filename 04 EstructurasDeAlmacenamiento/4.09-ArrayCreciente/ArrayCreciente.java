import java.util.Scanner;

public class ArrayCreciente {
    public static void main(String[] args) {
        MiArray miArray = new MiArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué tamaño tendrá el array?");
        int tam = sc.nextInt();
        miArray.generar(tam, 1, tam*10);

        System.out.println("Array generado:");
        System.out.println(miArray.toString());

        System.out.println("¿Qué número quieres insertar?");
        int n = sc.nextInt();
        miArray.insertarOrdenado(n);

        System.out.println("Array modificado:");
        System.out.println(miArray.toString());
    }
}
