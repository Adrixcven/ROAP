/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Adrix
 */
public class EncriptadorContrasenya {

    /**
     * Punto de entrada del programa.
     *
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {

        var password = "123";
        System.out.println("Contrasenya: " + password);
        System.out.println("Contrasenya encriptada:" + encriptarContrasenya(password));
    }

    /**
     * Encripta una contraseña utilizando BCryptPasswordEncoder.
     *
     * @param password la contraseña a encriptar
     * @return la contraseña encriptada
     */
    public static String encriptarContrasenya(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}