/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.patroncdnrs;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;

/**
 * El patron provider nos permite emitir objetos nuevos alcontexto de CDI
 *
 * En este caso usamos RequestScoped porque queremos scopear el HTTPRequest
 * detrás de cada una de las llamadas al servidor.
 *
 * Por patros de SPI usamos interfaz e implementación
 *
 * @author user
 */
@RequestScoped
class HttpServletRequestProviderImpl implements HttpServletRequestProvider {

    private HttpServletRequest value;

    @Produces
    @Override
    public HttpServletRequest getValue() {
        return value;
    }

    @Override
    public void setValue(HttpServletRequest value) {
        this.value = value;
    }

}
