/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Prenda;
import cat.copernic.roap.models.Producto;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author mfg20
 */
/**
 *
 * Controlador para añadir prendas.
 */
@Controller
public class ControladorAñadirPrenda {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de PrendaService al controlador    
    private PrendaService prendaService;

    /**
     *
     * Método para manejar la solicitud GET "/añadirPrenda".
     *
     * Inicia la página de añadir prenda y agrega los datos necesarios al
     * modelo.
     *
     * @param model el modelo para pasar datos a la vista
     *
     * @param prenda el objeto Prenda utilizado para capturar los datos del
     * formulario
     *
     * @return la vista "Encargos/AñadirPrenda" para mostrar el formulario de
     * añadir prenda
     */
    @GetMapping("/añadirPrenda")
    public String inici(Model model, Prenda prenda) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        List<Categorias> categorias = prendaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        return "Encargos/AñadirPrenda";
    }

    /**
     *
     * Método para crear el formulario de prenda.
     *
     * @param prenda el objeto Prenda utilizado para capturar los datos del
     * formulario
     * @return la vista "Encargos/AñadirPrenda" para mostrar el formulario de
     * añadir prenda
     */
    public String crearFormularioPrenda(Prenda prenda) {

        return "Encargos/AñadirPrenda"; //Retorna la pàgina on es mostrarà el formulari de les dades dels gos
    }

    /**
     *
     * Método para manejar la solicitud POST "/guardarPrenda".
     *
     * Guarda la prenda enviada en el formulario y realiza validaciones de
     * errores.
     *
     * @param prenda el objeto Prenda enviado desde el formulario
     *
     * @param error objeto Errors para verificar si hay errores de validación
     *
     * @param model el modelo para pasar datos a la vista
     *
     * @return la vista "Encargos/AñadirPrenda" si hay errores, de lo contrario,
     * redirecciona a "/gestionarPrendas"
     */
    @PostMapping("/guardarPrenda")
    public String guardarPrenda(@Valid Prenda prenda, Errors error, Model model) {
        if (error.hasErrors()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
            String username = authentication.getName();
            model.addAttribute("username", username);
            model.addAttribute("rolUsuario", rolUsuario);
            List<Categorias> categorias = prendaService.listarCategorias();
            model.addAttribute("categorias", categorias);
            return "Encargos/AñadirPrenda";
        }
        prendaService.anadirPrenda(prenda);
        return "redirect:/gestionarPrendas";
    }

}
