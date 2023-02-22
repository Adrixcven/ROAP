/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

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
public class ControladorGestionPedidos {
    @GetMapping("/gestionpedidos")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        var pedido = new Pedidos();
        pedido.setID(1);
        pedido.setCliente("Fran Comido");
        pedido.setEstado("Completado");
        pedido.setPrecioTotal(90);
        var pedido1 = new Pedidos();
        pedido.setID(1);
        pedido.setCliente("Fran Comido");
        pedido.setEstado("Cancelado");
        pedido.setPrecioTotal(90);
        
        var pedidos = new ArrayList<Pedidos>();
        pedidos.add(pedido);
        pedidos.add(pedido1);
        //Enviem l'ArrayList de gossos
        model.addAttribute("pedidos", pedidos);
        
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/GestionPedidos"; //Retorn de la pàgina Login.html.
    }
}
