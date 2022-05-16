/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 *
 * @author Estudiante
 */
public abstract class AudioVisual implements Serializable{
    protected String codigo;//mantenimiento
    protected String titulo;//mantenimiento
    protected LocalDate annoCreacion;//mantenimiento
    protected ArrayList<Idioma> listaIdiomasDisponibles;//inicializar
    protected   int calificacion=1;//Solo en la ventana de calificación
    protected ArrayList<Integer> calificaciones;
    protected Genero genero;//manteminiento
    protected boolean isOriginal;//mantenimiento
    protected int cantidadDescargas;//descargas

    public AudioVisual(String codigo, String titulo,
            LocalDate annoCreacion, ArrayList<Idioma> listaIdiomasDisponibles,
            int calificacion, Genero genero, boolean isOriginal) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.annoCreacion = annoCreacion;
        cantidadDescargas=0;
        this.calificacion=calificacion;
        this.listaIdiomasDisponibles=listaIdiomasDisponibles;
        this.isOriginal=isOriginal;
        this.genero=genero;
        calificaciones=new ArrayList();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

  

    public void setAnnoCreacion(LocalDate annoCreacion) {
        this.annoCreacion = annoCreacion;
    }

    public ArrayList<Idioma> getListaIdiomasDisponibles() {
        return listaIdiomasDisponibles;
    }

    public void setListaIdiomasDisponibles(ArrayList<Idioma> listaIdiomasDisponibles) {
        this.listaIdiomasDisponibles = listaIdiomasDisponibles;
    }

    public int getCalificacion() {
        return calificacion;
    }
public abstract double costoTotal();
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean isIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(boolean isOriginal) {
        this.isOriginal = isOriginal;
    }

    public int getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(int cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }
    public int promedioCalificación(int n){//Este método se usara en las calificaciones
        int sumatoria=0;
        calificaciones.add(n);
        for (Integer nota : calificaciones) {
            sumatoria+=nota;
        }
        return sumatoria/calificaciones.size();
        
        
    }
       public void aumentarDescarga(){
            cantidadDescargas++;
        }
    @Override
    public String toString() {
        String idiomas="";
        for (Idioma idioma : listaIdiomasDisponibles) {
            idiomas=idiomas+idioma.toString()+"\n";
        }
     
        
        
        
        
        
        return "Título: "+titulo
                +"\nFecha de creación: "+annoCreacion.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"))
                +"\nEs original: "+((isOriginal)?"sí":"no")
                +"\nCalificación: "+calificacion+"\nGénero: "+genero.toString()
                +"\nCantidad de descargas: "+cantidadDescargas+"\nLista de Idiomas \n"+idiomas+"\nCosto total: "+costoTotal()+"\n";
    }
    
   
}
