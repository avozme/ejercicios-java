class Caballo extends Animal {

    // Constructor
    public Caballo(String nombre, int edad) {
        super(nombre, edad, 1); // Un caballo tiene solo 1 vida
    }

    // Método para relinchar
    public void relinchar() {
        System.out.println("Hi-hi-hi");
    }

    // Sobrescribimos el método hacerRuido
    @Override
    public void hacerRuido() {
        relinchar();
    }

    // Sobrescribimos el método toString()
    @Override
    public String toString() {
        return "Caballo: " + getNombre() + ", Edad: " + getEdad() + ", Vidas: " + (getVidas() == 1 ? "Vivo" : "Muerto");
    }
}
