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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Adrix
 */
@Data
@Entity
@Table(name = "Producto")
public class Producto implements Serializable {
    
    //Identificació de la classe per poder deserialitzar de manera correcta
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;
    @Column(name = "nombre")
    @NotEmpty(message = "{NotEmpty.producto.nombre}")
    private String nombre;
    @Column(name = "unidades")
    @PositiveOrZero(message = "{PositiveOrZero.producto.unidades}")
    private int unidades;
    @Column(name = "precio")
    @PositiveOrZero(message = "{PositiveOrZero.producto.precio}")
    private float precio;
    @Column(name = "prendaropa")
    private String prendaropa;
    @Column(name = "estadoproducto")
    private String estadoproducto;
    @Column(name = "talla")
    private int talla;
    @Column(name = "color")
    @NotEmpty(message = "{NotEmpty.producto.color}")
    private String color;
    @Column(name = "categoria")
    @PositiveOrZero(message = "{PositiveOrZero.producto.categoria}")
    private int categoria;
}
