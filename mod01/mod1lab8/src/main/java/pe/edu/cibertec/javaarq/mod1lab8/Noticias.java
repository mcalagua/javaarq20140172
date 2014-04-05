/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab8;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@XmlRootElement(name = "noticias")
public class Noticias {

    private List<Noticia> noticias;

    public Noticias() {
    }

    public Noticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    @XmlElement(name = "noticia")
    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

}
