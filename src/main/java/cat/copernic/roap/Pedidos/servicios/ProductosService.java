package cat.copernic.roap.Pedidos.servicios;

/*Classe servei que farà de capa intermitja entre la capa de presentació (MVC) i la capa de dades
 *i que implementa la interface GosServiceInterface*/
import cat.copernic.roap.DAO.ClienteDAO;
import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.DAO.ProductoDAO;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.Producto;
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
public class ProductosService implements ProductosServiceInterface {

    @Autowired
    private ProductoDAO productoDAO;

    /**
     * Recupera una lista de todos los productos.
     *
     * @return Lista de productos existentes en la base de datos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProducto() {

        return (List<Producto>) productoDAO.findAll();
    }

    /**
     * Agrega un nuevo producto a la base de datos.
     *
     * @param producto El producto que se va a agregar.
     */
    @Override
    @Transactional
    public void addProducto(Producto producto) {
        this.productoDAO.save(producto);
    }

    /**
     * Elimina un producto de la base de datos.
     *
     * @param producto El producto que se va a eliminar.
     */
    @Override
    @Transactional 
    public void eliminarProducto(Producto producto) {

        this.productoDAO.delete(producto);

    }

    /**
     * Busca un producto en la base de datos.
     *
     * @param producto El producto que se va a buscar.
     * @return El producto encontrado o null si no existe.
     */
    @Override
    @Transactional(readOnly = true) 
    public Producto buscarProducto(Producto producto) {
        return this.productoDAO.findById(producto.getID()).orElse(null);

    }

}
