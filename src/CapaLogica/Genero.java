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
public enum Genero implements Serializable{
    DRAMA{
        @Override
        public String toString() {
            return "Drama";
        }
        
    },
    SUSPENSO{
        @Override
        public String toString() {
            return "Suspenso";
        }
        
    },
    MISTERIO{
        @Override
        public String toString() {
            return "Misterio";
        }
        
    },
    ACCION{
        @Override
        public String toString() {
            return "Acción";
        }
        
    },
    TERROR{
        @Override
        public String toString() {
            return "Terror";
        }
        
    },
    CIENCIA_FICCION{
        @Override
        public String toString() {
            return "Ciencia Ficción";
        }
        
    },
    COMEDIA{
        @Override
        public String toString() {
            return "Comedia";
        }
        
    },
    ROMANTICA{
        @Override
        public String toString() {
            return "Romántica";
        }
        
    };
}
