package cat.copernic.roap.Pedidos.servicios;


import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface ClienteServiceInterface {
    
    public List<Cliente> listarCliente(); 
    
    public void addCliente(Cliente cliente); 
    
    public void eliminarCliente(Cliente cliente); 
    
    public Cliente buscarCliente(Cliente cliente); 
}
