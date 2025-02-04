 /**
  * Clase TestShape
  * Prueba la jerarquía de clases con raíz en Shape
  */
class TestShape {

	public static void main(String[] args) {
	
		Shape shape1, shape2;
		Circle circle1, circle2;
		Rectangle rect1, rect2;
		Square square1, square2;

		// Creamos una figura con cada constructor y llamamos a toString()
		shape1 = new Shape();
		System.out.println(shape1.toString());

		circle1 = new Circle();
		System.out.println(circle1.toString());

		rect1 = new Rectangle();
		System.out.println(rect1.toString());

		square1 = new Square();
		System.out.println(square1.toString());

		System.out.println("\n\n\n");

		// Probamos algunos métodos sobre los objetos anteriores y volvemos a llamar a toString()
  		// para comprobar que los atributos han cambiado como se esperaba
		shape1.setColor("white");
		System.out.println(shape1.toString());

		circle1.setRadius(2.5);
		System.out.println("El área del círculo es " + circle1.getArea());
		System.out.println(circle1.toString());

		rect1.setLength(3.0);
		System.out.println("El perímetro del rectángulo es " + rect1.getPerimeter());
		System.out.println(rect1.toString());

		square1.setWidth(5.1);
		System.out.println("La base del cuadrado es " + square1.getLength() + " y su altura es " + square1.getWidth());
		System.out.println("El área del cuadrado es " + square1.getArea());
		System.out.println(square1.toString());

		System.out.println("\n\n\n");

		
		// Redoble de tambores.....
		// Probamos ahora algunas conversiones de tipo
		shape2 = (Shape)circle1;
		//circle2 = (Circle)shape1;  // **Error**
		circle2 = (Circle)shape2;    // Esto no es un error (proque shape2 es en realidad un círculo)
		rect2 = (Rectangle)square1;
		square2 = (Square)shape1;  // Y esto, ¿funcionará? ¿Qué crees?

		System.out.println(shape2.toString());
		System.out.println("Mi área es " + ((Circle)shape2).getArea());
		System.out.println("Mi color es " + shape2.getColor());
		System.out.println(circle2.toString());
		System.out.println(rect2.toString());
		System.out.println(square2.toString());
	
		 
	}	
}
