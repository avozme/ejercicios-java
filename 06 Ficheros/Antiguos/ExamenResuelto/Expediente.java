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
public class Expediente {
    protected int codigoAlumno;
    protected int codigoExpediente;
    String anoAcademico;
    String asignatura;

    public Expediente(int codigoAlumno, int codigoExpediente, String anoAcademico, String asignatura) {
        this.codigoAlumno = codigoAlumno;
        this.codigoExpediente = codigoExpediente;
        this.anoAcademico = anoAcademico;
        this.asignatura = asignatura;
    }

    public int getCodigoAlumno() {
        return codigoAlumno;
    }

    public int getCodigoExpediente() {
        return codigoExpediente;
    }

    public String getAnoAcademico() {
        return anoAcademico;
    }

    public String getAsignatura() {
        return asignatura;
    }
    
    public void mostrarInfo() {
        System.out.println("Asignatura: " + asignatura + " - Curso:" + anoAcademico);
    }
  
}
