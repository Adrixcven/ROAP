/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.DAO.ProductoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorModificarPedidos {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private PedidosDAO PedidosDAO; 
    private EnvioDAO EnvioDAO; 
    private ProductoDAO ProductoDAO;
    @GetMapping("/modificarpedidos")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("productos", ProductoDAO.findAll());
        var envioej = EnvioDAO.findById(1);
        model.addAttribute("envioej", envioej);
        var pedidoej = PedidosDAO.findById(1);
        model.addAttribute("pedidoej", pedidoej);
        return "Pedidos/ModificarPedidos"; //Retorn de la pàgina Login.html.
    }
}
