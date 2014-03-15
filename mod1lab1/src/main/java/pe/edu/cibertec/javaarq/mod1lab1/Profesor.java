/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab1;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author user
 */
@XmlRootElement
@XmlType(propOrder = {"codigo", "nombre", "apellido", "fechaDeIngreso", "alumnos"})
@XmlSeeAlso({Alumnos.class})
public class Profesor {

    private Integer codigo;
    private String nombre;
    private String apellido;
    private Date fechaDeIngreso;
    private List<Alumno> alumnos;

    /**
     * @return the codigo
     */
    @XmlAttribute(name = "id")
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the fechaDeIngreso
     */
    @XmlElement(name = "ingreso")
    public Date getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    /**
     * @param fechaDeIngreso the fechaDeIngreso to set
     */
    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    @XmlJavaTypeAdapter(AlumnosAdapter.class)
    @XmlElement(name = "alumnos")
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

}
