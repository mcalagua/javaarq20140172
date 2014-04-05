/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mod1.jaxwshandlerclient;

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
        LogicalMessage msg = messageContext.getMessage();

        System.out.println("****************\nNewLogicalHandler.handleMessage Que corre despues!");

        return true;
    }

    public boolean handleFault(LogicalMessageContext messageContext) {
        return true;
    }

    public void close(MessageContext context) {
    }

}
