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
 * @author Estudianteimplements
 */
public class Residente extends Usuario implements Serializable{
    protected final double  COSTO=5;

    public Residente(String correo, String clave, Tarjeta tarjeta, ArrayList<Perfil> arrayPerfil, String nombre) {
        super(correo, clave, tarjeta, arrayPerfil, nombre);
    }
    public void addPerfil(Perfil perfil){
       arrayPerfil.add(perfil);
    }
    public Residente() {
        super();
    }
   
    
}
