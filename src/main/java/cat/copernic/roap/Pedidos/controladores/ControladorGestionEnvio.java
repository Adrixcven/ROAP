/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.Pedidos.servicios.EnvioService;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import jakarta.validation.Valid;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorGestionEnvio {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private EnvioDAO EnvioDAO;
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private EnvioService envioService;
    
    /**
     * Método que genera la respuesta para la URL "/pedidos/gestionenvio".
     *
     * @param model el modelo utilizado para almacenar los atributos de la vista
     * @return la página "Pedidos/GestionEnvio"
     */
    @GetMapping("/pedidos/gestionenvio")
    public String ConsultarEnvios(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        model.addAttribute("envios", envioService.listarEnvio());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/GestionEnvio"; //Retorn de la pàgina Login.html.
    }
    
    /**
     * Método que elimina un envío de pedido.
     *
     * @param envio el envío a eliminar
     * @return una redirección a la página inicial de gestión de envíos
     */
    @GetMapping("/pedidos/eliminarenvio/{ID}")
    public String eliminarEnvio(Envio envio) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        envioService.eliminarEnvio(envio);

        return "redirect:/gestionenvio"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
    /**
     * Método que guarda los cambios realizados en un envío de pedido.
     *
     * @param envio  el envío a guardar
     * @param result el objeto BindingResult que contiene los resultados del proceso de validación
     * @param error  los errores de validación encontrados
     * @return una redirección a la página inicial de pedidos o la página de edición si hay errores de validación
     */
    @PostMapping("/guardarEnvio") 
    public String guardarEnvio(@Valid @ModelAttribute("envio") Envio envio, BindingResult result, Errors error) {
        if(error.hasErrors()){ 
             return "Pedidos/ModificarEnvio"; 
        }
        envioService.addEnvio(envio); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/pedidos"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
