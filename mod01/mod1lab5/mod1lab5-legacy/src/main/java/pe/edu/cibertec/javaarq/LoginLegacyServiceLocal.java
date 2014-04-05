/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq;

import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface LoginLegacyServiceLocal {

    boolean authenticate(final String user, final String password);

}
