/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab8;

import java.text.MessageFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author user
 */
//PATH es la parte de la URL que le corresponde a este servicio
//el path completo /<context-path>/<webresource-path>/noticias
@Path("noticias")
@Stateless
public class NoticiasResource {

    @PersistenceContext(unitName = "mod1lab8PU")
    EntityManager em;

    @PUT
    public void grabarNoticia(
            @FormParam("titulo") String titulo,
            @FormParam("noticia") String noticia) {
        em.persist(new Noticia(titulo, noticia));
    }

    @GET
    @Produces("text/html")
    public String leerNoticiasHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n<html><body><table>");
        for (Noticia noticia : findNoticias()) {
            sb.append(MessageFormat.format("<tr><td><a href=\"{0}\">{0}</a></td></tr>",
                    noticia.getTitulo(),
                    noticia.getNoticia()));
        }
        sb.append("</table></body></html>");
        return sb.toString();
    }

    @GET
    @Produces("application/json")
    public List<Noticia> leerNoticiasJSON() {
        return findNoticias();
    }

    @GET
    @Produces("application/xml")
    public Noticias leerNoticiasXML() {
        return new Noticias(findNoticias());
    }

    @GET
    @Produces("text/html")
    @Path("{idNoticia}")
    public String leerNoticia(@PathParam("idNoticia") String idNoticia) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n<html><body><table>");
        Noticia noticia = em.find(Noticia.class, idNoticia);
        sb.append(MessageFormat.format("<tr><th>{0}</th></tr><tr><td>{1}</td></tr>", noticia.getTitulo(), noticia.getNoticia()));
        sb.append("</table></body></html>");
        return sb.toString();
    }

    private List<Noticia> findNoticias() {
        return em.createQuery("Select o from Noticia o", Noticia.class).getResultList();
    }

}
