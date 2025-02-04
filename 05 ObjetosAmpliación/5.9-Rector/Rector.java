class Rector extends Profesor {

	public double getSueldo() { 
		double sueldoProfesor = super.getSueldo();
		double sueldoRector = sueldoProfesor + sueldoProfesor * 0.25;
		return sueldoRector; 
	}
		
}