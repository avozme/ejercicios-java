class Gato extends Animal {
    private int vidas;

    public Gato(String nombre, int edad) {
        super(nombre, edad);
        this.vidas = 7;
    }

    public void setVidas(int vidas) { this.vidas = vidas; }
    public int getVidas() { return this.vidas; }
    public void restarVida() {
        this.vidas--;
        if (this.vidas < 0)
            this.vidas = 0;
    }

}
