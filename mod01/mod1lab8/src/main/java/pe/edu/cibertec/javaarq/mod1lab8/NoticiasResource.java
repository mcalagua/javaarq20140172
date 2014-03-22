/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab8;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
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
public class NoticiasResource {

    private static Map<String, String> noticias = new HashMap<String, String>();

    @Context
    private UriInfo context;

    @PUT
    public void grabarNoticia(@FormParam("noticia") String noticia) {
        noticias.put("" + new Date().getTime(), noticia);
    }

    @GET
    @Produces("text/html")
    public String leerNoticias() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><table>");
        for (Map.Entry<String, String> e : noticias.entrySet()) {
            sb.append(MessageFormat.format("<tr><td>{0}</td><td>{1}</td></tr>", e.getKey(), e.getValue()));
        }
        sb.append("</table></body></html>");
        return sb.toString();
    }

    @GET
    @Produces("text/html")
    @Path("{idNoticia}")
    public String leerNoticia(@PathParam("idNoticia") String idNoticia) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><table>");
        sb.append(MessageFormat.format("<td>{0}</td><td>{1}</td>", idNoticia, noticias.get(idNoticia)));
        sb.append("</table></body></html>");
        return sb.toString();
    }

}
