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
    
    /**
     * Devuelve una lista de todos los ProductAdded almacenados.
     *
     * @return una lista de ProductAdded
     */
    public List<ProductAdded> listarProductAdd(); 
    
    /**
     * Agrega un nuevo ProductAdded a la lista.
     *
     * @param productAdded el ProductAdded a agregar
     */
    public void addProductAdd(ProductAdded productAdded); 
    /**
     * Elimina un ProductAdded de la lista.
     *
     * @param productAdded el ProductAdded a eliminar
     */
    public void eliminarProductAdd(ProductAdded productAdded); 
    /**
     * Busca un ProductAdded en la lista y lo devuelve si se encuentra.
     *
     * @param productAdded el ProductAdded a buscar
     * @return el ProductAdded encontrado, o null si no se encuentra
     */
    public ProductAdded buscarProductAdd(ProductAdded productAdded); 
}
