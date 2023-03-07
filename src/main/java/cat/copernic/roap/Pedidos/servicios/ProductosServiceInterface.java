package cat.copernic.roap.Pedidos.servicios;


import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Producto;
import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface ProductosServiceInterface {
    
    public List<Producto> listarProducto(); 
    
    public void addProducto(Producto producto); 
    
    public void eliminarProducto(Producto producto); 
    
    public Producto buscarProducto(Producto producto); 
}
