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
 * Interfaz para el servicio de gestión de prendas.
 */
public interface PrendaServiceInterface {

    /**
     *
     * Obtiene una lista de todas las prendas.
     *
     * @return una lista de prendas
     */
    public List<Prenda> listarPrenda();

    /**
     *
     * Obtiene una lista de todas las categorías.
     *
     * @return una lista de categorías
     */
    public List<Categorias> listarCategorias();

    /**
     *
     * Añade una nueva prenda.
     *
     * @param prenda la prenda a añadir
     */
    public void anadirPrenda(Prenda prenda);

    /**
     *
     * Elimina una prenda.
     *
     * @param prenda la prenda a eliminar
     */
    public void eliminarPrenda(Prenda prenda);

    /**
     *
     * Busca una prenda por su identificador.
     *
     * @param prenda la prenda con el identificador a buscar
     * @return la prenda encontrada, o null si no se encontró ninguna prenda con
     * ese identificador
     */
    public Prenda buscarPrenda(Prenda prenda);
}
