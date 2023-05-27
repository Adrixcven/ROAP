package cat.copernic.roap.Pedidos.servicios;

/*Classe servei que farà de capa intermitja entre la capa de presentació (MVC) i la capa de dades
 *i que implementa la interface GosServiceInterface*/
import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
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
public class EnvioService implements EnvioServiceInterface {

    @Autowired
    private EnvioDAO envioDAO;

    /**
     * Recupera una lista de todos los envíos almacenados.
     *
     * @return Una lista de objetos Envio que representa todos los envíos
     * almacenados.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Envio> listarEnvio() {
        return (List<Envio>) envioDAO.findAll();
    }
    /**
     * Agrega un nuevo envío al sistema.
     *
     * @param envio El objeto Envio a ser agregado.
     */
    @Override
    @Transactional
    public void addEnvio(Envio envio) {

        this.envioDAO.save(envio);
    }
    /**
     * Elimina un envío existente del sistema.
     *
     * @param envio El objeto Envio a ser eliminado.
     */
    @Override
    @Transactional
    public void eliminarEnvio(Envio envio) {

        this.envioDAO.delete(envio);

    }
    /**
     * Busca un envío por su identificador único.
     *
     * @param envio El objeto Envio que contiene el identificador a buscar.
     * @return El objeto Envio correspondiente al identificador proporcionado, o null si no se encuentra.
     */
    @Override
    @Transactional(readOnly = true)
    public Envio buscarEnvio(Envio envio) {

        return this.envioDAO.findById(envio.getID()).orElse(null);

    }

}
