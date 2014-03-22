/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author user
 */
@WebService(serviceName = "LoginService")
public class LoginService {

    @Inject
    LoginLegacyServiceLocal legacy;

    /**
     * This is a sample web service operation
     *
     * @param user
     * @param password
     * @return
     */
    @WebMethod(operationName = "authenticate")
    public boolean authenticate(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {
        if (StringUtils.isEmpty(user) || StringUtils.isEmpty(password)) {
            return false;
        }
        return legacy.authenticate(user, password);
    }
}
