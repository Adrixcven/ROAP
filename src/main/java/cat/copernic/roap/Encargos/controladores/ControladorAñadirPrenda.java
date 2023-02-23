/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Pedidos.controladores.*;
import cat.copernic.roap.entidades.Prenda;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorAñadirPrenda {
    @GetMapping("/añadirPrenda")
    public String inici(){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        var prenda = new Prenda();
        prenda.setNombre ("Juan");
        prenda.setUnidades (3);
        prenda.setPrecio (20);
        prenda.setPrendaRopa ("Pantalon cargo");
        prenda.setEstadoProducto ("OK");
        prenda.setTalla (4);
        prenda.setColor("Negro");
        var prenda1 = new Prenda();
        prenda.setNombre ("Alba");
        prenda.setUnidades (7);
        prenda.setPrecio (10);
        prenda.setPrendaRopa ("Camiseta frozen");
        prenda.setEstadoProducto ("OK");
        prenda.setTalla (20);
        prenda.setColor("Azul");
        
        var prendas = new ArrayList<Prenda>();
        prendas.add(prenda);
        prendas.add(prenda1);
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Encargos/AñadirPrenda"; //Retorn de la pàgina Login.html.
    }
}
