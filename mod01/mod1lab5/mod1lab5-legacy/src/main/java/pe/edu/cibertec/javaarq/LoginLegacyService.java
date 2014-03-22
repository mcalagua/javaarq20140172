/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq;

import javax.ejb.Singleton;

/**
 *
 * @author user
 */
@Singleton
public class LoginLegacyService implements LoginLegacyServiceLocal {

    @Override
    public boolean authenticate(final String user, final String password) {
        //abrir el archivo users.xml

        //parsear el archivo usando JAXB
        //obtener una referencia a la entidad usersList
        //buscar en la entidad si la combinación usuario y password es válida
        return false;
    }

}
