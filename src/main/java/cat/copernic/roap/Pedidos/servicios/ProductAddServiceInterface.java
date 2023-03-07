package cat.copernic.roap.Pedidos.servicios;


import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.ProductAdded;
import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface ProductAddServiceInterface {
    
    public List<ProductAdded> listarProductAdd(); 
    
    public void addProductAdd(ProductAdded productAdded); 
    
    public void eliminarProductAdd(ProductAdded productAdded); 
    
    public ProductAdded buscarProductAdd(ProductAdded productAdded); 
}
