/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.Pedidos.servicios.ClienteService;
import cat.copernic.roap.Pedidos.servicios.ProductAddService;
import cat.copernic.roap.Pedidos.servicios.DevolucionService;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorAddCliente {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private ClienteService clienteService;
    @GetMapping("/addclient")
    public String inici(Cliente cliente){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/AddCliente"; //Retorn de la pàgina Login.html.
    }
    @PostMapping("/guardarCliente") //action=guardarGos
    public String guardarCliente(Cliente cliente) {

        clienteService.addCliente(cliente); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/seleccionarCliente"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
