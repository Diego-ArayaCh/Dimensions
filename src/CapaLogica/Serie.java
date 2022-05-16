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


/**
 *
 * @author Estudiante
 */
public class Serie extends AudioVisual implements Serializable{
    private ArrayList<Temporada>temporadas;
    private boolean isCompleta;
    private final double PRECIO_BASE=10;
    public Serie(String codigo, String titulo, LocalDate annoCreacion, ArrayList<Idioma> listaIdiomasDisponibles,
            int calificacion,Genero genero, boolean isOriginal) {
        super(codigo, titulo, annoCreacion, listaIdiomasDisponibles,calificacion,genero,isOriginal);
    this.temporadas = new ArrayList();
   
    }
    public void addIdioma(Idioma idioma){
        listaIdiomasDisponibles.add(idioma);
    }
      public void addTemporada(Temporada temp){
       temporadas.add(temp);
    }
  public double costoPorTemporada(){
      double costoPorCapitulo=0;
      int cantidadTemporadas=0;
      
      for (Temporada temporada : temporadas) {
          costoPorCapitulo+=temporada.getNumeroCapitulos()*0.10;
          cantidadTemporadas++;
      }
    
      return costoPorCapitulo+cantidadTemporadas*0.5;
  }
    public double costoSerieNueva(){
        if(annoCreacion.getYear()==LocalDate.now().getYear()){
            if(isOriginal){
                return 0.5;
            }else{
                return 0.75;
            }
        }
        return 0;
    }
    public double costoSubTotal(){
        return costoPorTemporada()+costoSerieNueva();
    }
        public double descuento(){
            if(isCompleta){
                return 0;
            }
           return costoSubTotal()*0.1;
    }
    @Override
    public double costoTotal(){
        return 10+costoSubTotal()-descuento();
        
    }

    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(ArrayList<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isIsCompleta() {
        return isCompleta;
    }

    public void setIsCompleta(boolean isCompleta) {
        this.isCompleta = isCompleta;
    }

    @Override
    public String toString() {
        
         String texto="";
        for (Temporada temporada : temporadas) {
            texto=texto+temporada.toString()+"\n";
        }
        
        
        
        return super.toString()+"\nTipo: Serie"+"\nEstá completa: "+((isCompleta)?"Sí":"No")+"\nNúmero de temporadas: "+temporadas.size()+"\nDesglose de temporadas\n"+texto;
                
    }
    
    
}
