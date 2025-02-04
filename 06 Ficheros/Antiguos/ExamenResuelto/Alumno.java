/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfebrero15;

/**
 *
 * @author alfredo
 */
public class Alumno {
    private int codigo;
    private String nombre, ap1, ap2, domic;
    
    public Alumno(int cod, String nombre, String ap1, String ap2, String domic) {
        this.codigo = cod;
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.domic = domic;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAp1() {
        return ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public String getDomic() {
        return domic;
    }
    
}
