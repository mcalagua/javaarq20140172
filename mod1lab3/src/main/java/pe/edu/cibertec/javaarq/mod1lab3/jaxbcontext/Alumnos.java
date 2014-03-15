/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab3.jaxbcontext;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author user
 */
public class Alumnos {

    private List<Alumno> value;

    public Alumnos() {
    }

    public Alumnos(List<Alumno> value) {
        this.value = value;
    }

    @XmlElement(name = "alumno")
    public List<Alumno> getValue() {
        return value;
    }

    public void setValue(List<Alumno> value) {
        this.value = value;
    }

}
