/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Diego
 */
public class Pago implements Serializable{
    private LocalDateTime fecha;
    private double montoPagoColones;
    private double montoPagoDolares;
    private Moneda moneda;

    public Pago(  double montoPagoDolares, Moneda moneda) {
        this.fecha = LocalDateTime.now();
     
        this.montoPagoDolares = montoPagoDolares;
        this.moneda = moneda;
        this.montoPagoColones = conversionColones();
    }
   
    
    
    
    
    
    
    public double conversionColones(){
        
        
        
        return montoPagoDolares*moneda.Colones.getCambio();

}
    
    
    
    
    
    
    
    
    
}

