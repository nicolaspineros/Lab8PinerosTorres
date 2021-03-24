package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;

import java.util.Date;
import java.util.List;

public interface ClienteDAO {

    public void save(int id, int idit, Date fechaini, Date fechafin) throws PersistenceException;

    public List<Cliente> load() throws PersistenceException;

    public Cliente loadC(int documento) throws PersistenceException;
}