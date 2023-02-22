/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.entidades.Devolucion;
import cat.copernic.roap.entidades.Envio;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorGestionDevolucion {
    @GetMapping("/GestionDevolucion")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        var devolucion = new Devolucion();
        devolucion.setID(1);
        devolucion.setCliente("Fran Guerrero");
        devolucion.setEstado("Completado");
        var devolucion1 = new Devolucion();
        devolucion1.setID(2);
        devolucion1.setCliente("Fran Guerrero");
        devolucion1.setEstado("Cancelado");
        
        var devoluciones = new ArrayList<Devolucion>();
        devoluciones.add(devolucion);
        devoluciones.add(devolucion1);
        //Enviem l'ArrayList de gossos
        model.addAttribute("devoluciones", devoluciones);
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/GestionDevolucion"; //Retorn de la pàgina Login.html.
    }
}
