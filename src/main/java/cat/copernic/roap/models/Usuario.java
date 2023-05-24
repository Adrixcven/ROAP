/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Adrix
 */
@Data
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "DNI")
    private String DNI;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "contra")
    private String contra;
    @Column(name = "edat")
    private int edat;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "dpostal")
    private String dpostal;
    @Column(name = "rol")
    private int rol;
}
