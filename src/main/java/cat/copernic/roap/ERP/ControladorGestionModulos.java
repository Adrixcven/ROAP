/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.ERP;

import cat.copernic.roap.DAO.ModulosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorGestionModulos {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private ModulosDAO ModulosDAO;
    @GetMapping("/gestionmodulo")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        
        var pedidos = ModulosDAO.findById(1);
        var inventario = ModulosDAO.findById(2);
        var encargos = ModulosDAO.findById(3);
        model.addAttribute("pedidos", pedidos );
        model.addAttribute("inventario", inventario );
        model.addAttribute("encargos", encargos );
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "GestionModulos"; //Retorn de la pàgina Login.html.
    }
}
