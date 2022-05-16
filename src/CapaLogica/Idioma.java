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
public enum Idioma implements Serializable{
    ESPANOL{
        @Override
        public String toString() {
            return "Español";
        }
        
    },
    INGLES{
        @Override
        public String toString() {
            return "Inglés";
        }
        
    },
    ITALIANO{
        @Override
        public String toString() {
            return "Italiano";
        }
        
    },
    JAPONES{
        @Override
        public String toString() {
            return "Japonés";
        }
        
    },
    PORTUGUES{
        @Override
        public String toString() {
            return "Portugués";
        }
        
    },
    
}
