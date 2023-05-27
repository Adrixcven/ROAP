package cat.copernic.roap.ERP.serveis;

/*Classe servei que farà de capa intermitja entre la capa de presentació (MVC) i la capa de dades
 *i que implementa la interface GosServiceInterface*/

import cat.copernic.roap.Pedidos.servicios.*;
import cat.copernic.roap.DAO.ClienteDAO;
import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.DAO.UsuarioDAO;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
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
public class UsuariosService implements UsuariosServiceInterface{   


    @Autowired
    private UsuarioDAO usuarioDAO;
    /**
     * Devuelve una lista de todos los usuarios registrados.
     *
     * @return una lista de objetos Usuario que representa a todos los usuarios registrados.
     */

    @Override
    @Transactional(readOnly=true) 
    public List<Usuario> listarUsuario() {
        return (List<Usuario>) usuarioDAO.findAll(); 
    }
    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param usuario el objeto Usuario que se va a agregar.
     */
    
    @Override
    @Transactional
    public void addUsuario(Usuario usuario) {
        this.usuarioDAO.save(usuario); 
    }
    /**
     * Elimina un usuario del sistema.
     *
     * @param usuario el objeto Usuario que se va a eliminar.
     */
    @Override
    @Transactional 
    public void eliminarUsuario(Usuario usuario) {
        this.usuarioDAO.delete(usuario);

    }
    /**
     * Busca un usuario en el sistema basado en su identificación única (DNI).
     *
     * @param usuario el objeto Usuario que contiene el DNI a buscar.
     * @return el objeto Usuario correspondiente al DNI especificado, o null si no se encuentra.
     */
    @Override
    @Transactional(readOnly=true) 
    public Usuario buscarUsuario(Usuario usuario) {
        return this.usuarioDAO.findById(usuario.getDNI()).orElse(null);
    }
    
}
