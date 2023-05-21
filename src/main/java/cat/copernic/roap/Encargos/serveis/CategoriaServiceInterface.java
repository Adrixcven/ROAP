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
public interface CategoriaServiceInterface {
    List<Categorias> listarCategoria();
    void anadirCategoria(Categorias categorias);
    void eliminarCategoria(Categorias categorias);
    Categorias buscarCategoria(Categorias categorias);
}
