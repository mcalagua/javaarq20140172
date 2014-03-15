/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab1;

import java.io.InputStream;
import java.io.PrintWriter;
import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author user
 */
public class JaxbSerializer implements Serializer {

    //El kaxb context es thread safe :)
    private JAXBContext context;
    //private ThreadLocal<Marshaller> marshaller;

    @PostConstruct
    public void create() {
        try {
            context = JAXBContext.newInstance(Profesor.class, Respuesta.class);
        } catch (JAXBException ex) {
            //FIXME crear un nuevo tipo de exception
            throw new RuntimeException(ex);
        }
    }

    public void marshall(Object ibj, PrintWriter out) {
        try {
            Marshaller m = context.createMarshaller();
            m.marshal(ibj, out);
        } catch (JAXBException ex) {
            //FIXME crear un nuevo tipo de exception
            throw new RuntimeException(ex);
        }
    }

    public Object unmarshall(InputStream in) {
        try {
            Unmarshaller u = context.createUnmarshaller();
            Object o = u.unmarshal(in);
            return o;
        } catch (JAXBException ex) {
            //FIXME crear un nuevo tipo de exception
            throw new RuntimeException(ex);
        }
    }

}
