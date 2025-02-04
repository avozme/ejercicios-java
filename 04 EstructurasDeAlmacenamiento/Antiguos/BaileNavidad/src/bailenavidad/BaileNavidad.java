
package bailenavidad;

/**
 * Esta clase asigna aleatoriamente parejas de baile para las tres escuelas de magia de Harry Potter y El Cáliz de Fuego
 * Se supone que hay un número igual de estudiantes en cada escuela, y que las parejas tienen que ser de estudiantes de diferentes escuelas.
 */
public class BaileNavidad {

    static Estudiante[] hogwarts;       // Lista de estudiantes de Hogwarts
    static Estudiante[] beauxbatons;    // Lista de estudiantes de Beauxbatons
    static Estudiante[] durmstrang;     // Lista de estudiantes de Durmstrang
    
    static int[] seleccionadosHogwarts;     // Listas de estudiantes ya seleccionados para el baile en cada escuela
    static int[] seleccionadosBeauxbatons;
    static int[] seleccionadosDurmstrang;
    
    static final int NUM_ESTUDIANTES = 20;  // Número de estudiantes en cada escuela
    static final int NUM_PAREJAS = NUM_ESTUDIANTES + NUM_ESTUDIANTES / 2;   // Número de parejas de baile
    
    /**
     * Crea las listas de estudiantes de cada escuela y, a partir de ellas, las parejas de baile, mostrando el resultado por consola
     * @param args Argumentos de la línea de comandos (sin uso) 
     */
    public static void main(String[] args) {
        crearListasEstudiantes();
        Estudiante[][] listaParejas = crearListaParejas();
        mostrar(listaParejas);
    }
    
    /**
     * Crea aleatoriamente las parejas de baile
     * @return La lista de parejas de baile como un array bidimensional. La columna [0] contiene a los chicos y la [1] las chicas. 
     */
    public static Estudiante[][] crearListaParejas() {
        // Creamos la lista de parejas
        Estudiante[][] listaParejas = new Estudiante[NUM_PAREJAS][2];
        
        Estudiante chico = null, chica = null;
        String colegio = "Hogwarts";    // Valor inicial para el colegio
        
        // Rellenamos la lista con estudiantes elegidos al azar
        for (int i = 0; i < NUM_PAREJAS; i++) {
            // Seleccionamos al chico
            chico = seleccionarEstudiante(colegio, 'H');
            // Cambiamos de colegio, para que las parejas sean de estudiantes de colegios distintos
            if (colegio.equals("Hogwarts")) colegio = "Durmstrang";
            else if (colegio.equals("Durmstrang")) colegio = "Beauxbatons";
            else colegio = "Hogwarts";
            
            // Seleccionamos a la chica
            chica = seleccionarEstudiante(colegio, 'M');
            // Cambiamos de colegio, para que las parejas sean de estudiantes de colegios distintos
            if (colegio.equals("Hogwarts")) colegio = "Durmstrang";
            else if (colegio.equals("Durmstrang")) colegio = "Beauxbatons";
            else colegio = "Hogwarts";

            // Asignamos al chico y a la chica a la lista de parejas
            listaParejas[i][0] = chico;
            listaParejas[i][1] = chica;
        }
        
        return listaParejas;
    }
    
    /**
     * Selecciona al azar un estudiante de la lista de estudiantes especificada y con el sexo indicado
     * @param colegio Colegio del estudiante
     * @param sexo Sexo del estudiante
     * @return El estudiante seleccionado
     */ 
    public static Estudiante seleccionarEstudiante(String colegio, char sexo) {
        boolean correcto;
        int n;
        Estudiante estudiante = null;
        
        do {
            correcto = true;
            // Elegimos un estudiante al azar
            n = (int)(NUM_ESTUDIANTES * Math.random());
            
            if (colegio.equals("Hogwarts")) {
                // Comprobamos si el sexo del estudiante n es el adecuado y si no está ya seleccionado
                if (hogwarts[n].getSexo() != sexo || seleccionadosHogwarts[n] == 1) correcto = false;
                else {
                    // El estudiante n es válido. Lo guardamos en la variable estudiante y lo marcamos como ya seleccionado.
                    estudiante = hogwarts[n];
                    seleccionadosHogwarts[n] = 1;
                }
            }
            if (colegio.equals("Beauxbatons")) {
                // Comprobamos si el sexo del estudiante n es el adecuado y si no está ya seleccionado
                if (beauxbatons[n].getSexo() != sexo || seleccionadosBeauxbatons[n] == 1) correcto = false;
                else {
                    // El estudiante n es válido. Lo guardamos en la variable estudiante y lo marcamos como ya seleccionado.
                    estudiante = beauxbatons[n];
                    seleccionadosBeauxbatons[n] = 1;
                }
            }
            if (colegio.equals("Durmstrang")) {
                // Comprobamos si el sexo del estudiante n es el adecuado y si no está ya seleccionado
                if (durmstrang[n].getSexo() != sexo || seleccionadosDurmstrang[n] == 1) correcto = false;
                else {
                    // El estudiante n es válido. Lo guardamos en la variable estudiante y lo marcamos como ya seleccionado.
                    estudiante = durmstrang[n];
                    seleccionadosDurmstrang[n] = 1;
                }
            }
        }
        while (!correcto);
        
        return estudiante;
    }
    
    /**
     * Muestra la lista de parejas de baile por consola
     * @param listaParejas Array bidimensional con la lista de parejas
     */
    public static void mostrar(Estudiante[][] listaParejas) {
        for (int i = 0; i < NUM_PAREJAS; i++) {
            System.out.printf("Pareja %2d: %s (%s)(%c) - %s (%s)(%c)\n", i+1, listaParejas[i][0].getNombre(), listaParejas[i][0].getColegio(), listaParejas[i][0].getSexo(),
                                                                              listaParejas[i][1].getNombre(), listaParejas[i][1].getColegio(), listaParejas[i][1].getSexo());
        }
    }
    
    /**
     * Crea las listas de estudiantes de cada colegio.
     * Este método debería tomar los datos de un fichero o de una base de datos... pero aún no sabemos hacer tal cosa,
     * así que lo teclearemos todo en plan artesanal.
     */
    public static void crearListasEstudiantes() {
        // Creamos los arrays de estudiantes
        hogwarts = new Estudiante[NUM_ESTUDIANTES];
        beauxbatons = new Estudiante[NUM_ESTUDIANTES];
        durmstrang = new Estudiante[NUM_ESTUDIANTES];
        
        // Creamos los arrays de estudiantes seleccionados para el baile
        seleccionadosHogwarts = new int[NUM_ESTUDIANTES];
        seleccionadosBeauxbatons = new int[NUM_ESTUDIANTES];
        seleccionadosDurmstrang = new int[NUM_ESTUDIANTES];
        
        // Creamos los estudiantes (esta es la informacion que podría tomarse de un fichero, o de una base de datos, etc)
        hogwarts[0] = new Estudiante("Harry Potter", 'H', "Hogwarts");
        hogwarts[1] = new Estudiante("Ron Weasley", 'H', "Hogwarts");
        hogwarts[2] = new Estudiante("Leville Longbottom", 'H', "Hogwarts");
        hogwarts[3] = new Estudiante("Fred Weasley", 'H', "Hogwarts");
        hogwarts[4] = new Estudiante("George Weasley", 'H', "Hogwarts");
        hogwarts[5] = new Estudiante("Draco Malfoy", 'H', "Hogwarts");
        hogwarts[6] = new Estudiante("Seamus Finnigan", 'H', "Hogwarts");
        hogwarts[7] = new Estudiante("Dean Thomas", 'H', "Hogwarts");
        hogwarts[8] = new Estudiante("Lee Jordan", 'H', "Hogwarts");
        hogwarts[9] = new Estudiante("Cedric Diggory", 'H', "Hogwarts");
        hogwarts[10] = new Estudiante("Hermione Granger", 'M', "Hogwarts");
        hogwarts[11] = new Estudiante("Ginny Weasley", 'M', "Hogwarts");
        hogwarts[12] = new Estudiante("Luna Lovegood", 'M', "Hogwarts");
        hogwarts[13] = new Estudiante("Lavender Brown", 'M', "Hogwarts");
        hogwarts[14] = new Estudiante("Parvati Patil", 'M', "Hogwarts");
        hogwarts[15] = new Estudiante("Hanna Abbot", 'M', "Hogwarts");
        hogwarts[16] = new Estudiante("Angelina Johnson", 'M', "Hogwarts");
        hogwarts[17] = new Estudiante("Pansy Parkinson", 'M', "Hogwarts");
        hogwarts[18] = new Estudiante("Katie Bell", 'M', "Hogwarts");
        hogwarts[19] = new Estudiante("Cho Chang", 'M', "Hogwarts");

        beauxbatons[0] = new Estudiante("Damien Bordeau", 'H', "Beauxbatons");
        beauxbatons[1] = new Estudiante("Didier Girardon", 'H', "Beauxbatons");
        beauxbatons[2] = new Estudiante("Edouard Pinaud", 'H', "Beauxbatons");
        beauxbatons[3] = new Estudiante("Fabien Rousseau", 'H', "Beauxbatons");
        beauxbatons[4] = new Estudiante("François Eluchans", 'H', "Beauxbatons");
        beauxbatons[5] = new Estudiante("Gabriel Lombard", 'H', "Beauxbatons");
        beauxbatons[6] = new Estudiante("Gaston Abbadie", 'H', "Beauxbatons");
        beauxbatons[7] = new Estudiante("Adolphe Barraud", 'H', "Beauxbatons");
        beauxbatons[8] = new Estudiante("Bastian Briand", 'H', "Beauxbatons");
        beauxbatons[9] = new Estudiante("Colin Camus", 'H', "Beauxbatons");
        beauxbatons[10] = new Estudiante("Fleur Delacour", 'M', "Beauxbatons");
        beauxbatons[11] = new Estudiante("Catherine Leduc", 'M', "Beauxbatons");
        beauxbatons[12] = new Estudiante("Audrey Vien", 'M', "Beauxbatons");
        beauxbatons[13] = new Estudiante("Bérénice Dugès", 'M', "Beauxbatons");
        beauxbatons[14] = new Estudiante("Laure Champollion", 'M', "Beauxbatons");
        beauxbatons[15] = new Estudiante("Léonore Chifflet", 'M', "Beauxbatons");
        beauxbatons[16] = new Estudiante("Lucette Toussaint", 'M', "Beauxbatons");
        beauxbatons[17] = new Estudiante("Magadlène Lemond", 'M', "Beauxbatons");
        beauxbatons[18] = new Estudiante("Nélie Levallois", 'M', "Beauxbatons");
        beauxbatons[19] = new Estudiante("Nicole Fontaine", 'M', "Beauxbatons");

        durmstrang[0] = new Estudiante("Viktor Krum", 'H', "Durmstrang");
        durmstrang[1] = new Estudiante("Andrei Boyanov", 'H', "Durmstrang");
        durmstrang[2] = new Estudiante("Anton Chilikov", 'H', "Durmstrang");
        durmstrang[3] = new Estudiante("Boris Andreev", 'H', "Durmstrang");
        durmstrang[4] = new Estudiante("Damyan Mihov", 'H', "Durmstrang");
        durmstrang[5] = new Estudiante("Dragomir Nikolaev", 'H', "Durmstrang");
        durmstrang[6] = new Estudiante("Emil Petrov", 'H', "Durmstrang");
        durmstrang[7] = new Estudiante("Georgi Maksimov", 'H', "Durmstrang");
        durmstrang[8] = new Estudiante("Milen Ivov", 'H', "Durmstrang");
        durmstrang[9] = new Estudiante("Pavel Kaloyanchev", 'H', "Durmstrang");
        durmstrang[10] = new Estudiante("Anka Lazarov", 'M', "Durmstrang");
        durmstrang[11] = new Estudiante("Dana Marinov", 'M', "Durmstrang");
        durmstrang[12] = new Estudiante("Donka Minkov", 'M', "Durmstrang");
        durmstrang[13] = new Estudiante("Emiliya Hristov", 'M', "Durmstrang");
        durmstrang[14] = new Estudiante("Irina Vanev", 'M', "Durmstrang");
        durmstrang[15] = new Estudiante("Ivana Viktorov", 'M', "Durmstrang");
        durmstrang[16] = new Estudiante("Katerina Vasilev", 'M', "Durmstrang");
        durmstrang[17] = new Estudiante("Nevelka Popov", 'M', "Durmstrang");
        durmstrang[18] = new Estudiante("Nikol Zahariev", 'M', "Durmstrang");
        durmstrang[19] = new Estudiante("Olga Vodenicharov", 'M', "Durmstrang");
      
        // Inicializamos a 0 las listas de estudiantes seleccionados para el baile
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            seleccionadosHogwarts[i] = 0;
            seleccionadosBeauxbatons[i] = 0;
            seleccionadosDurmstrang[i] = 0;
        }
    }
        
    
    
}
