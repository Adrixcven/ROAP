/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.entidades.Cliente;
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
public class ControladorSelectCliente {
    @GetMapping("/seleccionarCliente")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        var cliente = new Cliente();
        cliente.setDNI("12345678T");
        cliente.setNombre("Fran Comido");
        cliente.setEdat(33);
        cliente.setEmail("ejemplo@gmail.com");
        cliente.setTelefono(643235521);
        cliente.setDPostal(22312);
        var cliente1 = new Cliente();
        cliente1.setDNI("12345673T");
        cliente1.setNombre("Fran Comido");
        cliente1.setEdat(35);
        cliente1.setEmail("ejemplo@gmail.com");
        cliente1.setTelefono(643235521);
        cliente1.setDPostal(22312);
        
        var clientes = new ArrayList<Cliente>();
        clientes.add(cliente);
        clientes.add(cliente1);
        //Enviem l'ArrayList de gossos
        model.addAttribute("clientes", clientes);
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/SelectCliente"; //Retorn de la pàgina Login.html.
    }
}
