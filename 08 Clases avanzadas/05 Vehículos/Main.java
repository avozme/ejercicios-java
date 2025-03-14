import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear vehículos
        Coche coche = new Coche("Toyota", "Corolla", 50, 7);
        Camion camion = new Camion("Volvo", "FH16", 200, 25, true);
        Bicicleta bicicleta = new Bicicleta("Trek", "FX3");

        // Crear lista de vehículos
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(coche);
        vehiculos.add(camion);
        vehiculos.add(bicicleta);

        // Mostrar información de vehículos
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
        }

        System.out.println("\nConduciendo los vehículos...");

        // Conducir los vehículos
        coche.conducir(100); // Conducir 100 km
        camion.conducir(150); // Conducir 150 km

        // Intentar conducir la bicicleta (no implementa Conducible)
        // bicicleta.conducir(50);  // Esto causaría un error de compilación porque Bicicleta no implementa Conducible

        System.out.println("\nEstado final de los vehículos:");

        // Mostrar información después de conducir
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
        }
    }
}
