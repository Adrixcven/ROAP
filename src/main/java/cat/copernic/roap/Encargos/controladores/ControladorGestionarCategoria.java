/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.DAO.CategoriasDAO;
import cat.copernic.roap.DAO.PrendaDAO;
import cat.copernic.roap.Encargos.serveis.CategoriaService;
import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Prenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author mfg20
 */
@Controller
public class ControladorGestionarCategoria {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/gestionarCategoria")
    public String inici(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategoria());
        return "Encargos/GestionarCategoria";
    }

    @GetMapping("/eliminarcat/{id}")
    public String eliminarCategoria(@PathVariable("id") int idCategoria, RedirectAttributes redirectAttributes) {
        try {
            Categorias categoria = new Categorias();
            categoria.setId(idCategoria);
            categoriaService.eliminarCategoria(categoria);
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("error", "La categoría no puede ser eliminada debido a que una prenda está sujeta a ella.");
        }
        return "redirect:/gestionarCategoria";
    }

    @GetMapping("/editarcat/{id}")
    public String editarCategoria(@PathVariable("id") int idCategoria, Model model) {
        Categorias categoria = new Categorias();
        categoria.setId(idCategoria);
        model.addAttribute("categorias", categoriaService.buscarCategoria(categoria));
        return "Encargos/añadirCategoria";
    }
}
