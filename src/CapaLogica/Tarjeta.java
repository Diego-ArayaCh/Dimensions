/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;
import CapaVista.FrmInicio;
import CapaVista.JDialogNotification;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Tarjeta implements Serializable {
    private String numeroTarjeta;
    private int mesVencimiento;
    private int annoVencimiento;
    private ArrayList<Pago> pagos;
    private TipoTarjeta tipoTarjeta;

    public Tarjeta(String numeroTarjeta, int mesVencimiento, int annoVencimiento, ArrayList pagos, TipoTarjeta tipoTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.mesVencimiento = mesVencimiento;
        this.annoVencimiento = annoVencimiento;
        this.pagos = new ArrayList();
        this.tipoTarjeta = tipoTarjeta;
    }
    public Tarjeta(){
        pagos=new ArrayList();
    }
    //Validaciones de tarjeta
   /**
 * Valida que sea correcto
 * @author Diego
 * @return true si la validacion es correcta
*/
    public boolean validarFechaTarjeta(){
    
       if(annoVencimiento>LocalDateTime.now().getYear()){
        return true;
            
            
            
            
            
        }else{
           if(mesVencimiento>=LocalDate.now().getMonthValue()){
               return true;
           }
           
           return false;
        }

       
       
     
    }
     /**
 * Valida que sea correcto
 * @author Diego
 * @return true si la validacion es correcta
*/
     public boolean validarNumeroTarjeta(){
         boolean isLuhn=false;
        
        
        
        int numeros=0;
        int sumatoria=0;
        String cadena="";
        for(int i=0;i<numeroTarjeta.length();i=i+2){
            
           numeros= Integer.parseInt(numeroTarjeta.charAt(i)+"")*2;
            cadena= Integer.toString(numeros);
            if(cadena.length()==2){
                sumatoria= Integer.parseInt(cadena.charAt(0)+"")+Integer.parseInt(cadena.charAt(1)+"")+sumatoria;
            }else{
                sumatoria= Integer.parseInt(cadena)+sumatoria; 
            }
            
            
            
        }
        for(int i=1;i<numeroTarjeta.length()-1;i=i+2){
        
        sumatoria= sumatoria+Integer.parseInt(numeroTarjeta.charAt(i)+"");
        }
        sumatoria=sumatoria*9;
        int numeroValidacion=Integer.parseInt(numeroTarjeta.charAt(numeroTarjeta.length()-1)+"");
        if(sumatoria%10==numeroValidacion){
            isLuhn=true;
            
        }
        return isLuhn;
    }
       
    
      /**
 * Valida que sea correcto
 * @author Diego
 * @return true si la validacion es correcta
*/
     public boolean validarTipoTarjeta(){
         
         
        int subString=Integer.parseInt(numeroTarjeta.substring(0,2));
     if(subString>=51&&subString<=55&&tipoTarjeta.equals(TipoTarjeta.MASTER_CARD)&&numeroTarjeta.length()==16){
          return true;
       }
     
     if(tipoTarjeta.equals(TipoTarjeta.VISA)&&'4'==numeroTarjeta.charAt(0)&&numeroTarjeta.length()==16){
        return true;
    }
     return false;
     
}

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getMesVencimiento() {
        return mesVencimiento;
    }

    public void setMesVencimiento(int mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }

    public int getAnnoVencimiento() {
        return annoVencimiento;
    }

    public void setAnnoVencimiento(int annoVencimiento) {
        this.annoVencimiento = annoVencimiento;
    }

    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
     public void annadirPago(Pago pago){
         pagos.add(pago);
     }
     
}
