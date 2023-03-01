/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Pedidos.controladores.*;
import cat.copernic.roap.models.Encargo;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorModificarEncargo {
    @GetMapping("/modificarEncargo")
    public String inici(){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
         var encargo = new Encargo();
        encargo.setUnidades(1);
        encargo.setPrecio(4);
        encargo.setTipo("Camiseta");
        encargo.setEstado("OK");
        encargo.setTalla("L");
        
        var encargo1 = new Encargo();
        encargo.setUnidades(4);
        encargo.setPrecio(15);
        encargo.setTipo("Pantalón");
        encargo.setEstado("OK");
        encargo.setTalla("S");
        
        var encargos = new ArrayList<Encargo>();
        encargos.add(encargo);
        encargos.add(encargo1);
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Encargos/ModificarEncargo"; //Retorn de la pàgina Login.html.
    }
}
