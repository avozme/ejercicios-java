class Gato extends Animal {

    // Constructor sobrescrito
    public Gato(String nombre, int edad) {
        super(nombre, edad, 7); // Un gato comienza con 7 vidas
    }

    // Método para maullar
    public void maullar() {
        System.out.println("Miau, miau");
    }

    // Sobrescribimos el método morir
    @Override
    public void morir() {
        setVidas(getVidas() - 1); // Restamos una vida
    }

    // Sobrescribimos el método resucitar
    @Override
    public void resucitar() {
        if (getVidas() <= 0) setVidas(7);
    }

    // Sobrescribimos el método hacerRuido
    @Override
    public void hacerRuido() {
        maullar();
    }

    // Sobrescribimos el método toString()
    @Override
    public String toString() {
        return "Gato: " + getNombre() + ", Edad: " + getEdad() + ", Vidas: " + getVidas();
    }
}
