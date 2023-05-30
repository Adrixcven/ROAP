/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Adrix
 */
/*Classe de configuració de Spring Security per configurar l'accés d'usuaris (autenticació).
 *Aquesta classe ha d'extendre de la classe WebSecurityConfigurerAdapter de Spring Security per poder
 *autenticar els usuaaris.
 */
@Configuration //Indica al sistema que és una classe de configuració
@EnableWebSecurity //Habilita la seguretat web
@Slf4j
public class WebApplication {

    @Autowired
    private UsuarioAuth UserDetailsService; 

    /**
     * Configura la autenticación del sistema.
     * Inyecta los métodos de la clase AuthenticationManagerBuilder y utiliza el método userDetailsService para realizar la autenticación.
     * El usuario introducido en el formulario de autenticación es pasado como parámetro al método loadUserByUsername implementado en UsuariService.
     * El método passwordEncoder se llama con un objeto de tipo BCryptPasswordEncoder() para encriptar la contraseña introducida por el usuario durante la autenticación
     * y compararla con la contraseña encriptada almacenada en la base de datos correspondiente al nombre de usuario introducido durante la autenticación.
     * 
     * @param auth AuthenticationManagerBuilder utilizado para configurar la autenticación.
     * @throws Exception si ocurre algún error durante la configuración de la autenticación.
     */
    @Autowired
    public void autenticacio(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(UserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }


    /**
     * Configura la autorización del sistema.
     * Utiliza el método filterChain para configurar el acceso de los usuarios a la aplicación según sus roles, lo que se conoce como autorización.
     * Se pasa un objeto de la clase HttpSecurity de Spring Security como parámetro, lo que permite llamar a los métodos para configurar las restricciones de acceso a la aplicación.
     * 
     * @param http HttpSecurity utilizado para configurar la autorización.
     * @return SecurityFilterChain configurado con las restricciones de acceso.
     * @throws Exception si ocurre algún error durante la configuración de la autorización.
     */
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf().disable().authorizeHttpRequests((requests) -> requests
                .requestMatchers("/pedidos", "/pedidos/**").hasAnyAuthority("1", "3")
                .requestMatchers("/encargos", "/gestionusers", "/gestionmodulo").hasAuthority("1")
                .requestMatchers("/encargosproveedor").hasAuthority("2")
                .requestMatchers("/remember", "/gestionusers/adduser", "/guardarUsuario", "/**").permitAll()
                .anyRequest().authenticated() 
                )
                .formLogin((form) -> form 
                .loginPage("/login")  
                .permitAll() 
                .defaultSuccessUrl("/inicial")
                )
                .httpBasic()
                .and()
                .logout()
                .and()
                .exceptionHandling((exception) -> exception 
                .accessDeniedPage("/errors/error403"))
                .build();
    }
    

}