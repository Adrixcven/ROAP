package cat.copernic.roap.ERP.serveis;

/*Classe servei que farà de capa intermitja entre la capa de presentació (MVC) i la capa de dades
 *i que implementa la interface GosServiceInterface*/

import cat.copernic.roap.Pedidos.servicios.*;
import cat.copernic.roap.DAO.ClienteDAO;
import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.DAO.ModulosDAO;
import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.DAO.UsuarioDAO;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Modulos;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.Usuario;
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
public class ModulosService implements ModulosServiceInterface{   

   
    @Autowired
    private ModulosDAO modulosDAO;
    

    /**
     * Devuelve una lista de todos los módulos.
     *
     * @return una lista de objetos Modulos que representa todos los módulos.
     */
    @Override
    @Transactional(readOnly=true) 
    public List<Modulos> listarModulos() {
        
   
        return (List<Modulos>) modulosDAO.findAll(); 
    }


    /**
     * Agrega un módulo.
     *
     * @param usuario el objeto Modulos que se va a agregar.
     */
    @Override
    @Transactional
    public void addModulos(Modulos usuario) {
        

        this.modulosDAO.save(usuario); 
    }

    /**
     * Elimina un módulo.
     *
     * @param usuario el objeto Modulos que se va a eliminar.
     */
    @Override
    @Transactional 
    public void eliminarModulos(Modulos usuario) {

        this.modulosDAO.delete(usuario);

    }

    /**
     * Busca un módulo por su identificador.
     *
     * @param usuario el objeto Modulos que se va a buscar.
     * @return el objeto Modulos correspondiente al identificador proporcionado, o null si no se encuentra.
     */
    @Override
    @Transactional(readOnly=true) 
    public Modulos buscarModulos(Modulos usuario) {
        return this.modulosDAO.findById(usuario.getID()).orElse(null);
    }
    
}
