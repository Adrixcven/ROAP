/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.DAO.ProductoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorModificarDevolucion {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private DevolucionDAO DevolucionDAO; 
    private ProductoDAO ProductoDAO;
    @GetMapping("/modificardevolucion")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("productos", ProductoDAO.findAll());
        
        var devolucionej = DevolucionDAO.findById(1);
        model.addAttribute("devolucionej", devolucionej);
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/ModificarDevolucion"; //Retorn de la pàgina Login.html.
    }
}
