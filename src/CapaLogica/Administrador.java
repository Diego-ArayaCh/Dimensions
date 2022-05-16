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
public class Administrador extends Usuario implements Serializable{
    private final double COSTO_INSCRIPCION=5;

    public Administrador(String correo, String clave, Tarjeta tarjeta, ArrayList<Perfil> arrayPerfil,String nombre) {
        super(correo, clave, tarjeta, arrayPerfil,nombre);
        
    }
     public void AddPerfil(Perfil perfil){
       arrayPerfil.add(perfil);
   }
    
}
