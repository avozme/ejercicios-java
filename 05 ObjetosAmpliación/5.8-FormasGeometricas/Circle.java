 /**
  * Clase Circle (círculo)
  */
class Circle extends Shape {

	private double radius;

	public Circle() {
		radius = 1.0;
	}

	public Circle(double r) {
		radius = r;
	}

	public Circle(double r, String c, boolean f) {
		super(c, f);
		radius = r;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double r) {
		radius = r;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	public String toString() {
		return "Soy un círculo de radio " + radius + " y esta es mi superclase: " + super.toString();
	}
	
}
