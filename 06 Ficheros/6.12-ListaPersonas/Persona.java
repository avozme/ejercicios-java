import java.io.*;

class Persona {
    public String nombre;
    public int edad, estatura, peso;

    public Persona(String nombre, int edad, int estatura, int peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
        this.peso = peso;
    }

    /**
     * Método principal. En este método se lanzan varios test sobre la lista de
     * personas. Descomenta el que quieras probar
     * y vuelve a compilar y a lanzar el programa (son incompatibles entre sí, así
     * que solo debes descomentar uno cada vez)
     */
    public static void main(String[] args) {
        Persona[] listaPersonas = new Persona[100];

        // Test 1: crear personas y guardar en archivo de texto
        // generarPersonasAleatorias(listaPersonas);
        // guardarEnArchivoTexto(listaPersonas, "personas.txt");
        // System.out.println("ARCHIVO DE TEXTO GENERADO");

        // Test 2: crear personas y guardar en archivo binario
        // generarPersonasAleatorias(listaPersonas);
        // guardarEnArchivoBinario(listaPersonas, "personas.dat");
        // System.out.println("ARCHIVO DE BINARIO GENERADO");

        // Test 3: cargar datos desde archivo de texto
        // cargarDesdeArchivoTexto(listaPersonas, "personas.txt");
        // System.out.println("DATOS EXTRAÍDOS DEL ARCHIVO DE TEXTO");
        // mostrarPersonas(listaPersonas);

        // Test 4: cargar datos desde archivo binario
        // cargarDesdeArchivoBinario(listaPersonas, "personas.dat");
        // System.out.println("DATOS EXTRAÍDOS DEL ARCHIVO BINARIO");
        // mostrarPersonas(listaPersonas);

    }

    /**
     * Este método genera una lista de 100 personas aleatoriamente a partir de dos
     * listas de 20 apellidos y 20 nombres cada una
     * 
     * @param listaPersonas La lista de personas aleatorias
     */
    public static void generarPersonasAleatorias(Persona[] listaPersonas) {
        // Lista de nombres
        String[] nombres = {
                "José", "Sara", "Carlos", "Ana", "Pedro",
                "Marta", "David", "Laura", "Juan", "Lucía",
                "Pablo", "Elena", "Tomás", "Beatriz", "Ricardo",
                "Raquel", "Iván", "Carmen", "Quiang", "Susana",
                "Liam", "Fatima", "Irina", "Mohamed", "Franz"
        };

        // Lista de apellidos
        String[] apellidos = {
                "Antúnez", "Muñoz", "García", "López", "Sánchez",
                "Ruiz", "Pérez", "Martínez", "Díaz", "Gómez",
                "Hernández", "Martín", "Jiménez", "Vázquez", "Moreno",
                "Alvarez", "Ramírez", "Castro", "Wang", "Fernández",
                "Smith", "Alaoui", "Ivanov", "Bennani", "Müller"
        };

        // Mezclamos aleatoriamente las dos listas para generar 100 nombres al azar
        for (int i = 0; i < listaPersonas.length; i++) {
            // Generamos el nombre de la persona al azar
            int nombreIndice = (int) (Math.random() * nombres.length);
            int apellidoIndice = (int) (Math.random() * apellidos.length);
            String nombreCompleto = nombres[nombreIndice] + " " + apellidos[apellidoIndice];

            // Generamos edad aleatoria entre 18 y 100
            int edadAleatoria = 18 + (int) (Math.random() * 72);

            // Generamos altura aleatoria entre 140 y 200
            int alturaAleatoria = 140 + (int) (Math.random() * 60);

            // Generamos peso aleatorio entre 50 y 150
            int pesoAleatorio = 50 + (int) (Math.random() * 150);

            // Asignamos el nombre y la edad al array de personas
            listaPersonas[i] = new Persona(nombreCompleto, edadAleatoria, alturaAleatoria, pesoAleatorio);
        }
    }

    /**
     * Este método envía el array de personas a un fichero de texto usando FileWriter
     * 
     * @param listaPersonas El array de personas
     * @param nombreArchivo El nombre del archivo de texto
     */
    public static void guardarEnArchivoTexto(Persona[] listaPersonas, String nombreArchivo) {
        try {
            FileWriter fw = new FileWriter(nombreArchivo);
            for (int i = 0; i < listaPersonas.length; i++) {
                Persona p = listaPersonas[i];
                fw.write(p.nombre + ";" + p.edad + ";" + p.estatura + ";" + p.peso + "\n"); // Separamos los campos por un punto y coma
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero: " + e.getMessage());
        }
    }

    /**
     * Este método recupera la información del archivo de texto con FileReader y la
     * carga en el array
     * 
     * @param listaPersonas El array de personas
     * @param nombreArchivo El nombre del archivo de texto
     */
    public static void cargarDesdeArchivoTexto(Persona[] listaPersonas, String nombreArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null && i < listaPersonas.length) {
                String[] datos = linea.split(";"); // El punto y coma es el separador de los campos
                String nombre = datos[0];
                int edad = Integer.parseInt(datos[1]);
                int altura = Integer.parseInt(datos[2]);
                int peso = Integer.parseInt(datos[3]);
                listaPersonas[i] = new Persona(nombre, edad, altura, peso);
                i++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

    }

    /**
     * Este método enviar la información del array a un archivo binario usando
     * RandomAccessFile
     * 
     * @param listaPersonas El array de personas
     * @param nombreArchivo El nombre del archivo de texto
     */
    public static void guardarEnArchivoBinario(Persona[] listaPersonas, String nombreArchivo) {
        try {
            RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw");
            for (int i = 0; i < listaPersonas.length; i++) {
                Persona p = listaPersonas[i];
                // Como queremos registros de longitud fija, vamos a asegurarnos de que 
                // el campo nombre ocupe exactamente 100 bytes
                long posIni = raf.getFilePointer();   // Posición ANTES de escribir el nombre en el fichero
                raf.writeUTF(p.nombre);
                long posFin = raf.getFilePointer();   // Posición DESPUÉS de escribir el nombre en el fichero
                long bytesEscritos = posFin - posIni; // Estos son los bytes que ha ocupado el nombre en el fichero
                // Vamos a completar con ceros hasta 100 bytes
                for (int j = 0; j < 100-bytesEscritos; j++) {
                    raf.writeByte(0);
                }
                // Por último, escribimos los tres enteros (estos siempre ocupan lo mismo)
                raf.writeInt(p.edad);
                raf.writeInt(p.estatura);
                raf.writeInt(p.peso);
            }
            raf.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero: " + e.getMessage());
        }
    }

    /**
     * Este método recupera la información del archivo binario con RandomAccessFile
     * y la carga en el array
     * 
     * @param listaPersonas El array de personas
     * @param nombreArchivo El nombre del archivo de texto
     */
    public static void cargarDesdeArchivoBinario(Persona[] listaPersonas, String nombreArchivo) {
        try {
            RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r");
            int i = 0;
            while (raf.getFilePointer() < raf.length() && i < listaPersonas.length) {
                // Usamos registros de longitud fija. Cada nombre ocupa exactamente 100 bytes.
                long posIni = raf.getFilePointer();  // Posición ANTES de leer el nombre
                String nombre = raf.readUTF();
                raf.seek(posIni + 100);              // Nos desplazamos 100 bytes más allá del nombre
                int edad = raf.readInt();
                int altura = raf.readInt();
                int peso = raf.readInt();
                listaPersonas[i] = new Persona(nombre, edad, altura, peso);
                i++;
            }
            raf.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero: " + e.getMessage());
        }
    }

    /**
     * Este método muestra por consola la lista de personas
     * 
     * @param listaPersonas El array con la lista de personas
     */
    public static void mostrarPersonas(Persona[] listaPersonas) {
        for (int i = 0; i < listaPersonas.length; i++) {
            if (listaPersonas[i] != null) {
                System.out.println("PERSONA nº " + (i + 1));
                System.out.println("  -Nombre: " + listaPersonas[i].nombre);
                System.out.println("  -Edad:   " + listaPersonas[i].edad + " años");
                System.out.println("  -Altura: " + listaPersonas[i].estatura + " cm");
                System.out.println("  -Peso:   " + listaPersonas[i].peso + " kg");
                System.out.println();

            }
        }
    }

}
