import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Lista de animales
        ArrayList<Animal> animales = new ArrayList<>();
        
        // Creamos algunos animales al azar
        animales.add(new Perro("Rex", 5));
        animales.add(new Gato("Miau", 3));
        animales.add(new Caballo("Relincho", 7));
        animales.add(new Gato("Whiskers", 2));
        animales.add(new Perro("Luna", 4));

        // Mostramos la información de cada animal y hacemos que "hablen"
        System.out.println("LOS ANIMALES HABLANDO:");
        for (Animal animal : animales) {
            System.out.println(animal.toString());
            animal.hacerRuido();
            System.out.println(); 
        }

        // Simulamos muerte y resurrección de algunos animales
        System.out.println("SIMULACIÓN DE MUERTE Y RESURRECCIÓN:");
        for (int i = 0; i < 100; i ++) {
            // Elegimos un animal al azar
            int n = (int)(Math.random() * animales.size());
            Animal animal = animales.get(n);
            // Elegimos una acción al azar (resucitar o morir)
            int accion = (int)(Math.random() * 2);
            if (accion == 0) {   // Morir
                animal.morir();
                System.out.println(animal.getNombre() + " ha muerto. Vidas restantes: " + animal.getVidas());
            } else {             // Resucitar
                animal.resucitar();
                System.out.println(animal.getNombre() + " ha resucitado. Vidas restantes: " + animal.getVidas());   
            }
            System.out.println(animal.toString());
            System.out.println();
        }
    }
}
