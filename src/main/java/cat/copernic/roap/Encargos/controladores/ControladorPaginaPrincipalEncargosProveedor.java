/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mfg20
 */
/**
 *
 * Controlador para la página principal de encargos del proveedor.
 */
@Controller
public class ControladorPaginaPrincipalEncargosProveedor {

    /**
     *
     * Método para manejar la solicitud GET "/encargosproveedor". Inicia la
     * página principal de encargos del proveedor y agrega los datos necesarios
     * al modelo.
     *
     * @param model el modelo para pasar datos a la vista
     * @return la vista "Encargos/PaginaInicialEncargosProveedor" para mostrar
     * la página principal de encargos del proveedor
     */
    @GetMapping("/encargosproveedor")
    public String inici(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        return "Encargos/PaginaInicialEncargosProveedor"; //Retorn de la pàgina Login.html.
    }
}
