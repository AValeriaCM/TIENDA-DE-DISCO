/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendadisco;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Angie Castañeda
 */
public class PanelFactura  extends JDialog {
    /*atributos de la clase*/
    private JPanel panelFactura;
    private JTextArea factura;
    private PanelBotones ventana;
    private PanelCompra compra;
    /*constructor de la clase*/
    public PanelFactura(PanelBotones ventana){
        this.ventana =ventana;
        setLocation(400, 100);
        setSize(300,300);
        setTitle("Compra");
        
        panelFactura = new JPanel();
        panelFactura.setBorder(BorderFactory.createTitledBorder("COMPRA"));
        panelFactura.setBackground(Color.WHITE);
        panelFactura.setLayout(null);
        add(panelFactura);
        
        factura = new JTextArea("              Compra Realizada\n\n\tTienda de Disco Andy\n\tUniversidad de Cundinamarca"
                + "\n------------------------------------------------------------------\n\tDisco comprado:XXXXXX\n\tPrecio: 0000000\n\n\tGracias por su compra...\n");
         factura.setBounds(30, 50, 300, 300);
         add(factura);
    }
    
}
