package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface ItemRentadoDAO {
    public List<ItemRentado> load() throws PersistenceException;
    public ArrayList<ItemRentado> loadR(int id) throws PersistenceException;
    public void save(int id, int docu, Item item, LocalDate fechainiciorenta, LocalDate fechafinalrenta) throws PersistenceException;
}
