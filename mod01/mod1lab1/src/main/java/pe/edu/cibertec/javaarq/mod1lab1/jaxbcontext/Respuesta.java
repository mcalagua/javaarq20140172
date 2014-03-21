/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab1.jaxbcontext;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author user
 */
@XmlRootElement
@XmlType(propOrder = {"exito", "error", "datos"})
public class Respuesta {

    private boolean exito;
    private String error;
    private Datos datos;

    public Respuesta() {
    }

    public Respuesta(boolean exito, String error) {
        this.exito = exito;
        this.error = error;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

}
