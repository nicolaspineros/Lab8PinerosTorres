package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.eci.cvds.samples.entities.Item;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoMapper {

    public List<ItemRentado> consultarItemRentado();

    public ArrayList<ItemRentado> consultarItemRentadoCliente(@Param("iditemcliente") int id);

    public void createRentado(@Param("idlong") int id,
                              @Param("idCli") int docu,
                              @Param("item") Item item,
                              @Param("fechaI") LocalDate fechainiciorenta,
                              @Param("fechaF") LocalDate fechafinrenta);
}
