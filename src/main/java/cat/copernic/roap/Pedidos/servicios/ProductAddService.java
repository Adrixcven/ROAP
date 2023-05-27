package cat.copernic.roap.Pedidos.servicios;

/*Classe servei que farà de capa intermitja entre la capa de presentació (MVC) i la capa de dades
 *i que implementa la interface GosServiceInterface*/

import cat.copernic.roap.DAO.ClienteDAO;
import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.DAO.ProductAddedDAO;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.ProductAdded;
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
public class ProductAddService implements ProductAddServiceInterface{   


    @Autowired
    private ProductAddedDAO productAddedDAO;
    
    /**
     * Recupera una lista de todos los productos añadidos.
     *
     * @return Una lista de objetos ProductAdded que representan los productos añadidos.
     */
    @Override
    @Transactional(readOnly=true) 
    public List<ProductAdded> listarProductAdd() {
        return (List<ProductAdded>) productAddedDAO.findAll(); 
    }
    /**
     * Agrega un nuevo producto.
     *
     * @param productAdded El objeto ProductAdded que representa el producto a añadir.
     */

    @Override
    @Transactional
    public void addProductAdd(ProductAdded productAdded) {
        this.productAddedDAO.save(productAdded); 
    }
    /**
     * Elimina un producto existente.
     *
     * @param productAdded El objeto ProductAdded que representa el producto a eliminar.
     */
    @Override
    @Transactional 
    public void eliminarProductAdd(ProductAdded productAdded) {
        this.productAddedDAO.delete(productAdded);
    }
    /**
     * Busca un producto añadido por su ID.
     *
     * @param productAdded El objeto ProductAdded que contiene el ID del producto a buscar.
     * @return El objeto ProductAdded correspondiente al ID proporcionado, o null si no se encuentra.
     */
    @Override
    @Transactional(readOnly=true) 
    public ProductAdded buscarProductAdd(ProductAdded productAdded) {
        return this.productAddedDAO.findById(productAdded.getAddproductid()).orElse(null);
    }
    
}
