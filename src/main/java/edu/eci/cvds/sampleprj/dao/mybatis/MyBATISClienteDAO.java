package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

public class MyBATISClienteDAO implements ClienteDAO {

    @Inject
    private ClienteMapper clienteMapper;

    @Override
    public void save(int id,int idit, Date fechaini, Date fechafin) throws PersistenceException {
        try {
            clienteMapper.agregarItemRentadoACliente(id,idit,fechaini,fechafin);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el item rentado del cliente "+idit,e);
        }
    }

    @Override
    public List<Cliente> load() throws PersistenceException {
        try {
            return clienteMapper.consultarClientes();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el cliente ",e);
        }
    }
}
