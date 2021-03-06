package edu.eci.cvds.test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquiler();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void emptyDB() {
        for(int i = 0; i < 100; i += 10) {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(i);
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            Assert.assertTrue(r);
        }
    }

    @Test
    public void RegistroCliente(){
        try {
            Cliente rcliente = new Cliente("Nicop", 1015484,"301236","Av7cll127","onpc@mail.com",false,null);
            serviciosAlquiler.registrarCliente(rcliente);
            Cliente ncliente = serviciosAlquiler.consultarCliente(1015484);
            Assert.assertTrue(ncliente != null);
        }catch (ExcepcionServiciosAlquiler ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void registrarAlquilerCliente(){
        try {
            Date ld = Date.valueOf(LocalDate.now());
            Item item = serviciosAlquiler.consultarItem(3);
            serviciosAlquiler.registrarAlquilerCliente(ld, 3, item, 40);
            List<ItemRentado> it = serviciosAlquiler.consultarItemsCliente(3);
            Assert.assertTrue(it!=null);
        }catch(ExcepcionServiciosAlquiler ex){
            ex.printStackTrace();
        }
    }
    /*
    @Test
    public void consultarCostoAlquiler(){
        try{

        }catch(ExcepcionServiciosAlquiler ex){
            ex.printStackTrace();
        }
    }
     */

}