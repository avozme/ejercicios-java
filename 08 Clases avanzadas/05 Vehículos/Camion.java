class Camion extends Vehiculo implements Conducible {
    private boolean carga;

    public Camion(String marca, String modelo, double cantidadCombustible, double consumo, boolean carga) {
        super(marca, modelo, cantidadCombustible, consumo);
        this.carga = carga;
    }

    // Implementación del método getConsumo()
    @Override
    public double getConsumo() {
        if (carga) {
            return consumo * 1.5; // Si el camión está cargado, el consumo aumenta un 50%
        } else {
            return consumo;
        }
    }

    @Override
    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    // Implementación del método conducir de la interfaz Conducible
    @Override
    public void conducir(int km) {
        double combustibleConsumido = (getConsumo() * km) / 100.0;
        setCantidadCombustible(getCantidadCombustible() - combustibleConsumido);
        System.out.println("Camión conducido " + km + " km. Combustible restante: " + getCantidadCombustible() + " litros.");
    }

    // Sobrescritura del método toString()
    @Override
    public String toString() {
        return "Camión [Marca=" + getMarca() + ", Modelo=" + getModelo() + ", Combustible=" + getCantidadCombustible() + " litros, Consumo=" + getConsumo() + " l/100km, Carga=" + (carga ? "Cargado" : "Vacío") + "]";
    }
}
