/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bailenavidad;

/**
 *
 * @author alfredo
 */
public class Estudiante  {
    private String nombre;
    private char sexo;
    private String colegio;

    public Estudiante(String nombre, char sexo, String colegio) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.colegio = colegio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

  
    
    
}
