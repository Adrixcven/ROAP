package cat.copernic.roap.Pedidos.servicios;

/*Classe servei que farà de capa intermitja entre la capa de presentació (MVC) i la capa de dades
 *i que implementa la interface GosServiceInterface*/

import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.models.Pedidos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fta
 */

/*Anotació que permet al sistema que reconegui aquesta classe com una classe de servei
 *i que permet injectar aquesta classe en el controlador
*/
@Service 
public class PedidosService implements PedidosServiceInterface{   

    
    
    @Autowired
    private PedidosDAO pedidosDAO;
    
    
    /**
     * Recupera una lista de todos los pedidos.
     *
     * @return una lista de pedidos.
     */
    @Override
    @Transactional(readOnly=true) 
    public List<Pedidos> listarPedidos() {
        return (List<Pedidos>) pedidosDAO.findAll(); 
    }

    /**
     * Agrega un nuevo pedido.
     *
     * @param pedidos el pedido a agregar.
     */
    @Override
    @Transactional
    public void addPedidos(Pedidos pedidos) {
        this.pedidosDAO.save(pedidos); 
    }
    /**
     * Elimina un pedido existente.
     *
     * @param pedidos el pedido a eliminar.
     */
    @Override
    @Transactional
    public void eliminarPedidos(Pedidos pedidos) {
        this.pedidosDAO.delete(pedidos);

    }
    /**
     * Busca un pedido por su identificador.
     *
     * @param pedidos el pedido a buscar.
     * @return el pedido encontrado o null si no se encuentra.
     */
    @Override
    @Transactional(readOnly=true) 
    public Pedidos buscarPedidos(Pedidos pedidos) {

        return this.pedidosDAO.findById(pedidos.getID()).orElse(null);
        
    }
    
}
