/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Prenda;
import cat.copernic.roap.models.Producto;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author mfg20
 */
@Controller
public class ControladorAñadirPrenda {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de PrendaService al controlador    
    private PrendaService prendaService;

    @GetMapping("/añadirPrenda")
    public String inici(Model model, Prenda prenda) {
        List<Categorias> categorias = prendaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        return "Encargos/AñadirPrenda";
    }

    public String crearFormularioPrenda(Prenda prenda) {

        return "Encargos/AñadirPrenda"; //Retorna la pàgina on es mostrarà el formulari de les dades dels gos
    }

    /*Definim el mètode per assignar els valors introduïts en el formulari a l'objecte prenda
     *passat com a paràmetre.
     *
     *L'anotació @PostMapping, indica al sistema que el mètode que fem servir per enviar les dades és
     *post. Com a paràmetre hem de passar el valor de l'action del formulari, d'aquesta manera el sistema 
     *identifica el mètode al qual ha d'enviar les dades introduïdes mitjançant el formulari.
     */
    @PostMapping("/guardarPrenda")
    public String guardarPrenda(@Valid Prenda prenda, Errors error) {
        if(error.hasErrors()){ 
             return "Encargos/AñadirPrenda"; 
        }
        prendaService.anadirPrenda(prenda);
        return "redirect:/gestionarPrendas";
    }

}
