/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap;

import cat.copernic.roap.DAO.UsuarioDAO;
import cat.copernic.roap.models.Rol;
import cat.copernic.roap.models.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import static org.hibernate.query.sqm.tree.SqmNode.log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Adrix
 */
@Service("userDetailsService")
@Slf4j
public class UsuarioAuth implements UserDetailsService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    /**
     * Carga los detalles de un usuario por su nombre de usuario.
     *
     * @param username el nombre de usuario del usuario a cargar
     * @return los detalles del usuario como un objeto UserDetails
     * @throws UsernameNotFoundException si no se encuentra ningún usuario con el nombre de usuario proporcionado
     */
    @Override 
   @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Busca el usuario por su DNI en el UsuarioDAO
        Usuario usuari = usuarioDAO.findByDNI(username);

        // Si no se encuentra ningún usuario, lanza una excepción
        if (usuari == null) {
            throw new UsernameNotFoundException(username);
        }
        
        // Crea y devuelve un objeto User que implementa UserDetails, utilizando los detalles del usuario encontrado
        return new User(usuari.getNombre(), usuari.getContra(), Collections.singletonList(new SimpleGrantedAuthority(String.valueOf(usuari.getRol()))));// lista de roles del usuario
    }
}
