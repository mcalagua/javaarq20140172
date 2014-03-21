/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab4;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author user
 */
@WebService(serviceName = "MiPrimerServicio")
public class MiPrimerServicio {

    /**
     * This is a sample web service operation
     *
     * @param txt
     * @return
     */
    @WebMethod(operationName = "hola")
    public String hello(@WebParam(name = "nombre") String txt) {
        return "Hola " + txt + " !";
    }
}
