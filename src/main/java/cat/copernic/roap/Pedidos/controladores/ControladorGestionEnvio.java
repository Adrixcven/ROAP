/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.Pedidos.servicios.EnvioService;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    @GetMapping("/gestionenvio")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("envios", envioService.listarEnvio());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/GestionEnvio"; //Retorn de la pàgina Login.html.
    }
    @GetMapping("/eliminarenvio/{ID}")
    public String eliminarEnvio(Envio envio) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        envioService.eliminarEnvio(envio);

        return "redirect:/gestionenvio"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
    @GetMapping("/editarenvio/{ID}")
    public String editarEnvio(Envio envio, Model model) {

        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.*/
        model.addAttribute("envio", envioService.buscarEnvio(envio));

        return "Pedidos/ModificarEnvio"; //Retorna la pàgina amb el formulari de les dades del gos
    }
    @PostMapping("/guardarEnvio") 
    public String guardarEnvio(@ModelAttribute("envio") Envio envio, BindingResult result) {

        
        envioService.addEnvio(envio); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/pedidos"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
