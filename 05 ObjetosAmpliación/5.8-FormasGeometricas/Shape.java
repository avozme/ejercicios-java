 /**
  * Clase Shape (figura geométrica genérica)
  */
public class Shape {

	private String color;
	private boolean filled;

	/**
	 * Constructor sin parámetros.
	 * Inicializa el color a verde y el atributo filled a true.
	 */
	public Shape() {
	  color = "red";
	  filled = true;
	}

	/**
	 * Constructor con parámetros.
	 *
	 * @param c El color de la figura.
	 * @throws f Indica si la figura está rellena (true) o no (false).
	 */
	public Shape(String c, boolean f) {
		color = c;
		filled = f;
	}

	/**
	 * Determina el color de la figura.
	 *
	 * @return El color de la figura.
	 */
	public String getColor() {
		return this.color;
	}
	
	/**
	 * Establece el color de la figura.
	 *
	 * @param c El color de la figura.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Determina si la figura está o no rellena.
	 *
	 * @return True si la figura está rellena, false en caso contrario.
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * Cambia el valor del relleno de la figura.
	 *
	 * @param f True para que la figura pase a estar rellena, false para que no lo esté.
	 */
	public void setFilled(boolean f) {
		filled = f;
	}

	/**
	 * Devuelve una cadena descriptiva del objeto actual.
	 * {@inheritDoc}
	 * @return La cadena con la descripción del objeto.
	 */
	public String toString() {
		String s = "Soy una figura de color " + color + " y ";
		if (filled) s = s + "estoy rellena";
		else s = s + "no estoy rellena";
		return s;
	}
 
}
