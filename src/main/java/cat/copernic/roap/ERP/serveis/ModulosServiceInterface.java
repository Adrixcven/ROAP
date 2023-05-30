package cat.copernic.roap.ERP.serveis;


import cat.copernic.roap.Pedidos.servicios.*;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Modulos;
import cat.copernic.roap.models.Usuario;
import java.util.List;

/**
 *
 * @author fta
 */


public interface ModulosServiceInterface {
    
    /**
     * Retorna una lista de todos los módulos existentes.
     *
     * @return Una lista de objetos Modulos que representa los módulos existentes.
     */
    public List<Modulos> listarModulos(); 
    
    /**
     * Agrega un nuevo módulo.
     *
     * @param usuario El objeto Modulos que se desea agregar.
     */
    public void addModulos(Modulos usuario); 
    
    /**
     * Elimina un módulo existente.
     *
     * @param usuario El objeto Modulos que se desea eliminar.
     */
    public void eliminarModulos(Modulos usuario); 
    
    /**
     * Busca un módulo en base a sus propiedades.
     *
     * @param usuario El objeto Modulos que contiene las propiedades de búsqueda.
     * @return El objeto Modulos que coincide con los criterios de búsqueda, o null si no se encuentra.
     */
    public Modulos buscarModulos(Modulos usuario); 
}
