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
@Service
public class CategoriaService implements CategoriaServiceInterface {

    @Autowired
    private CategoriasDAO categoriasDAO;
    
    @Autowired
    private PrendaDAO prenda;

    @Override
    @Transactional(readOnly = true)
    public List<Categorias> listarCategoria() {
        return categoriasDAO.findAll();
    }

    @Override
    @Transactional
    public void anadirCategoria(Categorias categoria) {
        categoriasDAO.save(categoria);
    }

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

    @Override
    @Transactional(readOnly = true)
    public Categorias buscarCategoria(Categorias categoria) {
        return categoriasDAO.findById(categoria.getId()).orElse(null);
    }
}
