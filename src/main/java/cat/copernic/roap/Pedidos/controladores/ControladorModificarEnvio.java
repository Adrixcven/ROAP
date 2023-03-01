/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.EnvioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorModificarEnvio {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private EnvioDAO EnvioDAO; 
    @GetMapping("/modificarenvio")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        
        var envioej = EnvioDAO.findById(1);
        
        model.addAttribute("envioej", envioej);
        return "Pedidos/ModificarEnvio"; //Retorn de la pàgina Login.html.
    }
}
