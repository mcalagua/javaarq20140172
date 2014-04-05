/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mod1.jaxwshandler;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author carlos
 */
public class Nivel {

    private String id;
    private String nombre;
    private List<Ruta> rutas;

    public Nivel() {
    }

    public Nivel(String id, String nombre, List<Ruta> rutas) {
        this.id = id;
        this.nombre = nombre;
        this.rutas = rutas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "ruta")
    public List<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }

}
