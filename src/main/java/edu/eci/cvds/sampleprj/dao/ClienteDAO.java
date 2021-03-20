package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;

import java.util.Date;

public interface ClienteDAO {

    public void save(int id, int idit, Date fechaini, Date fechafin) throws PersistenceException;

    public Cliente load(int documento) throws PersistenceException;

}
