package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.ItemRentado;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("idcli") int id);
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(int id, 
            int idit, 
            Date fechainicio,
            Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();

    public void agregarCliente(@Param("nombrecli") String nombre,
                               @Param("documentcli") long documento,
                               @Param("telcli") String telefono,
                               @Param("dircli") String direccion,
                               @Param("emailcli") String email,
                               @Param("vetadocli") boolean vetado,
                               @Param("rentadoscli") ArrayList<ItemRentado>rentados);
}
