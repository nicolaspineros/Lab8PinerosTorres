package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import org.mybatis.guice.transactional.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyBATISItemRentadoDAO implements ItemRentadoDAO{

    @Inject
    private ItemRentadoMapper itemRentadoMapper;

    @Override
    @Transactional
    public List<ItemRentado> load() throws PersistenceException {
        try{
            return itemRentadoMapper.consultarItemRentado();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el item ",e);
        }
    }

    @Override
    @Transactional
    public void save(int id, int docu, Item item, LocalDate fechainiciorenta, LocalDate fechafinalrenta)throws PersistenceException{
        try{
            itemRentadoMapper.createRentado(id,docu, item, fechainiciorenta,fechafinalrenta);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al crear el item rentado ",e);
        }
    }

    @Override
    @Transactional
    public ArrayList<ItemRentado> loadR(int id) throws PersistenceException {
        try{
            return itemRentadoMapper.consultarItemRentadoCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el item ",e);
        }
    }
}
