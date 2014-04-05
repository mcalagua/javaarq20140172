/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mod1.jaxwshandler;

import java.util.Arrays;
import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author carlos
 */
@WebService(serviceName = "entrenamiento")
@HandlerChain(file = "entrenamiento_handler.xml")
public class Entrenamiento {

    /**
     * This is a sample web service operation
     *
     * @param latitud
     * @param longitud
     * @return
     */
    @WebMethod(operationName = "obtenerRutas")
    public List<Nivel> hello(
            @WebParam(name = "latitud") String latitud,
            @WebParam(name = "longitud") String longitud
    ) {
        //        return Arrays.asList(
        //                new Nivel("1", "Avanzado",
        //                        Arrays.asList(
        //                                new Ruta("1", "Ruta 1", "3.5 KM", "Quema Grasa")
        //                        )
        //                )
        //        );
        throw new RuntimeException();
    }
}
