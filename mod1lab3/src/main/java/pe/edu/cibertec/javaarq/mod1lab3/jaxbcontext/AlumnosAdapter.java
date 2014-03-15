/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab3.jaxbcontext;

import java.util.List;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author user
 */
public class AlumnosAdapter extends XmlAdapter<Alumnos, List<Alumno>> {

    @Override
    public List<Alumno> unmarshal(Alumnos v) throws Exception {
        return v == null ? null : v.getValue();
    }

    @Override
    public Alumnos marshal(List<Alumno> v) throws Exception {
        return v == null ? null : new Alumnos(v);
    }

}
