/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.controladores;

import cat.copernic.roap.DAO.CategoriasDAO;
import cat.copernic.roap.DAO.PrendaDAO;
import cat.copernic.roap.Encargos.serveis.CategoriaService;
import cat.copernic.roap.Encargos.serveis.PrendaService;
import cat.copernic.roap.models.Categorias;
import cat.copernic.roap.models.Prenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mfg20
 */
@Controller
public class ControladorGestionarCategoria {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de PrendaDAO al controlador
    private CategoriasDAO CategoriasDAO;
    
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de PrendaService al controlador    
    private CategoriaService categoriaService;

    @GetMapping("/gestionarCategoria")
    public String inici(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("categorias", categoriaService.listarCategoria());    
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "Encargos/GestionarCategoria"; //Retorn de la pàgina GestionarPrendas.html
    }
    
    @GetMapping("/eliminarcat/{id}") 
    public String eliminarCategoria(Categorias categorias) {

        /*Eliminem la prenda passat per paràmetre, al qual li correspón l'id de @GetMapping mitjançant 
         *el mètode eliminar de la capa de servei.*/
        
        categoriaService.eliminarCategoria(categorias);
        
        return "redirect:/gestionarCategoria"; //Retornem a la pàgina inicial de gestionar prendas mitjançant redirect
    }
    
    @GetMapping("/editarcat/{id}")
    public String editarCategoria(Categorias categorias, Model model) {

        /*Cerquem la prenda passat per paràmetre, al qual li correspón l'id de @GetMapping mitjançant 
         *el mètode buscarPrenda de la capa de servei.*/
        model.addAttribute("categorias", categoriaService.buscarCategoria(categorias));

        return "Encargos/añadirCategoria"; //Retorna la pàgina amb el formulari de les dades de la prenda
    }
}
