class Coche extends Vehiculo implements Conducible {

    public Coche(String marca, String modelo, double cantidadCombustible, double consumo) {
        super(marca, modelo, cantidadCombustible, consumo);
    }

    // Implementación del método abstracto getConsumo
    @Override
    public double getConsumo() {
        return super.getConsumo(); // El consumo del coche es el que se asigna directamente
    }

    @Override
    public void setConsumo(double consumo) {
        super.setConsumo(consumo);
    }

    // Implementación del método conducir de la interfaz Conducible
    @Override
    public void conducir(int km) {
        double combustibleConsumido = (getConsumo() * km) / 100.0;
        setCantidadCombustible(getCantidadCombustible() - combustibleConsumido);
        System.out.println("Coche conducido " + km + " km. Combustible restante: " + getCantidadCombustible() + " litros.");
    }

    // Sobrescritura del método toString()
    @Override
    public String toString() {
        return "Coche [Marca=" + getMarca() + ", Modelo=" + getModelo() + ", Combustible=" + getCantidadCombustible() + " litros, Consumo=" + getConsumo() + " l/100km]";
    }
}
