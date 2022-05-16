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
 * @author Diego
 */
public class Perfil implements Serializable {
    String perfil;
    ArrayList<Descarga> arrayDescargas;
    public Perfil(String perfil) {
        this.perfil=perfil;
        arrayDescargas=new ArrayList();
    }
    public void agregarDescarga(Descarga descarga){
        arrayDescargas.add(descarga);
    }

    public ArrayList<Descarga> getArrayDescargas() {
        return arrayDescargas;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setArrayDescargas(ArrayList<Descarga> arrayDescargas) {
        
        this.arrayDescargas = arrayDescargas;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
}
