package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

    @Inject
    private ItemDAO itemDAO;

    @Inject
    private ClienteDAO clienteDAO;

    @Inject
    private ItemRentadoDAO itemRentadoDAO;

    @Override
    public int valorMultaRetrasoxDia(int itemId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente consultarCliente(int docu) throws ExcepcionServiciosAlquiler {
        try{
            return clienteDAO.loadC(docu);
        }catch(PersistenceException ex){
            throw new ExcepcionServiciosAlquiler("Error al consultar cliente",ex);
        }
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        try {
            return clienteDAO.load();
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosAlquiler("Error al consultar clientes",ex);
        }
    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return itemDAO.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
        }
    }

    @Override
    public List<Item> consultarItemsDisponibles() {
        return itemDAO.loadl();
    }

    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
        try{
            LocalDate ld=date.toLocalDate();
            LocalDate ld2=ld.plusDays(numdias);
            clienteDAO.loadC((int)docu);
            consultarItem(item.getId());
            int id = itemRentadoDAO.load().get(itemRentadoDAO.load().size()-1).getId()+1;
            itemRentadoDAO.save(id,(int)docu,item,ld,ld2);
            clienteDAO.loadC((int)docu).setRentados(itemRentadoDAO.loadR(id));
        }catch(PersistenceException ex){
            throw new ExcepcionServiciosAlquiler("Error al agregar alquiler",ex);
        }
    }

    @Override
    public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
        try {
            clienteDAO.createC(c.getNombre(),c.getDocumento(),c.getTelefono(),c.getDireccion(),c.getEmail(),c.isVetado());
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosAlquiler("Error al agregar cliente",ex);
        }
    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        try{
            return itemDAO.load(iditem).getTarifaxDia()*numdias;
        }catch(PersistenceException ex){
            throw new ExcepcionServiciosAlquiler("Error al consultar costo alquiler",ex);
        }
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
