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
    /**
     * Devuelve una lista de todos los clientes registrados.
     *
     * @return una lista de objetos Cliente que representan a los clientes registrados.
     */
    public List<Cliente> listarCliente();

    /**
     * Agrega un nuevo cliente al sistema.
     *
     * @param cliente el objeto Cliente que se desea agregar.
     */
    public void addCliente(Cliente cliente);

    /**
     * Elimina un cliente del sistema.
     *
     * @param cliente el objeto Cliente que se desea eliminar.
     */
    public void eliminarCliente(Cliente cliente);

    /**
     * Busca un cliente en el sistema.
     *
     * @param cliente el objeto Cliente que se desea buscar.
     * @return el objeto Cliente encontrado, o null si no se encuentra.
     */
    public Cliente buscarCliente(Cliente cliente);
}
