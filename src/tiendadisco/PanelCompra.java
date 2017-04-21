/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendadisco;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Angie Castañeda
 */
public class PanelCompra extends JDialog implements ActionListener{
    
    JLabel LTitulo, LArtista, LDisco, LCancion, LNombreCliente, LCedula, LPrecio, JTPrecio;
    JTextField JTNombreCliente, JTCedula;
    JComboBox CBArtista, CBDisco, CBCancion;
    JButton BFinalizar;
    
    private PanelBotones ventana;
    private Disco disco11;
    private Cliente cliente;
    private Artista artista;
            
    public PanelCompra(PanelBotones ventana) {

        this.ventana = ventana;
        setSize(350, 300);
        setTitle("GENERA COMPRA");
        setLocation(400, 100);
        setResizable(false);
        setLayout(null);
         
        
         LTitulo = new JLabel ("-----------COMPRA-----------");
         LNombreCliente = new JLabel ("Nombre:*");
         LCedula = new JLabel ("Cedula:*");
         LArtista = new JLabel ("Artista:*");
         LDisco = new JLabel ("Disco:");
         LCancion = new JLabel ("Cancion:");
         
         LArtista.setBounds(20, 20, 100, 20);
         add(LArtista);
         LNombreCliente.setBounds(30, 30, 100, 20);
         add(LNombreCliente);
         
         LCedula.setBounds(30, 60, 100, 20);
         add(LCedula);

         LArtista.setBounds(30, 90, 100, 20);
         add(LArtista);
         
         LDisco.setBounds(30, 120, 100, 20);
         add(LDisco);
         
         LCancion.setBounds(30, 150, 100, 20);
         add(LCancion);
         
         JTNombreCliente = new JTextField();
         JTNombreCliente.setBounds(140, 30, 100, 20);
         add(JTNombreCliente);
         
         JTCedula = new JTextField();
         JTCedula.setBounds(140, 60, 100, 20);
         add(JTCedula);
         
         CBArtista = new JComboBox();
         CBArtista.addItem("Seleccione...");
         
        for (Artista artista : ventana.getListaArtista()) {
            CBArtista.addItem(artista.getNombre());
        }
         
         CBArtista.setBounds(140, 90, 100, 20);
         add(CBArtista);

         CBDisco = new JComboBox();
         CBDisco.addItem("Seleccione...");
         
         for (Artista artista : ventana.getListaArtista()) {
             for (Disco disco : artista.getDisco()){
                CBDisco.addItem(disco.getNombreDisco());
             }
        }
         
         CBDisco.setBounds(140, 120, 100, 20);
         add(CBDisco);
         
         CBCancion = new JComboBox();
         CBCancion.addItem("Seleccione...");
         
         
        for (Artista artista : ventana.getListaArtista()) {
             for (Disco disco : artista.getDisco()){
                 for(Cancion cancion : disco.getCancion()){
                    CBCancion.addItem(cancion.getNombreCancion());
                 }
             }
        }
         
         CBCancion.setBounds(140, 150, 100, 20);
         add(CBCancion);
         
         LPrecio = new JLabel();
         LPrecio.setBounds(30, 180, 100, 20);
         add(LPrecio);
         
         JTPrecio = new JLabel(disco11.getPrecio());
         JTPrecio.setBounds(140, 180, 100, 20);
         add(JTPrecio);
         
         BFinalizar = new JButton("Finalizar Compra");
         BFinalizar.setBounds(140, 180, 200, 20);
         BFinalizar.addActionListener(this);
         add(BFinalizar);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(validarDatosCliente()){
            cliente = new Cliente(JTNombreCliente.getText(), JTCedula.getText());            
            this.ventana.getListaCliente().add(cliente);
            JOptionPane.showMessageDialog(this, "Gracias Por Su Compra.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            vaciarDatos();
            
       }
    }
    
    private void vaciarDatos() {
        JTNombreCliente.setText("");
        JTCedula.setText("");
        LNombreCliente.setForeground(Color.BLACK);
        CBArtista.setSelectedIndex(0);
        CBDisco.setSelectedIndex(0);
        CBCancion.setSelectedIndex(0);
    }
    
    private boolean validarDatosCliente() {
        if(JTNombreCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LNombreCliente.setForeground(Color.red);
            return false;
        } else if(CBArtista.getSelectedItem().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(this, "Artista es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LArtista.setForeground(Color.red);
            return false;        
        }  else if(CBDisco.getSelectedItem().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(this, "Es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;        
        }
        return true;
    }

}
