package cat.copernic.roap.Pedidos.servicios;


import cat.copernic.roap.models.Pedidos;
import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface PedidosServiceInterface {
    /**
     * Devuelve una lista de todos los pedidos.
     *
     * @return una lista de objetos de tipo Pedidos que representa todos los pedidos existentes.
     */
    public List<Pedidos> listarPedidos(); 
    /**
     * Agrega un nuevo pedido a la lista de pedidos.
     *
     * @param pedidos el objeto de tipo Pedidos que se desea agregar.
     */
    public void addPedidos(Pedidos pedidos); 
    /**
     * Elimina un pedido de la lista de pedidos.
     *
     * @param pedidos el objeto de tipo Pedidos que se desea eliminar.
     */
    public void eliminarPedidos(Pedidos pedidos); 
    /**
     * Busca un pedido en la lista de pedidos.
     *
     * @param pedidos el objeto de tipo Pedidos que se desea buscar.
     * @return el objeto de tipo Pedidos si se encuentra, o null si no se encuentra.
     */
    public Pedidos buscarPedidos(Pedidos pedidos); 
}
