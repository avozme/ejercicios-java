abstract class Conjunto {

    protected Object[] conjunto;
    protected int cont;
    protected final int TAM = 100;  // Tamaño máximo del conjunto
    
    public Conjunto() {
      conjunto = new Object[TAM];
      cont = 0;
      for (int i = 0; i < TAM; i++) {
           conjunto[i] = null;
      }
    }  

    public int insertarElemento(Object e) {
      int res = 1;
      if (cont == TAM) res = 0;
      else {
        conjunto[cont] = e;
        cont++;
      }
      return res;
    }
    
    
    
    public void vaciarConjunto() {
      cont = 0;
      for (int i = 0; i < TAM; i++) {
            conjunto[i] = null;
      }
    }
    
    public int contarElementos() {
      return cont;
    }
   
    public void borrarElemento(Object e) {
      for (int i = 0; i < cont; i++) {
            if (conjunto[i].equals(e)) conjunto[i] = null;
      }
    }
        
    public boolean esta(Object e) {
      boolean encontrado = false;
      for (int i = 0; i < cont; i++) {
            if (conjunto[i].equals(e)) encontrado = true;
      }
      return encontrado;
    }

/*
    public abstract void borrarElemento(Object e);
 
    public abstract boolean esta(Object e);
*/
}
