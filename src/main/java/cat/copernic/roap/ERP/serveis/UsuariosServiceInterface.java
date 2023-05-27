package cat.copernic.roap.ERP.serveis;


import cat.copernic.roap.Pedidos.servicios.*;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Usuario;
import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface UsuariosServiceInterface {
     /**
     * Obtiene una lista de todos los usuarios.
     *
     * @return Una lista de objetos Usuario que representa a todos los usuarios.
     */
    public List<Usuario> listarUsuario();

    /**
     * Agrega un nuevo usuario.
     *
     * @param usuario El objeto Usuario que se va a agregar.
     */
    public void addUsuario(Usuario usuario);

    /**
     * Elimina un usuario existente.
     *
     * @param usuario El objeto Usuario que se va a eliminar.
     */
    public void eliminarUsuario(Usuario usuario);

    /**
     * Busca un usuario basado en el objeto Usuario proporcionado.
     *
     * @param usuario El objeto Usuario utilizado para buscar.
     * @return El objeto Usuario encontrado o null si no se encuentra.
     */
    public Usuario buscarUsuario(Usuario usuario);
}
