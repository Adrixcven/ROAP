/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Encargos.serveis.EncargoService;
import cat.copernic.roap.models.Encargo;
import cat.copernic.roap.models.Prenda;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author mfg20
 */
/**
 *
 * Controlador para añadir encargos.
 */
@Controller
public class ControladorAñadirEncargo {

    @Autowired
    private EncargoService encargoService;

    /**
     *
     * Método para manejar la solicitud GET "/añadirEncargo".
     *
     * Inicia la página de añadir encargo y agrega los datos necesarios al
     * modelo.
     *
     * @param model el modelo para pasar datos a la vista
     *
     * @return la vista "Encargos/AñadirEncargo" para mostrar el formulario de
     * añadir encargo
     */
    @GetMapping("/añadirEncargo")
    public String iniciar(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);

// Crear una instancia de Encargo y agregarla al modelo
        Encargo encargo = new Encargo();
        model.addAttribute("encargo", encargo);

// Obtener prendas disponibles para mostrar en la vista
        List<Prenda> prendasDisponibles = encargoService.listarPrenda();
        model.addAttribute("prendasDisponibles", prendasDisponibles);

        return "Encargos/AñadirEncargo";
    }

    /**
     *
     * Método para manejar la solicitud POST "/guardarEncargo".
     *
     * Guarda el encargo enviado en el formulario y realiza validaciones de
     * errores.
     *
     * @param encargo el objeto Encargo enviado desde el formulario
     *
     * @param error objeto Errors para verificar si hay errores de validación
     *
     * @param model el modelo para pasar datos a la vista
     *
     * @return la vista "Encargos/AñadirEncargo" si hay errores, de lo
     * contrario, redirecciona a "/gestionarEncargos"
     */
    @PostMapping("/guardarEncargo")
    public String guardarEncargo(@Valid @ModelAttribute("encargo") Encargo encargo, Errors error, Model model) {
        if (error.hasErrors()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
            String username = authentication.getName();
            model.addAttribute("username", username);
            model.addAttribute("rolUsuario", rolUsuario);
            List<Prenda> prendasDisponibles = encargoService.listarPrenda();
            model.addAttribute("prendasDisponibles", prendasDisponibles);

            return "Encargos/AñadirEncargo";
        }

        encargoService.anadirEncargo(encargo);
        return "redirect:/gestionarEncargos";
    }

}
