class Encargado extends Empleado {

    public Encargado(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    @Override
    public double getSueldo() {
        return getSueldoBase() * 1.5; // 150% del sueldoBase
    }
}
