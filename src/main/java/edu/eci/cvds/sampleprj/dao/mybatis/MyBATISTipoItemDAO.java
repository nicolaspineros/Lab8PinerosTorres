package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;

import javax.inject.Inject;

public class MyBATISTipoItemDAO implements TipoItemDAO {

    @Inject
    private TipoItemMapper tipoItemMapper;

    @Override
    public void save(String des) throws PersistenceException {
        try {
            tipoItemMapper.addTipoItem(des);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al agregar tipo"+des,e);
        }
    }

    @Override
    public TipoItem load(int id) throws PersistenceException {
        try {
            return tipoItemMapper.getTipoItem(id);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el tipo del item"+id,e);
        }
    }
}
