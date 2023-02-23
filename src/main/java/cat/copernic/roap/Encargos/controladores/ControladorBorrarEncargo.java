/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Pedidos.controladores.*;
import cat.copernic.roap.entidades.Encargo;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorBorrarEncargo {
    @GetMapping("/borrarEncargo")
     public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        var encargo = new Encargo();
        encargo.setNombre("Camiseta frozen chula");
        encargo.setUnidades(1);
        encargo.setPrecio(4);
        encargo.setTipoPrenda("Camiseta");
        encargo.setEstadoPrenda("OK");
        encargo.setTalla("L");
        
        var encargo1 = new Encargo();
        encargo1.setNombre("Pantalon cargo");
        encargo1.setUnidades(4);
        encargo1.setPrecio(15);
        encargo1.setTipoPrenda("Pantalón");
        encargo1.setEstadoPrenda("OK");
        encargo1.setTalla("S");
        
        var encargos = new ArrayList<Encargo>();
        encargos.add(encargo);
        encargos.add(encargo1);
        //Enviem l'ArrayList de gossos
        model.addAttribute("encargos", encargos);return "Encargos/BorrarEncargo"; //Retorn de la pàgina Login.html.
    }
}
