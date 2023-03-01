/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.DAO.EncargoDAO;
import cat.copernic.roap.Pedidos.controladores.*;
import cat.copernic.roap.models.Encargo;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorBorrarEncargo {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private EncargoDAO EncargoDAO;

    @GetMapping("/borrarEncargo")
    public String inici(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("encargo", EncargoDAO.findAll());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Encargos/BorrarEncargo"; //Retorn de la pàgina Login.html.
    }
}
