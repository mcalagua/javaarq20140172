/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mod1.jaxwshandlerclient;

import javax.xml.ws.WebServiceRef;
import pe.edu.cibertec.mod1.jaxwshandler.Entrenamiento_Service;

/**
 *
 * @author carlos
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try { // Call Web Service Operation
            Entrenamiento_Service service = new Entrenamiento_Service();
            pe.edu.cibertec.mod1.jaxwshandler.Entrenamiento port = service.getEntrenamientoPort();
            // TODO initialize WS operation arguments here
            java.lang.String latitud = "";
            java.lang.String longitud = "";
            // TODO process result here
            java.util.List<pe.edu.cibertec.mod1.jaxwshandler.Nivel> result = port.obtenerRutas(latitud, longitud);
            System.out.println("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }

}
