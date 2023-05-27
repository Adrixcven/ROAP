/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.Pedidos.servicios.ClienteService;
import cat.copernic.roap.Pedidos.servicios.ProductAddService;
import cat.copernic.roap.Pedidos.servicios.DevolucionService;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
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
public class ControladorAddCliente {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private ClienteService clienteService;
    
    /**
     * Método que responde a la solicitud GET "/pedidos/addclient" y genera la página de inicio.
     *
     * @param cliente el objeto Cliente para agregar.
     * @param model   el modelo utilizado para pasar datos a la vista.
     * @return la vista "Pedidos/AddCliente".
     */
    @GetMapping("/pedidos/addclient")
    public String inici(Cliente cliente, Model model){ 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/AddCliente"; 
    }
    
    /**
     * Método que responde a la solicitud POST "/guardarCliente" y guarda un cliente en el sistema.
     *
     * @param cliente el objeto Cliente a guardar.
     * @param error   los errores de validación, si los hay.
     * @return la redirección a la ruta "/pedidos/seleccionarCliente".
     */
    @PostMapping("/guardarCliente") 
    public String guardarCliente(@Valid Cliente cliente, Errors error) {
        if(error.hasErrors()){ 
             return "Pedidos/AddCliente"; 
        }

        clienteService.addCliente(cliente); 

        return "redirect:/pedidos/seleccionarCliente"; 
    }
}
