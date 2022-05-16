/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Estudiante
 */
public class Pelicula extends AudioVisual implements Serializable{
    private boolean isOscar;
    private String director;
    private final double PRECIO_BASE=3.0;
    
    public Pelicula(String codigo, String titulo, LocalDate annoCreacion, ArrayList<Idioma> listaIdiomasDisponibles,
            int calificacion,Genero genero,boolean isOriginal) {
        super(codigo, titulo, annoCreacion, listaIdiomasDisponibles, calificacion,genero,isOriginal);
        
    }
      public double costoMes(){
        
        
       return 0;
    }
    public double costoIsOriginal(){
        if(isOriginal){
            return 2;
        }
        return 5;
    }
    public double costoAnteriorMes(){
        if(!annoCreacion.getMonth().equals(LocalDate.now().getMonth())
                && annoCreacion.getYear()==LocalDate.now().getYear()&&(genero.equals(Genero.CIENCIA_FICCION)
                || genero.equals(Genero.TERROR) || genero.equals(Genero.MISTERIO))){
            return 0.5;
        }
        return 0;
    }
    public double costoAnteriorAnno(){
        if(annoCreacion.getYear()<LocalDate.now().getYear()&&isOscar){
            return 2;
        }
    return 0;
}   //Ahora se sumaran los costos adicionales más el total
    @Override
    public double costoTotal(){
        double costo =0;
        if (annoCreacion.getMonth().equals(LocalDateTime.now().getMonth())&&annoCreacion.getYear()==LocalDate.now().getYear()) {
            
           costo= costoIsOriginal();   
        }
        return costoAnteriorAnno()+costoAnteriorMes()+costo+PRECIO_BASE;
    }

    public boolean isIsOscar() {
        return isOscar;
    }

    public void setIsOscar(boolean isOscar) {
        this.isOscar = isOscar;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return super.toString()+"Óscar: "+((isOscar)?"sí":"no")+"\nDirector: "+director;
    }

    public void addIdioma(Idioma idioma) {
       listaIdiomasDisponibles.add(idioma);
    }
    
}