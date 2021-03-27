package edu.eci.cvds.view;


import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;

import javax.faces.bean.*;
import java.sql.Date;
import java.util.List;

@ApplicationScoped
@ManagedBean(name = "aplicationBean")
public class AlquilerItemsBean extends BasePageBean{
    private ServiciosAlquiler sa = ServiciosAlquilerFactory.getInstance().getServiciosAlquiler();

    public List<Cliente> getClientes(){
        try {
            return sa.consultarClientes();
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
            return null;
        }
    }

    public void addAlquiler(Date date, long docu, Item item, int numdias){
        try{
            sa.registrarAlquilerCliente(date, docu, item, numdias);
        }catch(ExcepcionServiciosAlquiler excepcionServiciosAlquiler){
            excepcionServiciosAlquiler.printStackTrace();
        }
    }

    public long getCosto(int iditem, int numdias){
        try {
            return sa.consultarCostoAlquiler(iditem,numdias);
        }catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler){
            excepcionServiciosAlquiler.printStackTrace();
            return -1;
        }
    }
}
