class Main {

	public static void main(String[] args) { 
        Profesor p = new Profesor();
        p.setNombre("Escolástico");
        p.setSueldo(1800);

        Rector r = new Rector();
        r.setNombre("Adelaida");
        r.setSueldo(1800);   // Le ponemos el mismo sueldo base que al profesor

        // Comprobamos si el sueldo del rector se ha incrementado un 25%
        System.out.println("Sueldo del profesor: " + p.getSueldo());
        System.out.println("Sueldo de la rectora: " + r.getSueldo());
	}
		
}