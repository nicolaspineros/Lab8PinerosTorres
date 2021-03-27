package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ClienteDAO {

    public void save(int id, int idit, Date fechaini, Date fechafin) throws PersistenceException;

    public List<Cliente> load() throws PersistenceException;

    public Cliente loadC(int documento) throws PersistenceException;

    void createC(String nombre, long documento, String telefono, String direccion, String email, boolean vetado) throws PersistenceException;
}