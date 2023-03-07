package cat.copernic.roap.Pedidos.servicios;


import cat.copernic.roap.models.Pedidos;
import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface PedidosServiceInterface {
    
    public List<Pedidos> listarPedidos(); 
    
    public void addPedidos(Pedidos pedidos); 
    
    public void eliminarPedidos(Pedidos pedidos); 
    
    public Pedidos buscarPedidos(Pedidos pedidos); 
}
