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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Adrix
 */
@Data
@Entity
@Table(name = "Pedidos")
public class Pedidos implements Serializable {
    
    //Identificació de la classe per poder deserialitzar de manera correcta
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;
    
    @Column(name = "cliente")
    @NotEmpty(message = "{NotEmpty.pedido.cliente}")
    private String cliente;
    
    @Column(name = "vendedor")
    @NotEmpty(message = "{NotEmpty.pedido.vendedor}")
    private String vendedor;
    
    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "preciototal")
    @Positive(message = "{Positive.pedido.precioTotal}")
    private float precioTotal;
}
