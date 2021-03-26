package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.ItemRentado;
import org.mybatis.guice.transactional.Transactional;

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
}
