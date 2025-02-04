 /**
  * Clase Square (cuadrado)
  */
class Square extends Rectangle {

	public Square() {
		super();
	}

	public Square(double side) {
		super(side, side);
	}

	public Square(double side, String c, boolean f) {
		super(side, side, c, f);
	}

	public void setWidth(double w) {
		super.setWidth(w);
		super.setLength(w);
	}

	public void setLength(double l) {
		super.setWidth(l);
		super.setLength(l);
	}

	public String toString() {
		return "Soy un cuadrado de lado " + super.getWidth() + " y esta es mi superclase: " + super.toString();
	}
	
}
