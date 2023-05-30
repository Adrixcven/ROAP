package cat.copernic.roap.Pedidos.servicios;


import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface DevolucionServiceInterface {
    
    /**
     * Devuelve una lista de todas las devoluciones registradas.
     *
     * @return una lista de objetos Devolucion que representan las devoluciones registradas.
     */
    public List<Devolucion> listarDevolucion();

    /**
     * Agrega una nueva devolución al sistema.
     *
     * @param devolucion la devolución a ser agregada.
     */
    public void addDevolucion(Devolucion devolucion);

    /**
     * Elimina una devolución existente del sistema.
     *
     * @param devolucion la devolución a ser eliminada.
     */
    public void eliminarDevolucion(Devolucion devolucion);

    /**
     * Busca una devolución en el sistema.
     *
     * @param devolucion la devolución a ser buscada.
     * @return la devolución encontrada, o null si no se encuentra.
     */
    public Devolucion buscarDevolucion(Devolucion devolucion);
}
