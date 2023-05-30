/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;

import cat.copernic.roap.DAO.ModulosDAO;
import cat.copernic.roap.ERP.serveis.ModulosService;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Modulos;
import jakarta.validation.Valid;
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
 * @author Adrix
 */
@Controller
public class ControladorGestionModulos {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private ModulosService modulosService;
    
    @Autowired
    private ModulosDAO ModulosDAO;
    
    /**
     * Método que genera la respuesta para la página "/gestionmodulo".
     *
     * @param model el modelo de datos para la vista
     * @return la página "GestionModulos"
     */
    @GetMapping("/gestionmodulo")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        
        model.addAttribute("modulos", modulosService.listarModulos());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "GestionModulos"; //Retorn de la pàgina Login.html.
    }
    /**
     * Método que guarda un módulo.
     *
     * @param modulo el módulo a guardar
     * @param error  los errores producidos durante la validación
     * @return la página "/gestionmodulo" si hay errores, o redirecciona a "/gestionmodulo" si se guarda correctamente
     */
    @PostMapping("/guardarModulo") //action=guardarGos
    public String guardarModulo(Modulos modulo, Errors error) {
        if(error.hasErrors()){ 
             return "/gestionmodulo"; 
        }

        modulosService.addModulos(modulo); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/gestionmodulo"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
