/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mod1.jaxwshandlerclient;

import java.io.ByteArrayOutputStream;
import java.rmi.server.LoaderHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import pe.edu.cibertec.mod1.jaxwshandler.Nivel;
import pe.edu.cibertec.mod1.jaxwshandler.ObjectFactory;
import pe.edu.cibertec.mod1.jaxwshandler.ObtenerRutas;
import pe.edu.cibertec.mod1.jaxwshandler.ObtenerRutasResponse;
import pe.edu.cibertec.mod1.jaxwshandler.Ruta;

/**
 *
 * @author user
 */
public class FooLogicalHandler implements LogicalHandler<LogicalMessageContext> {

    @Override
    public boolean handleMessage(LogicalMessageContext messageContext) {

        System.out.println("**************\nLogical Handler");

        LogicalMessage msg = messageContext.getMessage();
        try {
            JAXBContext jbc = JAXBContext.newInstance(
                    ObjectFactory.class,
                    Nivel.class,
                    ObtenerRutas.class,
                    ObtenerRutasResponse.class,
                    Ruta.class);

            JAXBElement o = (JAXBElement) jbc.createUnmarshaller().unmarshal(msg.getPayload());

            if (o.getValue() instanceof ObtenerRutas) {
                ObtenerRutas or = (ObtenerRutas) o.getValue();
                or.setLatitud("-12");
                or.setLongitud("-76");
            } else if (o.getValue() instanceof ObtenerRutasResponse) {
                ObtenerRutasResponse or = (ObtenerRutasResponse) o.getValue();
                System.out.println("Cantidad de elementos: " + or.getReturn().size());
                or.getReturn().clear();
            }

            msg.setPayload(o, jbc);

        } catch (JAXBException ex) {
            Logger.getLogger(FooLogicalHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    @Override
    public boolean handleFault(LogicalMessageContext messageContext) {
        return true;
    }

    @Override
    public void close(MessageContext context) {
    }

}
