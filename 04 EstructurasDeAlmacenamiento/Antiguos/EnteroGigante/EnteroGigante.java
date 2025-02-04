class EnteroGigante {

    private int[] numero;
    private final int MAXIMO = 50;
    
    public EnteroGigante() {
      numero = new int[MAXIMO];
      for (int i = 0; i < MAXIMO; i++) {
	numero[i] = 0;
      }
    }
    
    
    public void leer(String n) {
      int contArray = MAXIMO-1;
      for (int contString = n.length()-1; contString >= 0; contString--) {
	numero[contArray] = n.charAt(contString) - 48;
	contArray--;
      }
    }
    
    public void imprimir() {
      for (int i = 0; i < MAXIMO; i++) {
	System.out.print(numero[i]);
      }
      System.out.println();
    }
    
    public EnteroGigante sumar(EnteroGigante eg) {
      EnteroGigante egSuma = new EnteroGigante();
      int acarreo = 0;
      
      for (int i = MAXIMO-1; i >= 0; i--) {
	int s = numero[i] + eg.getDigito(i) + acarreo;
	if (s >= 10) {
	    egSuma.setDigito(s-10, i);
	    acarreo = 1;
	}
	else {
	    egSuma.setDigito(s, i);
	    acarreo = 0;
	}
      }
      
      return egSuma;
    }
    
    
    public int getDigito(int posicion) {
	return numero[posicion];
    }

    public void setDigito(int valor, int posicion) {
	numero[posicion] = valor;
    }


}