/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mod1.jaxwshandler;

/**
 *
 * @author carlos
 */
public class Ruta {

    private String id;
    private String nombre;
    private String distancia;
    private String tipo;

    public Ruta() {
    }

    public Ruta(String id, String nombre, String distancia, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.distancia = distancia;
        this.tipo = tipo;
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

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
