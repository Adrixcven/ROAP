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
    
    public List<Devolucion> listarDevolucion(); 
    
    public void addDevolucion(Devolucion devolucion); 
    
    public void eliminarDevolucion(Devolucion devolucion); 
    
    public Devolucion buscarDevolucion(Devolucion devolucion); 
}
