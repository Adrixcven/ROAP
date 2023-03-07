/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.Pedidos.controladores.*;
import cat.copernic.roap.models.Prenda;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

/**
 *
 * @author Adrix
 */
@Controller
public class ControladorAñadirPrenda {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private PrendaService prendaService;
    @GetMapping("/añadirPrenda")
    public String crearFormularioPrenda(Prenda prenda) {

        return "Encargos/AñadirPrenda"; //Retorna la pàgina on es mostrarà el formulari de les dades dels gos
    }
    
    /*Definim el mètode per assignar els valors introduïts en el formulari a l'objecte gos
     *passat com a paràmetre.
     *
     *L'anotació @PostMapping, indica al sistema que el mètode que fem servir per enviar les dades és
     *post. Com a paràmetre hem de passar el valor de l'action del formulari, d'aquesta manera el sistema 
     *identifica el mètode al qual ha d'enviar les dades introduïdes mitjançant el formulari.
    */   
    @PostMapping("/guardarPrenda") //action=guardarGos
    public String guardarPrenda(Prenda prenda) {

        prendaService.anadirPrenda(prenda); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/encargos"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
