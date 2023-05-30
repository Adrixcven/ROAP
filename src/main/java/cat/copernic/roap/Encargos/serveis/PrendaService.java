/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.serveis;

import cat.copernic.roap.DAO.CategoriasDAO;
import cat.copernic.roap.DAO.PrendaDAO;
import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Pedidos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import cat.copernic.roap.models.Prenda;
import org.springframework.stereotype.Service;

/**
 *
 * @author mfg20
 */
/**
 *
 * Servicio para la gestión de prendas.
 */
@Service
public class PrendaService implements PrendaServiceInterface {

    @Autowired
    private PrendaDAO prenda;

    @Autowired
    private CategoriasDAO categoria;

    /**
     *
     * Obtiene una lista de todas las prendas.
     *
     * @return una lista de prendas
     */
    @Override
    @Transactional(readOnly = true)
    public List<Prenda> listarPrenda() {
        return (List<Prenda>) prenda.findAll();
    }

    /**
     *
     * Añade una nueva prenda.
     *
     * @param prenda la prenda a añadir
     */
    @Override
    @Transactional
    public void anadirPrenda(Prenda prenda) {
        this.prenda.save(prenda);
    }

    /**
     *
     * Obtiene una lista de todas las categorías.
     *
     * @return una lista de categorías
     */
    @Override
    @Transactional(readOnly = true)
    public List<Categorias> listarCategorias() {
        return (List<Categorias>) categoria.findAll();
    }

    /**
     *
     * Elimina una prenda.
     *
     * @param prenda la prenda a eliminar
     */
    @Override
    @Transactional
    public void eliminarPrenda(Prenda prenda) {
        this.prenda.delete(prenda);
    }

    /**
     *
     * Busca una prenda por su identificador.
     *
     * @param prenda la prenda con el identificador a buscar
     * @return la prenda encontrada, o null si no se encontró ninguna prenda con
     * ese identificador
     */
    @Override
    @Transactional(readOnly = true)
    public Prenda buscarPrenda(Prenda prenda) {
        return this.prenda.findById(prenda.getId()).orElse(null);
    }
}
