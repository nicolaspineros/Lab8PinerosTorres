package edu.eci.cvds.view;


import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;

import javax.faces.bean.*;
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
}
