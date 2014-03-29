/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.patroncdnrs;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author user
 */
public interface HttpServletRequestProvider {

    HttpServletRequest getValue();

    void setValue(HttpServletRequest value);

}
