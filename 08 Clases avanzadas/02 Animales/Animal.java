abstract class Animal {
    private String nombre;
    private int edad;
    private int vidas; // 0 o 1 para animales, 7 para gatos

    // Constructor
    public Animal(String nombre, int edad, int vidas) {
        this.nombre = nombre;
        this.edad = edad;
        this.vidas = vidas;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    // Métodos para morir y resucitar
    public void morir() {
        this.vidas = 0;
    }

    public void resucitar() {
        this.vidas = 1;
    }

    // Método abstracto para hacer ruido
    public abstract void hacerRuido();

    // Método toString() que será sobrescrito en cada subclase
    public abstract String toString();
}
