/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaVista;

import CapaLogica.AudioVisual;
import CapaLogica.Descarga;
import CapaLogica.Idioma;
import java.awt.Color;
import java.awt.Frame;
import java.io.Serializable;
import javax.swing.JFrame;

/**
 *
 * @author Diego
 */
public class JDialogIdioma extends javax.swing.JDialog implements Serializable{
     private Color colorNormal = new Color(255, 255, 255);
    private Color colorPressed = new Color(22, 160, 133);   
    private Color colorHover = new Color(38, 86, 186);
    
    
    
    //Color para el texto
     private Color colorTextNormal = new Color(0, 0, 0);
    private Color colorTextPressed = new Color(255, 255, 255);
    private Color colorTextHover = new Color(255, 255, 255);
    //Color separador
    
    /**
     * Creates new form JDialogNotificacion
     */
    Descarga descarga;
    FrmNexo nexo;
    public JDialogIdioma(java.awt.Frame parent,boolean modal,Descarga contenido) {
      super(parent, modal);
        initComponents();
       this.nexo=(FrmNexo)parent;
        
   this.setSize(708, 438);
           this.descarga=contenido;
          for (Idioma idioma : contenido.getContenidoDescargado().getListaIdiomasDisponibles()) {
            jCboIdiomasDescarga.addItem(idioma);
        }
       
    }
    
    
    

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBtnAceptar = new javax.swing.JButton();
        jCboIdiomasDescarga = new org.bolivia.combo.SComboBox();
        jLabel1 = new javax.swing.JLabel();

        setTitle("NOTIFICACIÓN");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(colorPressed);
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(colorTextPressed);

        jBtnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check.png"))); // NOI18N
        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.setBorder(null);
        jBtnAceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check2.png"))); // NOI18N
        jBtnAceptar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBtnAceptarMouseMoved(evt);
            }
        });
        jBtnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnAceptarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnAceptarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnAceptarMouseReleased(evt);
            }
        });
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleccione el idioma para su descarga");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(jCboIdiomasDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jCboIdiomasDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(jBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAceptarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAceptarMouseMoved
        jBtnAceptar.setBackground(colorHover);
        jBtnAceptar.setForeground(colorTextHover);
        
    }//GEN-LAST:event_jBtnAceptarMouseMoved

    private void jBtnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAceptarMouseExited
        jBtnAceptar.setBackground(colorNormal);
        jBtnAceptar.setForeground(colorTextNormal);
    }//GEN-LAST:event_jBtnAceptarMouseExited

    private void jBtnAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAceptarMousePressed
        jBtnAceptar.setBackground(this.colorPressed);
        jBtnAceptar.setForeground(colorTextPressed);
    }//GEN-LAST:event_jBtnAceptarMousePressed

    private void jBtnAceptarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAceptarMouseReleased
        jBtnAceptar.setBackground(colorNormal);
        jBtnAceptar.setForeground(colorTextNormal);
    }//GEN-LAST:event_jBtnAceptarMouseReleased

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
    nexo.SetIdioma((Idioma)jCboIdiomasDescarga.getSelectedItem());
        
        
        
        this.dispose();

    }//GEN-LAST:event_jBtnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private org.bolivia.combo.SComboBox jCboIdiomasDescarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
