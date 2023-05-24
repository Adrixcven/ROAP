/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.roap.Encargos.serveis;

import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Encargos;
import java.util.List;
import cat.copernic.roap.models.Prenda;

/**
 *
 * @author mfg20
 */
public interface EncargosServiceInterface {
    public List<Encargos> listarEncargos();

    public void anadirEncargo(Encargos encargo);

    public void eliminarEncargo(int id);

    // Otros métodos para editar, añadir prendas, quitar prendas, etc.
}
