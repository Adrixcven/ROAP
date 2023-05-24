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

    @Override 
   @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuari = usuarioDAO.findByDNI(username);

        if (usuari == null) {

            throw new UsernameNotFoundException(username);

        }
        
        return new User(usuari.getNombre(), usuari.getContra(), Collections.singletonList(new SimpleGrantedAuthority(String.valueOf(usuari.getRol()))));
    }
}
