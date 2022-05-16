/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.io.Serializable;

/**
 *
 * @author Estudiante
 */
public enum TipoTarjeta implements Serializable{
    MASTER_CARD{
        @Override
        public String toString() {
            return "Master Card";
        }
        
    },
    VISA{
        @Override
        public String toString() {
            return "Visa";
        }
        
    };
}
