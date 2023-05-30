package cat.copernic.roap.Pedidos.servicios;

/*Classe servei que farà de capa intermitja entre la capa de presentació (MVC) i la capa de dades
 *i que implementa la interface GosServiceInterface*/

import cat.copernic.roap.DAO.ClienteDAO;
import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fta
 */


@Service 
public class ClienteService implements ClienteServiceInterface{   

    public ClienteService() {
    }
    
    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Autowired
    private ClienteDAO clienteDAO;


    /**
     * Obtiene una lista de todos los clientes almacenados en la base de datos.
     *
     * @return Lista de objetos Cliente que representa todos los clientes almacenados.
     */
    @Override
    @Transactional(readOnly=true) 
    public List<Cliente> listarCliente() {
        

        return (List<Cliente>) clienteDAO.findAll(); 
    }
    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * @param cliente El objeto Cliente a ser agregado.
     */
    @Override
    @Transactional
    public void addCliente(Cliente cliente) {

        this.clienteDAO.save(cliente); 
    }

    /**
     * Elimina un cliente de la base de datos.
     *
     * @param cliente El objeto Cliente a ser eliminado.
     */
    @Override
    @Transactional 
    public void eliminarCliente(Cliente cliente) {
        
        this.clienteDAO.delete(cliente);

    }
    /**
     * Busca un cliente en la base de datos utilizando su DNI como identificador.
     *
     * @param cliente El objeto Cliente que contiene el DNI a buscar.
     * @return El objeto Cliente correspondiente al DNI especificado, o null si no se encuentra.
     */
    @Override
    @Transactional(readOnly=true) 
    public Cliente buscarCliente(Cliente cliente) {
        return this.clienteDAO.findById(cliente.getDNI()).orElse(null);
        
    }
    
}
