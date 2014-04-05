/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mod1.jaxwshandlerclient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
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

            //ESTE FRAGMENTO DE CODIGO APAGA TODOS LOS HANDLERS
            final HandlerResolver hr = service.getHandlerResolver();
            service.setHandlerResolver(new HandlerResolver() {

                @Override
                public List<Handler> getHandlerChain(PortInfo portInfo) {
                    List<Handler> handlers = new ArrayList<>();
                    //Este handler corre antes que el chan por defecto
                    handlers.add(new NewLogicalHandler1());

                    //Podemos decidir agregar o no el chain por defecto
                    handlers.addAll(hr.getHandlerChain(portInfo));
                    
                    //Este handler corre despues que el chain por defecto
                    handlers.add(new NewLogicalHandler());
                    return handlers;
                }
            });

            pe.edu.cibertec.mod1.jaxwshandler.Entrenamiento port = service.getEntrenamientoPort();
            // TODO initialize WS operation arguments here
            java.lang.String latitud = "35";
            java.lang.String longitud = "87";
            // TODO process result here
            java.util.List<pe.edu.cibertec.mod1.jaxwshandler.Nivel> result = port.obtenerRutas(latitud, longitud);
            System.out.println("Result = " + result.size());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }

}
