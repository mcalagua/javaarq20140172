/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author user
 */
@Singleton
public class LoginLegacyService implements LoginLegacyServiceLocal {

    @Override
    public boolean authenticate(final String user, final String password) {
        //abrir el archivo users.xml
        URL usersURL = this.getClass().getClassLoader().getResource("/pe/edu/cibertec/javaarq/users.xml");

        try {
            JAXBContext context = JAXBContext.newInstance(UsersList.class);
            Unmarshaller u = context.createUnmarshaller();
            UsersList users = (UsersList) u.unmarshal(usersURL);
            for (User item : users.getUsers()) {
                if (user.equals(item.getName()) && password.equals(item.getPassword())) {
                    return true;
                }
            }
        } catch (JAXBException ex) {
            Logger.getLogger(LoginLegacyService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
