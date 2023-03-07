/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.DAO.PrendaDAO;
import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.Pedidos.controladores.*;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.Prenda;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cat.copernic.roap.models.Prenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorGestionarPrendas {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private PrendaDAO PrendaDAO;
    
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private PrendaService prendaService;

    @GetMapping("/gestionarPrendas")
    public String inici(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("prenda", PrendaDAO.findAll());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Encargos/GestionarPrendas"; //Retorn de la pàgina Login.html.
    }
    
    @GetMapping("/eliminar/{id}") 
    public String eliminar(Prenda prenda) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        
        prendaService.eliminarPrenda(prenda);
        
        return "redirect:/gestionarPrendas"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
    
    @GetMapping("/editar/{id}")
    public String editar(Prenda prenda, Model model) {

        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.*/
        model.addAttribute("prenda", prendaService.buscarPrenda(prenda));

        return "Encargos/AñadirPrenda"; //Retorna la pàgina amb el formulari de les dades del gos
    }
}
