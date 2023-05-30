/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.serveis;

import cat.copernic.roap.models.Encargo;
import cat.copernic.roap.models.Prenda;
import java.util.List;

/**
 *
 * @author mfg20
 */
/**
 *
 * Interfaz para el servicio de gestión de encargos.
 */
public interface EncargoServiceInterface {

    /**
     *
     * Obtiene una lista de todos los encargos.
     *
     * @return una lista de encargos
     */
    public List<Encargo> listarEncargo();

    /**
     *
     * Añade un nuevo encargo.
     *
     * @param encargo el encargo a añadir
     */
    public void anadirEncargo(Encargo encargo);

    /**
     *
     * Elimina un encargo.
     *
     * @param encargo el encargo a eliminar
     */
    public void eliminarEncargo(Encargo encargo);

    /**
     *
     * Obtiene una lista de todas las prendas.
     *
     * @return una lista de prendas
     */
    public List<Prenda> listarPrenda();

    /**
     *
     * Busca un encargo por su identificador.
     *
     * @param encargo el encargo con el identificador a buscar
     * @return el encargo encontrado, o null si no se encontró ningún encargo
     * con ese identificador
     */
    public Encargo buscarEncargo(Encargo encargo);
}
