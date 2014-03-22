/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.javaarq.mod1lab6;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;

/**
 *
 * @author user
 */
@WebService(serviceName = "PolizaService")
public class PolizaService {

    @EJB
    PolizaFacadeLocal repository;

    /**
     * This is a sample web service operation
     *
     * @param poliza
     * @return
     */
    public Poliza create(Poliza poliza) throws ServiceException {
        poliza.setIdPoliza(new Date().getTime());
        repository.create(poliza);
        return poliza;
    }

    public Poliza read(Long idPoliza) throws ServiceException {
        return repository.find(idPoliza);
    }

    public List<Poliza> readList() throws ServiceException {
        return repository.findAll();
    }

    public void update(Poliza poliza) throws ServiceException {
        repository.edit(poliza);
    }

    public void delete(Poliza poliza) throws ServiceException {
        repository.remove(poliza);
    }
}
