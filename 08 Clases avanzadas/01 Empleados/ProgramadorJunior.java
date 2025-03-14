class ProgramadorJunior extends Programador {

    public ProgramadorJunior(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    @Override
    public double getSueldo() {
        return getSueldoBase() * 0.8; // 80% del sueldoBase
    }
}
