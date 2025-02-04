/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author alfredo
 */
public class Familiar extends Contacto {
    String domicilio;
    
    Familiar(int id, String nombre, String ap1, String ap2, String domicilio) {
        super(id, nombre, ap1, ap2);
        this.domicilio = domicilio;
    }
    
    public String getDomicilio() { return domicilio; }
    
    public String toString() {
        return "FAMILIAR: " + super.toString() + " Domicilio: " + domicilio;
    }
}
