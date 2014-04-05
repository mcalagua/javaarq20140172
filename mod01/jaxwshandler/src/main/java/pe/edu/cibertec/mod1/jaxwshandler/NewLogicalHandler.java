/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mod1.jaxwshandler;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author user
 */
public class NewLogicalHandler implements LogicalHandler<LogicalMessageContext> {

    public boolean handleMessage(LogicalMessageContext messageContext) {
        System.out.println("*********************\nNewLogicalHandler.handleMessage");

        LogicalMessage msg = messageContext.getMessage();
        final Source payload = msg.getPayload();

        if (payload instanceof DOMSource) {
            //TODO verificar si el DOMSource es de tipo Fault, si es asi reemplazar por lista vacia
        }

        System.out.println(payload);

        return true;
    }

    public boolean handleFault(LogicalMessageContext messageContext) {
        System.out.println("*********************\nNewLogicalHandler.handleFault");

        return true;
    }

    public void close(MessageContext context) {
    }

}
