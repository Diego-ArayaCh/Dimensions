/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import CapaLogica.Administrador;
import CapaLogica.Corporativo;
import CapaLogica.Residente;
import CapaLogica.Usuario;

/**
 *
 * @author Diego
 */
public  class ValidacionUsuario {
    public static boolean isResidencial(Usuario usuario){
        if(usuario instanceof Residente){
            return true;
        }
        return false;
    }
    public static boolean isCorporativo(Usuario usuario){
        if(usuario instanceof Corporativo){
            return true;
        }
        return false;
    }
    public static boolean isAdministrador(Usuario usuario){
        if(usuario instanceof Administrador){
            return true;
        }
        return false;
    }
    
}
