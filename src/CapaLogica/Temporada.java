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
 public  class Temporada implements Serializable{
    private int numeroTemporada;
    private int numeroCapitulos;

    public Temporada(int numeroTemporada, int numeroCapitulos) {
        this.numeroTemporada = numeroTemporada;
        this.numeroCapitulos = numeroCapitulos;
    }

    public int getNumeroCapitulos() {
        return numeroCapitulos;
    }

    @Override
    public String toString() {
        return "\nNúmero de temporada--"+numeroTemporada+"\nNumero de capítulo: " +numeroCapitulos; 
    }
    
    
}
