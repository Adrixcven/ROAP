/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Adrix
 */
@Data
@Entity
@Table(name = "Cliente")
public class Cliente  implements Serializable {
    //Identificació de la classe per poder deserialitzar de manera correcta
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String DNI;
    
    private String Nombre;
    private int Edat;
    private String Email;
    private int Telefono;
    private int DPostal;
}