/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.serveis;

import cat.copernic.roap.DAO.CategoriasDAO;
import cat.copernic.roap.DAO.PrendaDAO;
import cat.copernic.roap.models.Categorias;
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
 * Servicio para la gestión de categorías.
 */
@Service
public class CategoriaService implements CategoriaServiceInterface {

    @Autowired
    private CategoriasDAO categoriasDAO;

    @Autowired
    private PrendaDAO prenda;

    /**
     *
     * Obtiene una lista de todas las categorías.
     *
     * @return una lista de categorías
     */
    @Override
    @Transactional(readOnly = true)
    public List<Categorias> listarCategoria() {
        return categoriasDAO.findAll();
    }

    /**
     *
     * Añade una nueva categoría.
     *
     * @param categoria la categoría a añadir
     */
    @Override
    @Transactional
    public void anadirCategoria(Categorias categoria) {
        categoriasDAO.save(categoria);
    }

    /**
     *
     * Elimina una categoría.
     *
     * @param categoria la categoría a eliminar
     *
     * @throws IllegalStateException si existen prendas asociadas a la categoría
     */
    @Override
    @Transactional
    public void eliminarCategoria(Categorias categoria) {
        int idCategoria = categoria.getId();

        // Verificar si existen prendas asociadas a la categoría
        boolean existenPrendas = prenda.existenPrendasPorCategoria(idCategoria);

        if (existenPrendas) {
            throw new IllegalStateException("No se puede eliminar la categoría, primero elimine las prendas asociadas");
            // También podrías retornar un valor booleano en lugar de lanzar una excepción
            // return false;
        }

        categoriasDAO.delete(categoria);
    }

    /**
     *
     * Busca una categoría por su identificador.
     *
     * @param categoria la categoría con el identificador a buscar
     * @return la categoría encontrada, o null si no se encontró ninguna
     * categoría con ese identificador
     */
    @Override
    @Transactional(readOnly = true)
    public Categorias buscarCategoria(Categorias categoria) {
        return categoriasDAO.findById(categoria.getId()).orElse(null);
    }
}
