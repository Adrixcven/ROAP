/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.Encargos.serveis.CategoriaService;
import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Prenda;
import cat.copernic.roap.models.Producto;
import jakarta.validation.Valid;
import static org.aspectj.bridge.MessageUtil.error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

/**
 *
 * @author mfg20
 */
@Controller
public class ControladorAñadirCategoria {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de PrendaService al controlador    
    private CategoriaService categoriaService;

    @GetMapping("/añadirCategoria")
    public String inici(Model model, Categorias categorias) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        //model.addAttribute("categorias", categoriaService.listarCategorias());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
        String username = authentication.getName();
        model.addAttribute("username", username);
        model.addAttribute("rolUsuario", rolUsuario);
        return "Encargos/añadirCategoria"; //Retorn de la pàgina Login.html.
    }

    public String crearFormularioCategoria(Categorias categorias) {

        return "Encargos/añadirCategoria"; //Retorna la pàgina on es mostrarà el formulari de les dades dels gos
    }

    /*Definim el mètode per assignar els valors introduïts en el formulari a l'objecte prenda
     *passat com a paràmetre.
     *
     *L'anotació @PostMapping, indica al sistema que el mètode que fem servir per enviar les dades és
     *post. Com a paràmetre hem de passar el valor de l'action del formulari, d'aquesta manera el sistema 
     *identifica el mètode al qual ha d'enviar les dades introduïdes mitjançant el formulari.
     */
    @PostMapping("/guardarCategoria")
    public String guardarCategoria(@Valid Categorias categorias, Errors errors, Model model) {
        if (errors.hasErrors()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String rolUsuario = authentication.getAuthorities().iterator().next().getAuthority();
            String username = authentication.getName();
            model.addAttribute("username", username);
            model.addAttribute("rolUsuario", rolUsuario);
            return "Encargos/añadirCategoria";
        }

        categoriaService.anadirCategoria(categorias);

        return "redirect:/gestionarCategoria";
    }

}
