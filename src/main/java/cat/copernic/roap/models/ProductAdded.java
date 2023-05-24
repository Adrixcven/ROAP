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
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Adrix
 */
@Data
@Entity
@Table(name = "Productoanadido")
public class ProductAdded  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int addproductid;
    
    @Column(name = "prendaid")
    @NotEmpty(message = "{NotEmpty.Productoañadido.productoid}")
    private int prendaid;

    @Column(name = "pedidoid")
    @NotEmpty(message = "{NotEmpty.Productoañadido.pedidoid}")
    private int pedidoid;
    
    @Column(name = "cantidad")
    @Positive(message = "{Positive.Productoañadido.Cantidad}")
    private int Cantidad;
}
