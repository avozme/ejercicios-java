abstract class Vehiculo {
    private String marca;
    private String modelo;
    private double cantidadCombustible; // En litros
    private double consumo; // Consumo en litros por cada 100 km

    // Constructor
    public Vehiculo(String marca, String modelo, double cantidadCombustible, double consumo) {
        this.marca = marca;
        this.modelo = modelo;
        this.cantidadCombustible = cantidadCombustible;
        this.consumo = consumo;
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCantidadCombustible() {
        return cantidadCombustible;
    }

    public void setCantidadCombustible(double cantidadCombustible) {
        this.cantidadCombustible = cantidadCombustible;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    // Método abstracto toString
    @Override
    public abstract String toString();
}
