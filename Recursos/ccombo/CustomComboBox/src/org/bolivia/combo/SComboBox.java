package org.bolivia.combo;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.plaf.ComboBoxUI;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class SComboBox extends JComboBox{
    CustomUI custom ;
    /** Constructor */
    public SComboBox()
    {
        Dimension dimension = new Dimension(200,32);
        setPreferredSize(dimension);
        setSize(dimension);      
        setForeground(Color.WHITE);        
        setBorder(BorderFactory.createLineBorder(new Color(71, 71, 71), 2));
        setUI(CustomUI.createUI(this));                
        setVisible(true);
        custom=new CustomUI();
    }

    
    
    public CustomUI getCustom(){
        return custom;
    }

}