/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.serveis;

import cat.copernic.roap.DAO.EncargoDAO;
import cat.copernic.roap.DAO.PrendaDAO;
import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Encargo;
import cat.copernic.roap.models.Prenda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mfg20
 */
/**
 *
 * Clase de servicio que implementa la interfaz EncargoServiceInterface para
 * gestionar los encargos.
 */
@Service
public class EncargoService implements EncargoServiceInterface {

    @Autowired
    private EncargoDAO encargoDAO;

    @Autowired
    private PrendaDAO prendaDAO;

    /**
     *
     * Obtiene una lista de todos los encargos.
     *
     * @return una lista de encargos
     */
    @Override
    public List<Encargo> listarEncargo() {
        return encargoDAO.findAll();
    }

    /**
     *
     * Añade un nuevo encargo.
     *
     * @param encargo el encargo a añadir
     */
    @Override
    public void anadirEncargo(Encargo encargo) {
        encargoDAO.save(encargo);
    }

    /**
     *
     * Elimina un encargo.
     *
     * @param encargo el encargo a eliminar
     */
    @Override
    public void eliminarEncargo(Encargo encargo) {
        encargoDAO.delete(encargo);
    }

    /**
     *
     * Obtiene una lista de todas las prendas.
     *
     * @return una lista de prendas
     */
    @Override
    public List<Prenda> listarPrenda() {
        return prendaDAO.findAll();
    }

    /**
     *
     * Busca un encargo por su identificador.
     *
     * @param encargo el encargo con el identificador a buscar
     * @return el encargo encontrado, o null si no se encontró ningún encargo
     * con ese identificador
     */
    @Override
    @Transactional(readOnly = true)
    public Encargo buscarEncargo(Encargo encargo) {
        return encargoDAO.findById(encargo.getId()).orElse(null);
    }

}
