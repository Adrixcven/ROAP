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
    
    /**
     * Devuelve una lista de todos los productos en el catálogo.
     *
     * @return una lista de productos
     */
    public List<Producto> listarProducto(); 
    /**
     * Agrega un nuevo producto al catálogo.
     *
     * @param producto el producto a agregar
     */
    public void addProducto(Producto producto); 
    /**
     * Elimina un producto del catálogo.
     *
     * @param producto el producto a eliminar
     */
    public void eliminarProducto(Producto producto); 
    /**
     * Busca un producto en el catálogo.
     *
     * @param producto el producto a buscar
     * @return el producto encontrado, o null si no se encontró
     */
    public Producto buscarProducto(Producto producto); 
}
