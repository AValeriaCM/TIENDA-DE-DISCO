/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendadisco;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Angie Castañeda
 */
public class PanelDisco extends JDialog implements ActionListener{
    
    private JLabel LArtista, LNombreDisco, LPrecio;
    private Disco disco;
    private JComboBox CBArtista;
    private JButton BGuardar;  
    private JTextField JTNombreDisco, JTPrecio;

    
    private List<Cancion> listaCancion;
    private PanelBotones ventana;
    private PanelArtista artistas;
    
    public PanelDisco(PanelBotones ventana) {
        this.ventana = ventana;
        setSize(350, 300);
        setTitle("AGREGAR DISCO");
        setLocation(400, 100);
        setResizable(false);
        setLayout(null);
        
        listaCancion = new ArrayList<Cancion>(); 
        
        LArtista = new JLabel("Artista: ");
        LArtista.setBounds(30, 30, 100, 20);
        add(LArtista);
        
        CBArtista = new JComboBox();
        CBArtista.addItem("Seleccione...");
        
        for (Artista artista : ventana.getListaArtista()) {
            CBArtista.addItem(artista.getNombre());
        }
        
        CBArtista.setBounds(140, 30, 150, 20);
        add(CBArtista);
                
        LNombreDisco = new JLabel ("Nombre:*");
        LPrecio = new JLabel ("Precio:*");
 
        LNombreDisco.setBounds(30, 60, 100, 20);
         add(LNombreDisco);
         
        JTNombreDisco = new JTextField();
        JTNombreDisco.setBounds(140, 60, 150, 20);
        add(JTNombreDisco);
        
        LPrecio.setBounds(30, 90, 100, 20);
        add(LPrecio);

        JTPrecio = new JTextField();
        JTPrecio.setBounds(140, 90, 150, 20);
        add(JTPrecio);
        
        BGuardar = new JButton("Guardar");
        BGuardar.setBounds(140, 150, 150, 20);
        BGuardar.addActionListener(this);
        add(BGuardar);
                  
    }
    
    public void actualizarArtista(String nombreArtista) {
        CBArtista.addItem(nombreArtista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(validarDatos()){
            disco = new Disco(JTNombreDisco.getText(), JTPrecio.getText());
            for (Artista artistaInd : ventana.getListaArtista()) {
                if(CBArtista.getSelectedItem().equals(artistaInd.getNombre())) {
                    artistaInd.getDisco().add(disco);
                }
            }
            
            JOptionPane.showMessageDialog(this, "Disco Agregado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            vaciarDatos();
            
       }
    }
    
    private void vaciarDatos() {
        JTNombreDisco.setText("");
        JTPrecio.setText("");
        LNombreDisco.setForeground(Color.BLACK);
        CBArtista.setSelectedIndex(0);
    }
    
    private boolean validarDatos() {
        if(JTNombreDisco.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LNombreDisco.setForeground(Color.red);
            return false;
        } else if(JTPrecio.getText().equals("") ) {
            JOptionPane.showMessageDialog(this, "Precio es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LPrecio.setForeground(Color.red);
            return false;    
        } else if(CBArtista.getSelectedItem() == ("Seleccione")) {
            JOptionPane.showMessageDialog(this, "Artista es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public List<Cancion> getListaCancion() {
        return listaCancion;
    }

    public void setListaCancion(List<Cancion> listaCancion) {
        this.listaCancion = listaCancion;
    }
    
}
