/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.javaarq.mod1lab6;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class PolizaFacade extends AbstractFacade<Poliza> implements PolizaFacadeLocal {
    @PersistenceContext(unitName = "mod1lab6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PolizaFacade() {
        super(Poliza.class);
    }
    
}
