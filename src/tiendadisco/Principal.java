/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendadisco;

import java.awt.BorderLayout;
import javax.swing.JFrame;


/**
 *
 * @author Angie Castañeda
 */
public class Principal extends JFrame{
    
    private PanelImagen pImagen;
    private PanelBotones pBotones;
   
        
    public Principal() {
        setSize(350, 600);
        setTitle("TIENDA DE DISCO");
        setLocation(500, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        pImagen = new PanelImagen();
        pImagen.setBounds(10, 10, 320, 310);
        add(pImagen);
        
        pBotones = new PanelBotones(this);
        pBotones.setBounds(10, 360, 320, 200);
        add(pBotones);
        
        
        setVisible(true);
    }



}
