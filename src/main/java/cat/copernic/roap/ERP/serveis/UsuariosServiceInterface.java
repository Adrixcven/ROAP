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
    
    public List<Usuario> listarUsuario(); 
    
    public void addUsuario(Usuario usuario); 
    
    public void eliminarUsuario(Usuario usuario); 
    
    public Usuario buscarUsuario(Usuario usuario); 
}
