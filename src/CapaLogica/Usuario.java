/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class  Usuario implements Serializable{
    //ATRIBUTOS
    protected String correo;
    protected String clave;
    protected Tarjeta tarjeta;
    protected String nombre;
    protected ArrayList<Perfil> arrayPerfil;       
    //Para el reporte de descargas recorrer los perfiles y sacar todas las descargas de estos
    
   
    //Constructor para los usuarios regulares
    

    public Usuario(String correo, String clave, Tarjeta tarjeta, ArrayList<Perfil> arrayPerfil, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.tarjeta = tarjeta;
        this.nombre=nombre;
      
        this.arrayPerfil = new ArrayList();
    }
    
    public Usuario() {
        this.arrayPerfil=new ArrayList();
    }
    

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

   

    public ArrayList<Perfil> getArrayPerfil() {
        return arrayPerfil;
    }

    public void setArrayPerfil(ArrayList<Perfil> arrayPerfil) {
        this.arrayPerfil = arrayPerfil;
    }

  
     
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

  public void actualizarPerfil(Perfil perfil,ArrayList<Descarga> descarga){
     
      ArrayList<Perfil> arrayTemp=new ArrayList();
      for (Perfil perfil1 : arrayPerfil) {
          if(perfil1.getPerfil().equals(perfil.getPerfil())){
             if(!descarga.isEmpty()){
                  perfil1=perfil;
//                 for (Descarga descarga1 : descarga) {
//                     perfil1.agregarDescarga(descarga1);
//                 }
             }
              
             
          }
          arrayTemp.add(perfil1);
      }
      
      arrayPerfil=arrayTemp;
      
      
      
  }
    
}
