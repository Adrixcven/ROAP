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
public class Devolucion {
    private int ID;
    private String Cliente;
    private Date Fecha;
    private String Estado;
}
