// Juego de la ruleta.
// Versión 1: código monolítico en una sola clase y un solo método

import java.util.Scanner;

class RuletaMonolitico {

  public static void main(String[] args) {
    int dineroRestante, dineroApuesta, numeroApuesta, colorApuesta, numero, color;
    Scanner sc = new Scanner(System.in);

    dineroRestante = 100;    // Cantidad inicial de dinero

    do {
      // Preguntamos el número al que se quiere apostar
      do {
        System.out.print("Elige un número (1-20): ");
        numeroApuesta = sc.nextInt();
      }
      while ((numeroApuesta < 1) || (numeroApuesta > 20));

      // Preguntamos el color al que se quiere apostar
      do {
        System.out.print("Elige un color (1 = rojo, 2 = negro): ");
        colorApuesta = sc.nextInt();
      }
      while ((colorApuesta < 1) || (colorApuesta > 2));

      // Preguntamos la cantidad de dinero que se quiere apostar
      do {
        System.out.print("¿Cuánto quieres apostar? (1 - " + dineroRestante + "): ");
        dineroApuesta = sc.nextInt();
      }
      while ((dineroApuesta < 1) || (dineroApuesta > dineroRestante));

      // Simulamos el lanzamiento de la ruleta
      System.out.println("Voy a lanzar la ruleta...");
      numero = (int)((Math.random()*20) + 1);
      color  = (int)((Math.random()*2) + 1);
      System.out.print("Ha salido: " + numero + " ");
      if (color == 1) 
        System.out.println("rojo"); 
      else 
        System.out.println("negro");

      // Comprobamos el resultado
      if ((numero == numeroApuesta) && (color == colorApuesta)) {
        System.out.println("ENHORABUENA: has ganado " + dineroApuesta * 10 + " euros");
        dineroRestante = dineroRestante + (dineroApuesta * 10);
      }
      else {
        System.out.println("Lo siento, has perdido " + dineroApuesta + " euros");
        dineroRestante = dineroRestante - dineroApuesta;
      }
      System.out.println("Ahora te quedan " + dineroRestante + " euros");
    }
    while (dineroRestante > 0);
  } 
}