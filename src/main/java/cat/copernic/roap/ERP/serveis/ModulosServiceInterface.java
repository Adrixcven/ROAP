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
    
    public List<Modulos> listarModulos(); 
    
    public void addModulos(Modulos usuario); 
    
    public void eliminarModulos(Modulos usuario); 
    
    public Modulos buscarModulos(Modulos usuario); 
}
