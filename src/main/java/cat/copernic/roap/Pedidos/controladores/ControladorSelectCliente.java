/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.ClienteDAO;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Pedidos;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorSelectCliente {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private ClienteDAO ClienteDAO; //Atribut per poder utilitzar les funcions CRUD de la interfície GosDAO
    @GetMapping("/seleccionarCliente")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("clientes", ClienteDAO.findAll());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Pedidos/SelectCliente"; //Retorn de la pàgina Login.html.
    }
}
