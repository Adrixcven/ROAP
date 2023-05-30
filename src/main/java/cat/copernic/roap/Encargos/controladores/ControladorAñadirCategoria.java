/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Encargos.serveis.CategoriaService;
import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Prenda;
import cat.copernic.roap.models.Producto;
import jakarta.validation.Valid;
import static org.aspectj.bridge.MessageUtil.error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

/**
 *
 * @author mfg20
 */
/**
 * Controlador para añadir categorías.
 */
@Controller
public class ControladorAñadirCategoria {

    @Autowired // Anotación que injecta todos los métodos y posibles dependencias de CategoriaService al controlador
    private CategoriaService categoriaService;

    /**
     * Método que se ejecuta al acceder a la URL "/añadirCategoria" mediante una petición GET.
     * Genera la respuesta (recurso a retornar).
     *
     * @param model     Modelo utilizado para pasar datos a la vista.
     * @param categorias Objeto Categorias.
     * @return La página "Encargos/añadirCategoria".
     */
    @GetMapping("/añadirCategoria")
    public String inici(Model model, Categorias categorias) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        return "Encargos/añadirCategoria";
    }

    /**
     * Método que crea el formulario para la categoría.
     *
     * @param categorias Objeto Categorias.
     * @return La página "Encargos/añadirCategoria".
     */
    public String crearFormularioCategoria(Categorias categorias) {
        return "Encargos/añadirCategoria";
    }

    /**
     * Método que guarda una categoría enviada a través de un formulario.
     *
     * @param categorias Objeto Categorias.
     * @param errors     Errores producidos en la validación del formulario.
     * @param model      Modelo utilizado para pasar datos a la vista.
     * @return Redirección a la página "/gestionarCategoria".
     */
    @PostMapping("/guardarCategoria")
    public String guardarCategoria(@Valid Categorias categorias, Errors errors, Model model) {
        if (errors.hasErrors()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
            String username = authentication.getName();
            model.addAttribute("username", username);
            model.addAttribute("rolUsuario", rolUsuario);
            return "Encargos/añadirCategoria";
        }

        categoriaService.anadirCategoria(categorias);

        return "redirect:/gestionarCategoria";
    }
}
