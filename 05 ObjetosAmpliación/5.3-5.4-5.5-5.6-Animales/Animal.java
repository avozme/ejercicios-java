class Animal {
    private String nombre;
    private int edad;
    private static int contadorDeAnimales = 0;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        contadorDeAnimales++;
    }

    public Animal(Animal a) {
        this.nombre = a.getNombre();
        this.edad = a.getEdad();
        contadorDeAnimales++;
    }

    public String getNombre() { return this.nombre; }
    public void setNombre(String n) { this.nombre = n; }
    public int getEdad() { return this.edad; }
    public void setEdad(int n) { this.edad = n; }
    public static int getContadorDeAnimales() { return contadorDeAnimales; }

    public Animal clone() {
        return new Animal(this.nombre, this.edad);
    }

    public boolean equals(Animal a) {
        return (this.nombre.equals(a.getNombre())) && 
               (a.getEdad() == this.edad);
    }
}