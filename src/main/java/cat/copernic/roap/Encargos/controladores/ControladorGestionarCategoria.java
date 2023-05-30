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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author mfg20
 */
/**
 *
 * Controlador para gestionar categorías.
 */
@Controller
public class ControladorGestionarCategoria {

    @Autowired
    private CategoriaService categoriaService;

    /**
     *
     * Método para manejar la solicitud GET "/gestionarCategoria". Inicia la
     * página de gestión de categorías y agrega los datos necesarios al modelo.
     *
     * @param model el modelo para pasar datos a la vista
     * @return la vista "Encargos/GestionarCategoria" para mostrar la página de
     * gestión de categorías
     */
    @GetMapping("/gestionarCategoria")
    public String inici(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        model.addAttribute("categorias", categoriaService.listarCategoria());
        return "Encargos/GestionarCategoria";
    }

    /**
     *
     * Método para manejar la solicitud GET "/eliminarcat/{id}". Elimina una
     * categoría según el ID proporcionado y redirige a la página de gestión de
     * categorías. Si la eliminación no es posible debido a que hay prendas
     * asociadas a la categoría, se agrega un mensaje de error al atributo
     * flash.
     *
     * @param idCategoria el ID de la categoría a eliminar
     * @param redirectAttributes los atributos de redirección para pasar
     * mensajes entre solicitudes
     * @return la redirección a "/gestionarCategoria"
     */
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

    /**
     *
     * Método para manejar la solicitud GET "/editarcat/{id}". Inicia la página
     * de edición de categoría según el ID proporcionado y agrega los datos
     * necesarios al modelo.
     *
     * @param idCategoria el ID de la categoría a editar
     * @param model el modelo para pasar datos a la vista
     * @return la vista "Encargos/añadirCategoria" para mostrar la página de
     * edición de categoría
     */
    @GetMapping("/editarcat/{id}")
    public String editarCategoria(@PathVariable("id") int idCategoria, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        Categorias categoria = new Categorias();
        categoria.setId(idCategoria);
        model.addAttribute("categorias", categoriaService.buscarCategoria(categoria));
        return "Encargos/añadirCategoria";
    }
}
