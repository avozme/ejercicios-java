class Ordenanza extends Empleado {

    public Ordenanza(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    @Override
    public double getSueldo() {
        return getSueldoBase(); // El sueldoBase es exactamente lo que se cobra
    }
}
