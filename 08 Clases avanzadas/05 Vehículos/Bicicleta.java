class Bicicleta extends Vehiculo {

    public Bicicleta(String marca, String modelo) {
        super(marca, modelo, 0, 0); // Una bicicleta no tiene combustible ni consumo
    }

    // Implementación del método getConsumo()
    @Override
    public double getConsumo() {
        return 0; // Una bicicleta no consume combustible
    }

    @Override
    public void setConsumo(double consumo) {
        // No aplica
    }

    // Sobrescritura del método toString()
    @Override
    public String toString() {
        return "Bicicleta [Marca=" + getMarca() + ", Modelo=" + getModelo() + "]";
    }
}
