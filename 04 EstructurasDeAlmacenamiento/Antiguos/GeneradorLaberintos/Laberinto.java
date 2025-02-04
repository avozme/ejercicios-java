
public class Laberinto {

    int[][] laberinto;      // Array para almacenar el laberinto (puedes usar otra cosa en lugar de números enteros)
    int alto, ancho;        // Dimensiones del laberinto
    int filaEntrada;        // Ubicación de la entrada (la columna siempre es 0)
    int filaSalida;         // Ubicación de la salida (la columna siempre es ancho-1)
    final int PASILLO = 0;  // Valores para codificar el laberinto
    final int MURO = 1;
    final int ENTRADA = 2;
    final int SALIDA = 3;

    /**
     * Constructor. Crea un laberinto vacío de filas x columnas en una matriz de enteros.
     */
    public Laberinto(int filas, int columnas) {
        alto = filas;
        ancho = columnas;
        laberinto = new int[filas][columnas];
    }

    /**
     * Genera el laberinto con una entrada, una salida, muros y pasillos
     */
    public void generarLaberinto() {
        rellenarLaberinto(MURO);   // Rellenamos el laberinto con muros
        colocarEntradaYSalida();   // Colocamos aleatoriamente la entrada y la salida
        generarSolucion();         // Generamos un camino desde la entrada hasta la salida
        generarHuecos();           // Generamos algunos huecos al azar, para despistar
        // Creamos varios caminos más al azar, para despistar
        for (int i = 0; i < (ancho*alto)/20; i++) {
            generarPasilloAleatorio();
        }
    }

    /**
     * Muestra el laberinto por la consola de texto
     */
    public void mostrarLaberinto() {
        // Marco superior
        System.out.print("╔");
        for (int c = 0; c < ancho*2; c++) {
            System.out.print("═");
        }
        System.out.println("╗");
        // Laberinto
        for (int f = 0; f < alto; f++) {
            System.out.print("║");
            for (int c = 0; c < ancho; c++) {
                String s = "";    // Lo que vamos a mostrar por pantalla
                switch(laberinto[f][c]) {
                    case 0: s = "  "; break;
                    case 1: s = "▒▒"; break;
                    case 2: s = "»»"; break;
                    case 3: s = "»»"; break;
                }
                System.out.print(s);
            }
            System.out.println("║");
        }
        // Marco inferior
        System.out.print("╚");
        for (int c = 0; c < ancho*2; c++) {
            System.out.print("═");
        }
        System.out.println("╝");
    }

    /**
     * Rellena el laberinto con el tipo de elemento indicado como argumento
     */
    public void rellenarLaberinto(int valor) {
        for (int f = 0; f < alto; f++) {
            for (int c = 0; c < ancho; c++) {
                laberinto[f][c] = valor;
            }
        }
    }

    /**
     * Coloca aleatoriamente la entrada y la salida del laberinto
     */
    public void colocarEntradaYSalida() {
        // Colocamos la entrada en la columna izquierda, en una fila al azar
        filaEntrada = (int)(Math.random()*alto);
        laberinto[filaEntrada][0] = ENTRADA;

        // Colocamos la salida en la columna derecha, en una fila al azar
        filaSalida = (int)(Math.random()*alto);
        laberinto[filaSalida][ancho-1] = SALIDA;
    }

    /**
     * Genera un camino, en un laberinto repleto de muros, desde la entrada hasta la salida
     */
    public void generarSolucion() {
        // Creamos un primer pasillo justo a la derecha de la entrada
        int col = 1;
        int fila = filaEntrada;
        laberinto[fila][col] = PASILLO;
        // Creamos más pasillos hasta que lleguemos a la penúltima columna
        while (col < ancho-2) {
            int aleatorio = (int)(Math.random()*3);
            if (aleatorio == 0) {   // Ir a la derecha
                col++;
            }
            if (aleatorio == 1) {   // Ir arriba
                if (fila > 0) fila--;
            }
            if (aleatorio == 2) {   // Ir abajo
                if (fila < alto-1) fila++;
            }
            laberinto[fila][col] = PASILLO;
        }
        // Hemos llegado a la penúltima columna. 
        // Vamos a dirigirnos ahora hacia arriba o hacia abajo para llegar hasta la salida
        int direccion = 0;
        if (fila < filaSalida) direccion = 1;
        if (fila > filaSalida) direccion = -1;
        while (fila != filaSalida) {
            fila = fila + direccion;
            laberinto[fila][col] = PASILLO;
        }

    }

    /**
     * Genera algunos huecos al azar. El número de huecos será proporcional al tamaño del laberinto
     */
    public void generarHuecos() {
        int i = 0;
        while (i < (ancho*alto)/10) {
            int fila = (int)(Math.random()*alto-2)+1;
            int col = (int)(Math.random()*ancho-2)+1;
            if (laberinto[fila][col] == MURO) {
                laberinto[fila][col] = PASILLO;
                i++;
            }
        }

    }

    /**
     * Genera al azar un pasillo de longitud aleatoria
     */
    public void generarPasilloAleatorio() {
        int fila, col;
        // Primero buscamos una casilla donde ya haya pasillo, excluyendo los bordes,
        // para iniciar desde ahí nuestro pasillo aleatorio.
        do {
            fila = (int)(Math.random()*alto-2)+1;
            col = (int)(Math.random()*ancho-2)+1;
        }
        while (laberinto[fila][col] != PASILLO);
        // Ahora elegimos una longitud aleatoria para el falso pasillo
        // (la longitud dependerá del tamaño del laberinto)
        int longitud = (int)(Math.random()*(alto*ancho/10));
        // Por último, generamos los huecos moviéndonos al azar
        for (int i = 0; i < longitud; i++) {
            int nuevafila = fila;
            int nuevacol = col;
            int intentos = 0;
            // Vamos a elegir una dirección al azar, pero siempre a donde exista un muro
            do {
                int direccion = (int)(Math.random()*4);
                if (direccion == 0 && col > 0) nuevacol = col-1;          // Izquierda
                if (direccion == 1 && col < ancho-1) nuevacol = col+1;    // Derecha
                if (direccion == 2 && fila > 0) nuevafila = fila-1;       // Arriba
                if (direccion == 3 && fila < alto-1) nuevafila = fila+1;  // Abajo
                intentos++;
            }
            while (laberinto[nuevafila][nuevacol] != MURO && intentos < 4);
            if (intentos == 4) break;  // Estamos rodeados de pasillos, así que abortamos
            fila = nuevafila;
            col = nuevacol;
            laberinto[fila][col] = PASILLO;
        }
    }
}