/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Estudiante
 */
public class Descarga implements Serializable{//Hacer archivador de descargas
    
    private LocalDateTime fechaYHora;
    private AudioVisual contenidoDescargado;
    //Numeración de las descargas
    private static int numDescargas=1;
    private int numeroID;
    private Idioma idioma;
String user="";
    public Descarga( AudioVisual contenidoDescargado) {
      
        this.fechaYHora = LocalDateTime.now();
        this.contenidoDescargado = contenidoDescargado;
        this.numeroID = numDescargas;
        this.numDescargas++;
        this.idioma=idioma;
        
    }

    @Override
    public String toString() {
        return user+" #"+numeroID+" -- "+contenidoDescargado.titulo+" Hace:"+
                fechaYHora.format(DateTimeFormatter.ofPattern("dd/MM/YYYY hh:mm a"))+"  Idioma: "+idioma.toString();
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public AudioVisual getContenidoDescargado() {
        return contenidoDescargado;
    }

    public void setContenidoDescargado(AudioVisual contenidoDescargado) {
        this.contenidoDescargado = contenidoDescargado;
    }

    public static int getNumDescargas() {
        return numDescargas;
    }

    public static void setNumDescargas(int numDescargas) {
        Descarga.numDescargas = numDescargas;
    }

    public int getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(int numeroID) {
        this.numeroID = numeroID;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Idioma getIdioma() {
        return idioma;
    }
    
    public int getDescargas(){
        int n=numDescargas;
        return n;
    }

    public void setUser(String user) {
       this.user=user;
    }
    
}
