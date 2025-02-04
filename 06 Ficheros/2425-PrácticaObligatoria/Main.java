
public class Main {
    public static void main(String[] args) {
        // Crear dispositivos
        // Dispositivo d1 = new Dispositivo("HP", "Lapbook G7", true);
        // Dispositivo d2 = new Dispositivo("LG", "HD6007", true);
        // Dispositivo d3 = new Dispositivo("Samsung", "Gorilla 2000", false);
        // d1.save();
        // d2.save();
        // d3.save();

        // Recuperar dispositivos
        int id = 2;
        Dispositivo d = new Dispositivo(id);
        d.load();
        System.out.println("DISPOSITIVO " + id);
        System.out.println("   -Marca:  " + d.getMarca());
        System.out.println("   -Modelo: " + d.getModelo());
        System.out.println("   -Tipo: " + d.getTipo());
    }

}