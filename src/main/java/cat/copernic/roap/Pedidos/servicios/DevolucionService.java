package cat.copernic.roap.Pedidos.servicios;

/*Classe servei que farà de capa intermitja entre la capa de presentació (MVC) i la capa de dades
 *i que implementa la interface GosServiceInterface*/

import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.models.Devolucion;
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
public class DevolucionService implements DevolucionServiceInterface{   

    

    @Autowired
    private DevolucionDAO devolucionDAO;
    

    /**
     * Recupera una lista de todas las devoluciones.
     *
     * @return Lista de devoluciones.
     */
    @Override
    @Transactional(readOnly=true) 
    public List<Devolucion> listarDevolucion() {
        

        return (List<Devolucion>) devolucionDAO.findAll(); 
    }


    /**
     * Agrega una devolución.
     *
     * @param devolucion Devolución a agregar.
     */
    @Override
    @Transactional
    public void addDevolucion(Devolucion devolucion) {
        this.devolucionDAO.save(devolucion); 
    }
    /**
     * Elimina una devolución.
     *
     * @param devolucion Devolución a eliminar.
     */
    @Override
    @Transactional 
    public void eliminarDevolucion(Devolucion devolucion) {

        this.devolucionDAO.delete(devolucion);

    }

    /**
     * Busca una devolución por su identificador.
     *
     * @param devolucion Devolución a buscar.
     * @return Devolución encontrada o null si no se encuentra.
     */
    @Override
    @Transactional(readOnly=true) 
    public Devolucion buscarDevolucion(Devolucion devolucion) {
        return this.devolucionDAO.findById(devolucion.getID()).orElse(null);
        
    }
    
}
