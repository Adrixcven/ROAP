/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.roap.Encargos.serveis;

import cat.copernic.roap.models.Categorias;
import java.util.List;
import cat.copernic.roap.models.Prenda;

/**
 *
 * @author mfg20
 */
/**
 *
 * Interfaz que define los métodos para el servicio de gestión de categorías.
 */
public interface CategoriaServiceInterface {

    /**
     *
     * Obtiene una lista de todas las categorías.
     *
     * @return una lista de categorías
     */
    List<Categorias> listarCategoria();

    /**
     *
     * Añade una nueva categoría.
     *
     * @param categorias la categoría a añadir
     */
    void anadirCategoria(Categorias categorias);

    /**
     *
     * Elimina una categoría.
     *
     * @param categorias la categoría a eliminar
     */
    void eliminarCategoria(Categorias categorias);

    /**
     *
     * Busca una categoría por su identificador.
     *
     * @param categorias la categoría con el identificador a buscar
     * @return la categoría encontrada, o null si no se encontró ninguna
     * categoría con ese identificador
     */
    Categorias buscarCategoria(Categorias categorias);
}
