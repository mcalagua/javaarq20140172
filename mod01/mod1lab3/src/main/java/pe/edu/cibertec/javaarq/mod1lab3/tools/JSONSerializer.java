/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab3.tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author user
 */
@JSON
public class JSONSerializer implements Serializer {

    @Override
    public void marshall(Object ibj, PrintWriter out) {
        try {
            ObjectMapper om = new ObjectMapper();
            om.writeValue(out, ibj);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Object unmarshall(InputStream in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
