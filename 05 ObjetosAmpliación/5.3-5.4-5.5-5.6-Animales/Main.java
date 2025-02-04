public class Main {
    public static void main(String[] args) {

        Animal[] animales = new Animal[10];

        for (int i = 0; i < 5; i++) {
            System.out.println("Animal nº " + (i+1));
            System.out.print("  -Dime el tipo de animal (1 = perro, 2 = gato): ");
            int tipo = Integer.parseInt(System.console().readLine());
            System.out.print("  -Dime el nombre: ");
            String nombre = System.console().readLine();
            System.out.print("  -Dime la edad: ");
            int edad = Integer.parseInt(System.console().readLine());
            if (tipo == 1) {
                System.out.print("  -Dime la raza: ");
                String raza = System.console().readLine();
                animales[i] = (Animal)new Perro(nombre, edad, raza);
            }
            if (tipo == 2) {
                animales[i] = (Animal)new Gato(nombre, edad);
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("ANIMAL " + (i+1));
            System.out.println(" -Nombre: " + animales[i].getNombre());
            System.out.println(" -Edad: " + animales[i].getEdad());
            if (animales[i] instanceof Perro) {
                System.out.println(" -Raza: " + ((Perro)animales[i]).getRaza());
            }
            if (animales[i] instanceof Gato) {
                System.out.println(" -Vidas: " + ((Gato)animales[i]).getVidas());
            }

       }
    }
}
