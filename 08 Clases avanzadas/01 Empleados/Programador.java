class Programador extends Empleado {

    public Programador(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    @Override
    public double getSueldo() {
        return getSueldoBase() * 1.1; // 110% del sueldoBase
    }
}
