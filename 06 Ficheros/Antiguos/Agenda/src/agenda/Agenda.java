/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;
import java.io.*;

/**
 *
 * @author alfredo
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String opc = null;
        do {
            System.out.println("1. Nuevo contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Listar agenda");
            System.out.println("4. Borrar contacto");
            System.out.println("S. Salir");
            try {
                BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                opc = buff.readLine();
            }
            catch (Exception e) { e.printStackTrace(); }
            if (opc.equals("1")) {
                nuevoContacto();
            }
            if (opc.equals("2")) {
                buscarContacto();
            }
            if (opc.equals("3")) {
                listarContactos();
            }
            if (opc.equals("4")) {
                borrarContacto();
            }
        }
        while (!opc.equals("S"));
        
        
    }
    
    public static void nuevoContacto() {
        Contacto c1 = new Contacto(1, "Luis", "Pérez", "Padilla");
        Contacto c2 = new Contacto(2, "Marta", "Gutiérrez", "Muñoz");
        Familiar c3 = new Familiar(3, "Javier", "Martín", "Zamora", "C/ Jón 15");
        try {
            FileOutputStream fos = new FileOutputStream("agenda.dat", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(c1);
            oos.close();
            fos.close();
            
            fos = new FileOutputStream("agenda.dat", true);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(c2);
            oos.close();
            fos.close();
            
            fos = new FileOutputStream("agenda.dat", true);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(c3);
            oos.close();
            fos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void buscarContacto() {
        System.out.println("Opción en desarollo...");
        
    }
    
    public static void listarContactos() {
        Contacto c = null;
        try {
            FileInputStream fis;            
            int i = 0;
            fis = new FileInputStream("agenda.dat");
            while (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                c = (Contacto)ois.readObject();
                System.out.println(c.toString());
                i++;
            }
            fis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void borrarContacto() {
        System.out.println("Opción en desarollo...");
        
    }


}
