/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.roap.entidades;

import java.sql.Time;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Adrix
 */
@Data
public class Envio {
    private int ID;
    private String IDPedido;
    private Date Fecha;
    private Time Hora;
    private String Estado;
    private ProductAdded pertenencia;
}
