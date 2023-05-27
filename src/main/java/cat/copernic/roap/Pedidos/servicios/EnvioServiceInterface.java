package cat.copernic.roap.Pedidos.servicios;


import cat.copernic.roap.models.Envio;
import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface EnvioServiceInterface {
    
    /**
     * Devuelve una lista de todos los envíos existentes.
     *
     * @return una lista de objetos de tipo Envio
     */
    public List<Envio> listarEnvio();
    
    /**
     * Agrega un nuevo envío a la lista de envíos.
     *
     * @param envio el objeto Envio a agregar
     */
    public void addEnvio(Envio envio);
    
    /**
     * Elimina un envío de la lista de envíos.
     *
     * @param envio el objeto Envio a eliminar
     */
    public void eliminarEnvio(Envio envio);
    
    /**
     * Busca un envío en la lista de envíos basándose en un criterio de búsqueda.
     *
     * @param envio el objeto Envio a buscar
     * @return el objeto Envio encontrado, o null si no se encuentra ningún envío que coincida
     */
    public Envio buscarEnvio(Envio envio);
}
