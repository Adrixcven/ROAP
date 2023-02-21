/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.entidades;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Adrix
 */
@Data
public class Pedidos {
    private String Id;
    private Cliente cliente;
    private Date Fecha;
    private String Email;
    private int Telefono;
    private String DPostal;
}
