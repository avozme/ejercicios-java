import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Creamos una lista para almacenar las ventas
        ArrayList<Venta> ventas = new ArrayList<>();
        
        // Leemos el archivo de ventas y lo guardamos en el array
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ventas.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(";");
                String producto = datos[0];
                int unidadesVendidas = Integer.parseInt(datos[1]);
                double precioPorUnidad = Double.parseDouble(datos[2].replace(",", "."));

                // Creamos un objeto Venta y añadirlo a la lista
                ventas.add(new Venta(producto, unidadesVendidas, precioPorUnidad));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Realizamos los cálculos utilizando programación funcional
        calcularVentas(ventas);
    }

    private static void calcularVentas(ArrayList<Venta> ventas) {
        // 1. Total de ventas
        double totalVentas = ventas.stream()
                .mapToDouble(Venta::calcularTotal)
                .sum();
        System.out.println("Total de ventas: " + totalVentas + " €");

        // 2. Producto más vendido (por unidades totales)
        Map<String, Integer> totalUnidadesPorProducto = new HashMap<>();
        ventas.forEach(venta -> totalUnidadesPorProducto.merge(venta.getProducto(), venta.getUnidadesVendidas(), Integer::sum));

        String productoMasVendido = totalUnidadesPorProducto.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Ninguno");
        System.out.println("Producto más vendido: " + productoMasVendido);

        // 3. Mejor venta (venta con mayor cantidad de dinero generado)
        Venta mejorVenta = ventas.stream()
                .max(Comparator.comparingDouble(Venta::calcularTotal))
                .orElse(null);
        if (mejorVenta != null) {
            System.out.println("Mejor venta: " + mejorVenta.getProducto() + " - " + mejorVenta.calcularTotal() + " €");
        }

        // 4. Cantidad de productos vendidos por tipo
        System.out.println("Cantidad de productos vendidos por tipo:");
        totalUnidadesPorProducto.forEach((producto, totalUnidades) ->
                System.out.println(producto + ": " + totalUnidades + " unidades"));
    }
}
