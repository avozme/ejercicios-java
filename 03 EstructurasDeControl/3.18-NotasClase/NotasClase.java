class NotasClase {

  public static void main(String[] args) {
	final int NUM_ALUMNOS = 30;   // Esto es una constante
	int i, nota;
	int aprobados = 0; 
	int suspensos = 0;

	for (i = 1; i <= NUM_ALUMNOS; i++) {
		System.out.print("Introduce la calificación (alumno/a " + i + " de " + NUM_ALUMNOS + "): ");
		do {
		        nota = Integer.parseInt(System.console().readLine());
		        if ((nota < 0) || (nota > 10)) {
			  		System.out.println("El número debe de estar entre 0 y 10. Introduzcalo de nuevo:");
				}
		}
		while ((nota < 0) || (nota > 10));
		if (nota >= 5) aprobados++;
		else suspensos++;	
    }
    System.out.println("Número de suspensos: " + suspensos);	
    System.out.println("Número de aprobados: " + aprobados);	
  }
}
