/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Adrix
 */
@Configuration //Indica al sistema que és una classe de configuració
public class ConfiguracioWeb implements WebMvcConfigurer {

    /**
     * En este método se definen las páginas que se mostrarán al usuario cuando
     * ocurra un evento, sin pasar por un controlador.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registre) {
        registre.addViewController("/inicial").setViewName("index"); // Muestra la página inicial, que se renombra como "index", cuando el usuario no se ha autenticado aún.
        registre.addViewController("/login"); // Muestra la página de inicio de sesión cuando el usuario no ha podido autenticarse.
        registre.addViewController("/errors/error403").setViewName("/errors/error403"); // Muestra la página de error403 cuando el usuario no puede acceder a una página específica.
    }

}
