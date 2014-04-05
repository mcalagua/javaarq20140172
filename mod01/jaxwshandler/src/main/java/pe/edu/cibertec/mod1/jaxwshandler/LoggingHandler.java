/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.mod1.jaxwshandler;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.w3c.dom.Element;

/**
 *
 * @author carlos
 */
public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {

    public boolean handleMessage(SOAPMessageContext messageContext) {
        System.out.println("**************\nLoggingHandler");
        SOAPMessage msg = messageContext.getMessage();

        for (Iterator<AttachmentPart> it = msg.getAttachments(); it.hasNext();) {
            try {
                AttachmentPart ap = it.next();
                System.out.println(ap.getContentType());
                System.out.println(new String(ap.getRawContentBytes()));
            } catch (SOAPException ex) {
                Logger.getLogger(LoggingHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Element element = msg.getSOAPPart().getDocumentElement();

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t;
        try {
            t = tf.newTransformer();
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(LoggingHandler.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
        t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        t.setParameter("{http://xml.apache.org.xslt}indent-amount", "4");
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            t.transform(new DOMSource(element), new StreamResult(bos));
        } catch (TransformerException ex) {
            Logger.getLogger(LoggingHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("******************\n" + new String(bos.toByteArray()));

        return true;
    }

    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }

    public boolean handleFault(SOAPMessageContext messageContext) {
        System.out.println("*********************\nLoggingHandler.handleFault");
        SOAPMessage msg = messageContext.getMessage();
        Element element = msg.getSOAPPart().getDocumentElement();

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t;
        try {
            t = tf.newTransformer();
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(LoggingHandler.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
        t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        t.setParameter("{http://xml.apache.org.xslt}indent-amount", "4");
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            t.transform(new DOMSource(element), new StreamResult(bos));
        } catch (TransformerException ex) {
            Logger.getLogger(LoggingHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("******************\n" + new String(bos.toByteArray()));

        return true;
    }

    public void close(MessageContext context) {
    }

}
