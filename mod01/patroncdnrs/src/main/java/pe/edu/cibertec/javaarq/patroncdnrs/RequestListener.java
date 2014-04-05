/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.patroncdnrs;

import javax.inject.Inject;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Web application lifecycle listener.
 *
 * El request listener se usa para hacer el bootstrap del HTTPServletRequest en
 * CDI
 *
 * @author user
 */
@WebListener()
public class RequestListener implements ServletRequestListener {

    @Inject
    HttpServletRequestProvider provider;

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //Esta llamada establece el valor del provider con el httprequest
        provider.setValue((HttpServletRequest) sre.getServletRequest());
    }
}
