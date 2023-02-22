/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.entidades.Envio;
import cat.copernic.roap.entidades.Pedidos;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorGestionEnvio {
    @GetMapping("/gestionenvio")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        var envio = new Envio();
        envio.setID(1);
        envio.setIDPedido("02");
        envio.setEstado("Completado");
        var envio1 = new Envio();
        envio.setID(2);
        envio.setIDPedido("02");
        envio.setEstado("Cancelado");
        
        var envios = new ArrayList<Envio>();
        envios.add(envio);
        envios.add(envio1);
        //Enviem l'ArrayList de gossos
        model.addAttribute("envios", envios);
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/GestionEnvio"; //Retorn de la pàgina Login.html.
    }
}
