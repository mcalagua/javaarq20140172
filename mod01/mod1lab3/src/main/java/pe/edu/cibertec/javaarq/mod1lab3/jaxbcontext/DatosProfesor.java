/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab3.jaxbcontext;

/**
 *
 * @author user
 */
public class DatosProfesor extends Datos {

    private Profesor profesor;

    public DatosProfesor() {
    }

    public DatosProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

}
