public class Venta {
    private String producto;
    private int unidadesVendidas;
    private double precioPorUnidad;

    // Constructor
    public Venta(String producto, int unidadesVendidas, double precioPorUnidad) {
        this.producto = producto;
        this.unidadesVendidas = unidadesVendidas;
        this.precioPorUnidad = precioPorUnidad;
    }

    // Getters
    public String getProducto() {
        return producto;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    // Método para calcular el total de dinero de la venta
    public double calcularTotal() {
        return unidadesVendidas * precioPorUnidad;
    }
}
