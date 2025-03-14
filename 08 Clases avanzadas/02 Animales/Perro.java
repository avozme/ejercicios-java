class Perro extends Animal {

    // Constructor
    public Perro(String nombre, int edad) {
        super(nombre, edad, 1); // Un perro tiene solo 1 vida
    }

    // Método para ladrar
    public void ladrar() {
        System.out.println("Guau, guau");
    }

    // Sobrescribimos el método hacerRuido
    @Override
    public void hacerRuido() {
        ladrar();
    }

    // Sobrescribimos el método toString()
    @Override
    public String toString() {
        return "Perro: " + getNombre() + ", Edad: " + getEdad() + ", Vidas: " + (getVidas() == 1 ? "Vivo" : "Muerto");
    }
}
