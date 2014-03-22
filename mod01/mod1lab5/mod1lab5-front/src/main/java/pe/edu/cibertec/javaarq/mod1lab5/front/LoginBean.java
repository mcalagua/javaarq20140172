/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab5.front;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.ws.WebServiceRef;
import pe.edu.cibertec.javaarq.LoginService_Service;

/**
 *
 * @author user
 */
@Named
public class LoginBean {

    //TODO REVISAR PORQUE ES NULO :)
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/mod1lab5-service/LoginService.wsdl")
    private LoginService_Service service = new LoginService_Service();

    @Inject
    Credentials credentials;

    public void login() {

        try { // Call Web Service Operation
            pe.edu.cibertec.javaarq.LoginService port = service.getLoginServicePort();
            // TODO initialize WS operation arguments here
            java.lang.String user = credentials.getUser();
            java.lang.String password = credentials.getPassword();
            // TODO process result here
            boolean result = port.authenticate(user, password);
            System.out.println("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }

}
