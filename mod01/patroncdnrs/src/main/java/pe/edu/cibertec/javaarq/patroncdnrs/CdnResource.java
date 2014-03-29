/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.patroncdnrs;

import java.net.URI;
import java.text.MessageFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.CookieParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author user
 */
@Path("cdn")
@Stateless
public class CdnResource {

    //Si queremos usar la sesion debemos hacerlo a través del HTTPServletRequest
    //Para lograrlo requerimos una referencia inyectada desde CDI
    @Inject
    HttpServletRequest request;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CdnResource
     */
    public CdnResource() {
    }

    /**
     * Retrieves representation of an instance of
     * pe.edu.cibertec.javaarq.patroncdnrs.CdnResource
     *
     * @param resource
     * @param type
     * @param version
     * @return an instance of java.lang.String
     */
    @GET
    /* Cuando defino un PATH y en lugar de usar un nombre utilizo la notación:
     * {nombre} estoy definiendo una variable!
     * 
     */
    @Path("{r}")
    public Response getResource(
            /* La forma de leer una variable del path que esta definida entre
             * llaves es usando PathParam, en este caso resource tomara el valor
             * de la varialble r del path
             */
            @PathParam("r") String resource,
            /* Para leer parámetros que son part del query string o del message
             * body (solo si el request type es for url encoded. Se usa:
             * QueryParam (del query string)
             * FormaParam (del message body)
             */
            @QueryParam("t") String type,
            @QueryParam("v") String version) {
        //TODO Esto debería integrarse a un controlador
        String url = null;
        if ("jquery".equals(resource)) {
            url = MessageFormat.format("http://code.jquery.com/jquery-{0}.{1}", version, type);
        }
        if ("logo".equals(resource)) {
            url = "http://img2.wikia.nocookie.net/__cb20100516075848/logopedia/images/2/25/BMW_logo.png";
        }

        if (url == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.temporaryRedirect(URI.create(url)).build();
        }

    }

    //Personalización del response
    @GET
    @Path("otro/path")
    public Response getResponse(@CookieParam("cibercookie") String cookie, @HeaderParam("ciberheader") String header) {

        context.getPathSegments();

        Response.ResponseBuilder builder = Response.ok();
        //Cambiamos el mime type de la respuesta
        builder.type("text/cibertec");

        //Cambiamos el cuerpo de la respuesta
        builder.entity("Cibertec DAT: cuerpo de prueba");

        //cambiamos el codigo del mensaje
        builder.status(200);

        //definir cookies
        builder.cookie(new NewCookie("cibercookie", new Date().toString()));

        //definir headeres
        //lo normal es definir el expires header!
        builder.header("ciberheader", "20140172");

        return builder.build();
    }

}
