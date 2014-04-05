/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.javaarq.mod1lab7.impl;

import javax.jws.WebService;

/**
 *
 * @author user
 */
@WebService(serviceName = "MPPolizaService01", portName = "MPPolizaService01Port", endpointInterface = "pe.edu.cibertec.javaarq.mod1lab7.MPPolizaService01", targetNamespace = "http://mod1lab7.javaarq.cibertec.edu.pe/", wsdlLocation = "WEB-INF/wsdl/MPPolizaService01.wsdl")
public class NewWebServiceFromWSDL {

    public boolean crearPoliza(java.lang.Long arg0, java.lang.Long arg1, java.lang.String arg2, javax.xml.datatype.XMLGregorianCalendar arg3, javax.xml.datatype.XMLGregorianCalendar arg4) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.util.List<java.lang.String> consultarPoliza(java.lang.Long arg0) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
