public class MatrizTest {
    public static void main(String[] args) {
		int opc;
		Matriz matriz = new Matriz(4);

		// Menú de opciones
		do 
		{ 
			System.out.println("\n\nMENÚ PRINCIPAL"); 
			System.out.println("1. Mostrar matriz"); 
			System.out.println("2. Perímetro"); 
			System.out.println("3. Espiral"); 
			System.out.println("4. Salir"); 
			System.out.println();
			System.out.print("Introduzca opción (1-4): "); 
			opc = Integer.parseInt(System.console().readLine()); 
		
			switch(opc) {
				case 1: matriz.mostrar(); break; 
				case 2: matriz.perimetro(); break; 
				case 3: matriz.espiral(); break; 
			} 
		} 
		while (opc != 4); 

    }
} 

