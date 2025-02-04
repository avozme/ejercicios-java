 /**
  * Clase Rectangle (rectángulo)
  */
class Rectangle extends Shape {

	private double width;
	private double length;

	public Rectangle() {
		width = 1.0;
		length = 1.0;
	}

	public Rectangle(double w, double l) {
		width = w;
		length = l;
	}

	public Rectangle(double w, double l, String c, boolean f) {
		super(c, f);
		width = w;
		length = l;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double w) {
		width = w;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double l) {
		length = l;
	}


	public double getArea() {
		return width * length;
	}

	public double getPerimeter() {
		return 2 * width + 2 * length;
	}

	public String toString() {
		return "Soy un rectángulo de base " + width + " y altura " + length + " y esta es mi superclase: " + super.toString();
	}
	
}
