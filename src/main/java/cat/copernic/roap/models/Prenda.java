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
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author mfg20
 */
@Data
@Entity
@Table(name = "Prenda")
public class Prenda implements Serializable {
    
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    private int unidades;
    private float precio;
    private String tipo;
    private String estado;
    private int talla;
    private String color;
    @Column(name = "categoria")
    private int categoria;
}
