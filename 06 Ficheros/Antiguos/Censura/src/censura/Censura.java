/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package censura;

/**
 *
 * @author alfredo
 */
public class Censura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Error: debe especificar el nombre del fichero en la línea de comandos.");
        } else {
            //Censurador.censurarCaracteres(args[0]);
            Censurador.censurarFrases(args[0]);
        }
    }

}
