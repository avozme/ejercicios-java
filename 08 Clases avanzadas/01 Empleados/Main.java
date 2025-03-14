public class Main {
    public static void main(String[] args) {
        // Creación de instancias de las subclases
        // (todas con el mismo sueldo base)
        Empleado e1 = new Encargado("Juan", 1200);
        Empleado e2 = new Programador("Ana", 1200);
        Empleado e3 = new Ordenanza("Luis", 1200);
        Empleado e4 = new ProgramadorJunior("Carlos", 1200);
        // La siguiente instrucción fallaría porque Empleado es una clase abstracta
        // Empleado e5 = new Empleado("Pedro", 1200);  

        // Mostramos los sueldos
        System.out.println("Sueldo de " + e1.getNombre() + ": " + e1.getSueldo());
        System.out.println("Sueldo de " + e2.getNombre() + ": " + e2.getSueldo());
        System.out.println("Sueldo de " + e3.getNombre() + ": " + e3.getSueldo());
        System.out.println("Sueldo de " + e4.getNombre() + ": " + e4.getSueldo());
    }
}
