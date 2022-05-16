/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import CapaAccesoDatos.PersistenciaUsuario;
import CapaLogica.Perfil;
import CapaVista.FrmInicio;
import CapaVista.JDialogNotification;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Diego
 */
public class ValidacionFrame {
    public static boolean jTxt(String texto,JDialogNotification notificacion,JTextField campo) {
           if (texto.equals("")) {
  
            notificacion.setLocationRelativeTo(new FrmInicio().getRootPane());
            notificacion.setVisible(true);
            campo.requestFocus(true);
           return false;
        }
           return true;
    }
    
    public static boolean jRdb(JDialogNotification notificacion,JRadioButton botonRadial1, JRadioButton botonRadial2) {
           if(!botonRadial1.isSelected()&&!botonRadial2.isSelected()){
            notificacion.setLocationRelativeTo(JOptionPane.getRootFrame());
            notificacion.setVisible(true);
            botonRadial1.requestFocus(true);
            return false;
        
        }
           return true;
    }
    public static boolean correoElectronico(String correo,JDialogNotification notificacion){
         Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        

        Matcher mather = pattern.matcher(correo);

        if (mather.find() == true) {
            return true;
        } else {
            notificacion.setLocationRelativeTo(JOptionPane.getRootFrame());
            notificacion.setVisible(true);
            return false;
        }
    }
    public static boolean soloEnteros(String texto,JDialogNotification notificacion){
         try {
            long numeroTarjeta=Long.parseLong(texto);
             
        } catch (Exception e) {
             notificacion.setLocationRelativeTo(JOptionPane.getRootFrame());
            notificacion.setVisible(true);
           return false;
        }
return true;
    }
    public static boolean contrasenna(String texto,JDialogNotification notificacion){
    
        
        
         
            if(texto.equals("")){
                notificacion.setLocationRelativeTo(JOptionPane.getRootFrame());
            notificacion.setVisible(true);
                return false;
            }
      
       
        return true;
    }
    public static String obtenerContrasenna(char[] password){
        String hilera="";
         for (char c : password) {
            hilera+=c;
        }
        return hilera;
        
        
    }
    public static boolean perfilVacio(JTextField campo, JDialogNotification not){
        
            if(!campo.getText().isEmpty()){
                
               return true;
                
                
            }else{
                not.setLocationRelativeTo(JOptionPane.getRootFrame());
                not.setVisible(true);
                return false;
            }
        
        
        
        
    
        
    }

    public static void perfilesActivos(JButton p1, JButton p2, JButton p3, JButton p4, JButton p5, int CantidadPerfiles)  {
        ArrayList<Perfil> perfiles=PersistenciaUsuario.getArrayPerfiles();
        
        if(CantidadPerfiles==1){
            p1.setVisible(true);
            p1.setText(perfiles.get(0).getPerfil());
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
        }
        if(CantidadPerfiles==2){
            p1.setVisible(true);
            p1.setText(perfiles.get(0).getPerfil());
            p2.setVisible(true);
            p2.setText(perfiles.get(1).getPerfil());
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
        }
        if(CantidadPerfiles==3){
            p1.setVisible(true);
            p1.setText(perfiles.get(0).getPerfil());
            p2.setVisible(true);
            p2.setText(perfiles.get(1).getPerfil());
            p3.setVisible(true);
            p3.setText(perfiles.get(2).getPerfil());
            p4.setVisible(false);
            p5.setVisible(false);
        }
         if(CantidadPerfiles==4){
            p1.setVisible(true);
            p1.setText(perfiles.get(0).getPerfil());
            p2.setVisible(true);
            p2.setText(perfiles.get(1).getPerfil());
            p3.setVisible(true);
            p3.setText(perfiles.get(2).getPerfil());
            p4.setVisible(true);
            p4.setText(perfiles.get(3).getPerfil());
            p5.setVisible(false);
        }
         
         if(CantidadPerfiles==5){
            p1.setVisible(true);
            p1.setText(perfiles.get(0).getPerfil());
            p2.setVisible(true);
            p2.setText(perfiles.get(1).getPerfil());
            p3.setVisible(true);
            p3.setText(perfiles.get(2).getPerfil());
            p4.setVisible(true);
            p4.setText(perfiles.get(3).getPerfil());
            p5.setVisible(true);
            p5.setText(perfiles.get(4).getPerfil());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
  
    }

    public static boolean perfilesIguales(ArrayList<Perfil> arrayPerfil,JDialogNotification notification) {
        String perfil1="";
         String perfil2="";
        
        for (int i = 0; i < arrayPerfil.size(); i++) {
            perfil1=arrayPerfil.get(i).getPerfil();
            for (int j = 1; j < arrayPerfil.size(); j++) {
                perfil2=arrayPerfil.get(j).getPerfil();
               
                if(perfil1.equals(perfil2)&&i!=j){
                    notification.setLocationRelativeTo(JOptionPane.getRootFrame());
                    notification.setVisible(true);
                    
                    return true;
                    
                }
            }
        }
        return false;
    }
    public static String precioEnLetras(int num){
        if(num >2000000)
            return "DOS MILLONES";
        
        switch(num){
            case 0: return "CERO";
            case 1: return "UN"; 
            case 2: return "DOS";
            case 3: return "TRES";
            case 4: return "CUATRO";
            case 5: return "CINCO"; 
            case 6: return "SEIS";
            case 7: return "SIETE";
            case 8: return "OCHO";
            case 9: return "NUEVE";
            case 10: return "DIEZ";
            case 11: return "ONCE"; 
            case 12: return "DOCE"; 
            case 13: return "TRECE";
            case 14: return "CATORCE";
            case 15: return "QUINCE";
            case 20: return "VEINTE";
            case 30: return "TREINTA";
            case 40: return "CUARENTA";
            case 50: return "CINCUENTA";
            case 60: return "SESENTA";
            case 70: return "SETENTA";
            case 80: return "OCHENTA";
            case 90: return "NOVENTA";
            case 100: return "CIEN";
            
            case 200: return "DOSCIENTOS";
            case 300: return "TRESCIENTOS";
            case 400: return "CUATROCIENTOS";
            case 500: return "QUINIENTOS";
            case 600: return "SEISCIENTOS";
            case 700: return "SETECIENTOS";
            case 800: return "OCHOCIENTOS";
            case 900: return "NOVECIENTOS";
            
            case 1000: return "MIL";
            
            case 1000000: return "UN MILLON";
            case 2000000: return "DOS MILLONES";
        }
        if(num<20){
           
            return "DIECI"+ precioEnLetras(num-10);
        }
        if(num<30){
        
            return "VEINTI" + precioEnLetras(num-20);
        }
        if(num<100){
          
            return precioEnLetras((int)(num/10)*10 ) + " Y " + precioEnLetras(num%10);
        }        
        if(num<200){
          
            return "CIENTO " + precioEnLetras(num - 100 );
        }         
        if(num<1000){
          
            return precioEnLetras((int)(num/100)*100 ) + " " + precioEnLetras(num%100);
        } 
        if(num<2000){
         
            return "MIL " + precioEnLetras(num % 1000 );
        } 
        if(num<1000000){
            String var="";
           
            var = precioEnLetras((int)(num/1000)) + " MIL" ;
            if(num% 1000!=0){
            
                var += " " + precioEnLetras(num % 1000);
            }
            return var;
        }
        if(num<2000000){
            return "UN MILLON " + precioEnLetras(num % 1000000 );
        } 
        return "";  
    }
    
    
    
    
    
}
