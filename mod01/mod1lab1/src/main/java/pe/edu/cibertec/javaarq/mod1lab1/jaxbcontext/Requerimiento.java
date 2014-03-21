/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab1.jaxbcontext;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@XmlRootElement
public class Requerimiento {

    private String operacion;
    private Datos datos;

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

}
