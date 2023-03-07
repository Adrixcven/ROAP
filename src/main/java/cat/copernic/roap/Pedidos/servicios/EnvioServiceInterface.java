package cat.copernic.roap.Pedidos.servicios;


import cat.copernic.roap.models.Envio;
import java.util.List;

/**
 *
 * @author fta
 */

//Interface on definirem els mètodes CRUD personalitzats per la nostra aplicació
public interface EnvioServiceInterface {
    
    public List<Envio> listarEnvio(); 
    
    public void addEnvio(Envio envio); 
    
    public void eliminarEnvio(Envio envio); 
    
    public Envio buscarEnvio(Envio envio); 
}
