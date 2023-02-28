/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.models;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Adrix
 */
@Data
public class ProductAdded {
    private int IDPedido;
    private int IDProducto;
    private int Cantidad;
}
