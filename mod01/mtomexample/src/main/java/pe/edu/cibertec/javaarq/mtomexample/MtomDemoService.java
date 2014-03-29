/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mtomexample;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author user
 */
@WebService(serviceName = "MtomDemoService")
//@MTOM
public class MtomDemoService {

    /**
     * This is a sample web service operation
     *
     * @return
     */
    @WebMethod(operationName = "imagen")
    public MiImagen imagen() {
        MiImagen imagen = new MiImagen();

        imagen.setNombre("logo.png");

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("/images/logo.png");) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int b;
            while ((b = is.read()) != -1) {
                bos.write(b);
            }
            imagen.setData(bos.toByteArray());
        } catch (IOException ex) {
        }

        return imagen;
    }
}
