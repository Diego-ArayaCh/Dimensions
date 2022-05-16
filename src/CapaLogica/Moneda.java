/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.io.Serializable;

/**
 *
 * @author Diego
 */
public enum Moneda implements Serializable {
    Colones(575.0),
    Dolares(1){
        @Override
        public String toString() {
            return "Dólares";
        }
        
    };
    private double cambio=0;
    private Moneda(double cambio){
        this.cambio=cambio;
    }

    public double getCambio() {
        return cambio;
    }
    
}
