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
    private String nombre;
    private long documento;
    private String telefono;
    private String direccion;
    private String email;
    private boolean vetado;

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

    public void registrarcliente(){
        Cliente aregistrar = new Cliente(nombre,documento,telefono,direccion,email,vetado,null);
        try {
            sa.registrarCliente(aregistrar);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVetado() {
        return vetado;
    }

    public void setVetado(boolean vetado) {
        this.vetado = vetado;
    }
}
