/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorAddCliente {
    @GetMapping("/AddClient")
    public String inici(){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/AddCliente"; //Retorn de la pàgina Login.html.
    }
}
