/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Pedidos.controladores;

import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.Pedidos.servicios.EnvioService;
import cat.copernic.roap.models.Envio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorModificarEnvio {
    @Autowired 
    private EnvioDAO EnvioDAO; 
    @Autowired 
    private EnvioService envioService;
    /**
     * Método que muestra el formulario de edición de un envío de pedido.
     *
     * @param envio  el envío a editar
     * @param model  el modelo utilizado para almacenar los atributos de la vista
     * @return la página "Pedidos/ModificarEnvio" con el formulario de edición
     */
    @GetMapping("/pedidos/editarenvio/{ID}")
    public String editarEnvio(Envio envio, Model model) {

        /*Cerquem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode cercarGos de la capa de servei.*/
        model.addAttribute("envio", envioService.buscarEnvio(envio));

        return "Pedidos/ModificarEnvio"; //Retorna la pàgina amb el formulari de les dades del gos
    }
}
