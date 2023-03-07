package cat.copernic.roap.ERP.serveis;

/*Classe servei que farà de capa intermitja entre la capa de presentació (MVC) i la capa de dades
 *i que implementa la interface GosServiceInterface*/

import cat.copernic.roap.Pedidos.servicios.*;
import cat.copernic.roap.DAO.ClienteDAO;
import cat.copernic.roap.DAO.DevolucionDAO;
import cat.copernic.roap.DAO.EnvioDAO;
import cat.copernic.roap.DAO.PedidosDAO;
import cat.copernic.roap.DAO.UsuarioDAO;
import cat.copernic.roap.models.Cliente;
import cat.copernic.roap.models.Devolucion;
import cat.copernic.roap.models.Envio;
import cat.copernic.roap.models.Pedidos;
import cat.copernic.roap.models.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fta
 */

/*Anotació que permet al sistema que reconegui aquesta classe com una classe de servei
 *i que permet injectar aquesta classe en el controlador
*/
@Service 
public class UsuariosService implements UsuariosServiceInterface{   

    
    /*Atribut que defineix un gosDAO. Mitjançant aquest atribut el control ja no 
     *accedirà directament a la capa de dades, si no que accedirà mitjançant la capa de servei.
    */
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    /*Quan treballem en la capa de servei amb classes de tipus DAO, com és el cas, estem
     *treballant amb transaccions SQL, és a dir, quan fem una consulta a la BBDD, si aquesta
     *ha estat un èxit, el sistema ha de fer un COMMIT, en cas contrari un ROLLBACK. Així doncs,
     *mitjançant la notació @Transactional l'indiquem al sistema que el mètode és una transacció.
     *Això permet que no hi hagi problemes si estem fent més d'una transacció al mateix temps.
    */

    /*LListar gossos de la taula gos de la BBDD veterinari*/
    @Override
    /*La notació @Transactional fa referència a la classe Transactional de Spring Framework.
     *En aquest cas no hi haurà ni COMMITS, ni ROLLBACKS, ja que no modifiquem la informació
     *de la BBDD, per tant, utilitzarem aquesta notació passant-li com a paràmetre readOnly=true
     *perquè només hem de llegir de la BBDD.
    */    
    @Transactional(readOnly=true) 
    public List<Usuario> listarUsuario() {
        
        /*Cridem al mètode findAll() de CrudRepository perquè ens retorni el llistat de gosos de la BBDD.
         *findAll() retorna un objecte, per tant hem de fer un cast perquè l'objecte sigui un List de gossos
        */
        return (List<Usuario>) usuarioDAO.findAll(); 
    }

    /*Afegir el gos passat per paràmetre a la taula gos de la BBDD veterinari*/
    @Override
    /*En aquest cas hi haurà COMMITS i ROLLBACKS, ja que modifiquem la informació de la BBDD, per tant,
     *utilitzarem aquesta notació sense passar-li cap paràmetre perquè es puguin fer els COMMITS 
     *i ROLLBACKS.
    */ 
    @Transactional
    public void addUsuario(Usuario usuario) {
        
        /*Cridem al mètode save() de CrudRepository perquè afegeixi el gos passat com a paràmetre,
         *a la taula gos de la BBDD veterinari.
        */
        this.usuarioDAO.save(usuario); 
    }

    /*Eliminar el gos passat per paràmetre de la taula gos de la BBDD veterinari*/
    @Override
    @Transactional //Igual que en el mètode afegirGos, modifiquem la informació de la BBDD
    public void eliminarUsuario(Usuario usuario) {
        
        /*Cridem al mètode delete() de CrudRepository perquè elimini el gos passat com a paràmetre,
         *de la taula gos de la BBDD veterinari.
        */
        this.usuarioDAO.delete(usuario);

    }

    /*Cercar el gos passat per paràmetre en la taula gos de la BBDD veterinari*/
    @Override
    @Transactional(readOnly=true) //Igual que en el mètode llistarGossos, no modifiquem la informació de la BBDD
    public Usuario buscarUsuario(Usuario usuario) {
        
        /*Cridem al mètode findById() de CrudRepository perquè ens retorni el gos passat com a paràmetre.
         *El paràmetre que li passem a aquest mètode, ha de ser la clau primària de l'entitat, en el nostre 
         *cas el gos.
         *
         *Si el gos no existei retornarà null (orElse(null)).
        */ 

        return this.usuarioDAO.findById(usuario.getDNI()).orElse(null);
        
    }
    
}
