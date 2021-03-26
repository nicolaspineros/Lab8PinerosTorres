package edu.eci.cvds.samples.services.client;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;

import java.sql.SQLException;
import java.util.List;

public class ServiceExample {
    public static void main(String args[]) throws ExcepcionServiciosAlquiler {
        //ServiciosAlquiler sa = ServiciosAlquilerFactory.getInstance().getServiciosAlquiler();
        //List<Cliente> clientes = sa.consultarClientes();
        //System.out.println(clientes);
        //System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarClientes());
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().registrarAlquilerCliente());
    }
}
