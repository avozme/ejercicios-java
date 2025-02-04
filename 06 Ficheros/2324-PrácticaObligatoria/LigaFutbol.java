/** 
 * Clase LigaFutbo
 * 
 * Esta clase contiene el interfaz de usuario de la aplicación.
 * Cada funcionalidad se ha programado en un método intependiente.
 */
import java.util.Scanner;

public class LigaFutbol{

  private static Scanner sc = new Scanner(System.in);
  private static FicheroFutbol fichDatos = new FicheroFutbol();

  /**
   * Método principal. Contiene el bucle principal de la aplicación y el menú de opciones.
   */
  public static void main(String args[]) {

      int opcion = 0;
      do {
        borrarPantalla();
        System.out.println("MENÚ DE OPCIONES");
        System.out.println("  1. Añadir equipo");
        System.out.println("  2. Mostrar todos los equipos");
        System.out.println("  3. Buscar equipo");
        System.out.println("  4. Borrar equipo");
        System.out.println("  5. Modificar equipo");
        System.out.println("  6. Ordenar fichero");
        System.out.println("  0. Salir del programa");

        opcion = leerEntero();  // Lee un número entero por teclado

        switch (opcion) {
          case 1:  anadirEquipo(); 
                   break;
          case 2:  mostrarEquipos(); 
                   break;
          case 3:  buscarEquipo(); 
                   break;
          case 4:  borrarEquipo(); 
                   break;
          case 5:  modificarEquipo(); 
                   break;
          case 6:  ordenarFichero(); 
                   break;
          case 0:  System.out.println("Gracias por usar nuestro programa");
                   break;
          default: System.out.println("Opción no reconocida");
        }
        esperarIntro();
      }
      while (opcion != 0);
  }

  /**
   * Pregunta al usuario todos los datos necesarios para añadir un equipo nuevo.
   * Luego pide a FicheroFutbol que almacene esos datos en el fichero de datos.
   */
  public static void anadirEquipo() {
    int pj, pg, pp, pe, puntos;  // Partidos jugados, ganados, perdidos y empatados
    
    borrarPantalla();
    System.out.println("Introduce los datos del nuevo equipo");

    // Nombre del equipo
    System.out.print("Nombre: ");
    String nombreEq = sc.nextLine();

    // Partidos jugados
    System.out.print("Nº de partidos jugados: ");
    pj = leerEntero();

    // Partidos ganados (no pueden ser más que los partidos jugados)
    do {
      System.out.print("Nº de partidos ganados: (1-" + pj + ")");
      pg = leerEntero();
    }
    while ((pg <  1) || (pg > pj));

    // Partidos empatados (no pueden ser más que los partidos jugados menos los ganados)
    do {
      System.out.print("Nº de partidos ganados: (1-" + (pj-pg) + ")");
      pe = leerEntero();
    }
    while ((pe <  1) || (pe > (pj-pg)));
    sc.nextLine(); // Limpia el buffer del teclado

    // Partidos perdidos (no se preguntan sino que se calculan)
    pp = pj - pg - pe;
    
    // Puntos. Se calcula como partGanados * 3 + partEmpatados
    puntos = pg * 3 + pe;

    // Escribimos todos los datos en el fichero
    int result = fichDatos.save(nombreEq, pj, pg, pe, pp, puntos);
    if (result == 0) {
      System.out.println("Equipo guardado con éxito");
    } 
    else {
      System.out.println("Error al guardar el equipo");
    }
  }

  /**
   * Muestra por la consola todos los equipos que hay en el fichero de datos.
   */
  public static void mostrarEquipos() {
    String[] listaEquipos = new String[fichDatos.MAX_EQUIPOS];
    listaEquipos = fichDatos.getAll();      // Recuperamos la lista de equipos
    borrarPantalla();
    if (listaEquipos == null) {
      System.out.println("No se puede mostrar la lista de equipos");
    }
    else {
        System.out.println("+-------------------------+---+---+---+---+----+");
        System.out.println("|Equipo                   |JUG|GAN|EMP|PER|PUNT|");
        System.out.println("+-------------------------+---+---+---+---+----+");
        for (int i = 0; i < listaEquipos.length; i++) {
        if (listaEquipos[i] != null) {
          String[] equipo = listaEquipos[i].split(";");
          System.out.printf("|%-25s|%3s|%3s|%3s|%3s|%4s|\n", equipo[0], equipo[1], equipo[2], equipo[3], equipo[4], equipo[5]);
        }
      }
      System.out.println("+-------------------------+---+---+---+---+----+");
    }
  }


  /**
   * Busca un equipo por nombre y muestra sus datos en la consola
   */
  public static void buscarEquipo() {
    borrarPantalla();
    System.out.println("Introduce el nombre del equipo:");
    String nombreEq = sc.nextLine();
    String datosEquipoStr = fichDatos.get(nombreEq);
    if (datosEquipoStr == null) {
      System.out.println("No encuentro ese equipo!");
    }
    else {
      borrarPantalla();
      String[] datosEquipo = datosEquipoStr.split(";");
      System.out.println("NOMBRE DEL EQUIPO: " + datosEquipo[0]);
      System.out.println(" -Partidos jugados: " + datosEquipo[1]);
      System.out.println(" -Partidos ganados: " + datosEquipo[2]);
      System.out.println(" -Partidos empatados: " + datosEquipo[3]);
      System.out.println(" -Partidos perdidos: " + datosEquipo[4]);
      System.out.println("PUNTOS: " + datosEquipo[5]);
    }

  }

  /**
   * Busca un equipo y lo borra
   */
  public static void borrarEquipo() {
    borrarPantalla();
    System.out.println("Introduce el nombre del equipo que quieres borrar:");
    String nombreEq = sc.nextLine();
    int resultado = fichDatos.delete(nombreEq);
    if (resultado == -1) {
      System.out.println("No encuentro ese equipo!");
    }
    else {
      System.out.println("Equipo borrado con éxito");
    }
  }
  
  /**
   * Busca un equipo y permite modificar cualquiera de sus campos.
   * Muestra la información actual que existe en ese campo. Si el usuario pulsa Intro, se conserva el valor actual.
   * Si el usuario teclea alguna otra cosa, el valor actual se sustituye por lo que se haya tecleado.
   */
  public static void modificarEquipo() {
    borrarPantalla();
    System.out.println("Introduce el nombre del equipo que quieres modificar:");
    String nombreEq = sc.nextLine();
    String datosEquipo = fichDatos.get(nombreEq);
    int posicionEquipo = fichDatos.getPos(nombreEq);

    if ((datosEquipo == null) || (posicionEquipo == -1)) {
      System.out.println("No encuentro ese equipo!");
    }
    else {
      String[] datosAntiguos = datosEquipo.split(";");   // Obtenemos los datos actuales del equipo separados en strings diferentes
      String entrada = null;
      int pj, pg, pp, pe, puntos;  // Nuevos datos: partidos jugados, ganados, perdidos y empatados
      System.out.println("Introduce los datos modificados (pulsa Intro para no cambiarlos):");

      // Nombre del equipo
      System.out.print("Nombre (" + datosAntiguos[0] + "): ");
      nombreEq = sc.nextLine();
      if (nombreEq.equals("")) nombreEq = datosAntiguos[0];   // No cambiamos los datos antiguos

      // Partidos jugados
      System.out.print("Nº de partidos jugados (" + datosAntiguos[1] + "): ");
      entrada = sc.nextLine();
      if (entrada.equals("")) pj = Integer.parseInt(datosAntiguos[1]);  // No cambiamos los datos antiguos
      else pj = Integer.parseInt(entrada);

      // Partidos ganados (no pueden ser más que los partidos jugados)
      do {
        System.out.print("Nº de partidos ganados (" + datosAntiguos[2] + "): (1-" + pj + ")");
        entrada = sc.nextLine();
        if (entrada.equals("")) pg = Integer.parseInt(datosAntiguos[2]);  // No cambiamos los datos antiguos
        else pg = Integer.parseInt(entrada);
      }
      while ((pg <  1) || (pg > pj));

      // Partidos empatados (no pueden ser más que los partidos jugados menos los ganados)
      do {
        System.out.print("Nº de partidos empatados (" + datosAntiguos[3] + "): (1-" + (pj-pg) + ")");
        entrada = sc.nextLine();
        if (entrada.equals("")) pe = Integer.parseInt(datosAntiguos[3]);  // No cambiamos los datos antiguos
        else pe = Integer.parseInt(entrada);
      }
      while ((pe <  1) || (pe > (pj-pg)));

      // Partidos perdidos (no se preguntan sino que se calculan)
      pp = pj - pg - pe;
      
      // Puntos. Se calcula como partGanados * 3 + partEmpatados
      puntos = pg * 3 + pe;

      // Enviamos los datos nuevos para que se escriban en el fichero
      int result = fichDatos.update(posicionEquipo, nombreEq, pj, pg, pe, pp, puntos);
      if (result == -1) {
        System.out.println("Ha ocurrido un error al actualizar el fichero");
      }
      else {
        System.out.println("Datos actualizados con éxito");
      }
    }

  }
  
  /**
   * Ordena el fichero de datos por orden decreciente de puntuación
   */
  public static void ordenarFichero() {
    int result = fichDatos.sort();
    if (result == 0) {
      System.out.println("Fichero ordenado con éxito");
    }
    else {
      System.out.println("Error al ordenar el fichero");
    }
  }

  /**
   * Lee un número entero positivo por teclado, asegurándose de que el usuario no teclea caracteres alfabéticos.
   * Devuelve el número tecleado o -1 en caso de error.
   */
  public static int leerEntero() {
    int numero = 0;
    boolean error = false;

    do {
      try {
        numero = sc.nextInt();
        error = false;
      }
      catch (Exception e) {
        System.out.println("Por favor, teclea solo números");
        error = true;
      }
      sc.nextLine();  // Limpia el buffer de teclado
    }
    while (error);
    return numero;
  }

  /**
   * Borra la pantalla de la consola de texto
   */
  public static void borrarPantalla() {
    for (int i = 0; i < 100; i++) {
      System.out.println();
    }
  }

  /**
   * Espera a que el usuario pulse Intro antes de continuar
   */
  public static void esperarIntro() {
    System.out.println("Pulse Intro para continuar...");
    sc.nextLine();
  }
}
