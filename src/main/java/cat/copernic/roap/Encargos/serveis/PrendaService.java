/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.Encargos.serveis;

import cat.copernic.roap.DAO.PrendaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import cat.copernic.roap.models.Prenda;
import org.springframework.stereotype.Service;

/**
 *
 * @author mfg20
 */
@Service 
public class PrendaService  implements PrendaServiceInterface{   

    
    /*Atribut que defineix un gosDAO. Mitjançant aquest atribut el control ja no 
     *accedirà directament a la capa de dades, si no que accedirà mitjançant la capa de servei.
    */
    @Autowired
    private PrendaDAO prenda;
    
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
    public List<Prenda> listarPrenda() {
        
        /*Cridem al mètode findAll() de CrudRepository perquè ens retorni el llistat de gosos de la BBDD.
         *findAll() retorna un objecte, per tant hem de fer un cast perquè l'objecte sigui un List de gossos
        */
        return (List<Prenda>) prenda.findAll(); 
    }

    /*Afegir el gos passat per paràmetre a la taula gos de la BBDD veterinari*/
    @Override
    /*En aquest cas hi haurà COMMITS i ROLLBACKS, ja que modifiquem la informació de la BBDD, per tant,
     *utilitzarem aquesta notació sense passar-li cap paràmetre perquè es puguin fer els COMMITS 
     *i ROLLBACKS.
    */ 
    @Transactional
    public void anadirPrenda(Prenda prenda) {
        
        /*Cridem al mètode save() de CrudRepository perquè afegeixi el gos passat com a paràmetre,
         *a la taula gos de la BBDD veterinari.
        */
        this.prenda.save(prenda); 
    }

    /*Eliminar el gos passat per paràmetre de la taula gos de la BBDD veterinari*/
    @Override
    @Transactional //Igual que en el mètode afegirGos, modifiquem la informació de la BBDD
    public void eliminarPrenda(Prenda prenda) {
        
        /*Cridem al mètode delete() de CrudRepository perquè elimini el gos passat com a paràmetre,
         *de la taula gos de la BBDD veterinari.
        */
        this.prenda.delete(prenda);
        
    }

    /*Cercar el gos passat per paràmetre en la taula gos de la BBDD veterinari*/
    @Override
    @Transactional(readOnly=true) //Igual que en el mètode llistarGossos, no modifiquem la informació de la BBDD
    public Prenda buscarPrenda(Prenda prenda) {
        
        /*Cridem al mètode findById() de CrudRepository perquè ens retorni el gos passat com a paràmetre.
         *El paràmetre que li passem a aquest mètode, ha de ser la clau primària de l'entitat, en el nostre 
         *cas el gos.
         *
         *Si el gos no existei retornarà null (orElse(null)).
        */ 

        return this.prenda.findById(prenda.getId()).orElse(null);
        
    }
    
}