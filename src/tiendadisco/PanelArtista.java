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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JTextField;

/**
 *
 * @author Angie Castañeda
 */
public class PanelArtista extends JDialog implements ActionListener{
    
    JLabel LArtista, LNombre, LGenero, LNacionalidad;
    JTextField JTNombre;
    JComboBox CMGenero, CBNacionalidad;
    JButton BGuardar;
    
    
    private Artista artista;
    private PanelDisco disco;
    private PanelBotones ventana;
    private List<Disco> listaDisco;
            
    public PanelArtista(PanelBotones ventana) {

        this.ventana = ventana;
        setSize(350, 300);
        setTitle("AGREGAR ARTISTA");
        setLocation(400, 100);
        setResizable(false);
        setLayout(null);
         
        listaDisco = new ArrayList<Disco>();
        
         LArtista = new JLabel ("ARTISTA:");
         LNombre = new JLabel ("Nombre:*");
         LGenero = new JLabel ("Genero:*");
         LNacionalidad = new JLabel ("Nacionalidad:*");
         
         LArtista.setBounds(20, 20, 100, 20);
         
         LNombre.setBounds(30, 30, 100, 20);
         add(LNombre);
         
         LGenero.setBounds(30, 60, 100, 20);
         add(LGenero);

         LNacionalidad.setBounds(30, 90, 100, 20);
         add(LNacionalidad);
         
         JTNombre = new JTextField();
         JTNombre.setBounds(140, 30, 150, 20);
         add(JTNombre);
         
         CMGenero = new JComboBox(Genero.values());
         CMGenero.setBounds(140, 60, 150, 20);
         add(CMGenero);

         CBNacionalidad = new JComboBox(Nacionalidad.values());
         CBNacionalidad.setBounds(140, 90, 150, 20);
         add(CBNacionalidad);
         
         BGuardar = new JButton("Guardar");
         BGuardar.setBounds(140, 120, 150, 20);
         BGuardar.addActionListener(this);
         add(BGuardar);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //String nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
         if(validarDatosArtista()){
            artista = new Artista(JTNombre.getText(), ((Genero) CMGenero.getSelectedItem()), ((Nacionalidad) CBNacionalidad.getSelectedItem()));            
            this.ventana.getListaArtista().add(artista);
            JOptionPane.showMessageDialog(this, "Artista creado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            vaciarDatos();
         //   this.ventana..actualizarArtista(artista.getNombre());
            
       }
    }
    
    private void vaciarDatos() {
        JTNombre.setText("");
        LNombre.setForeground(Color.BLACK);
        CMGenero.setSelectedIndex(0);
        CBNacionalidad.setSelectedIndex(0);
    }
    
    private boolean validarDatosArtista() {
        if(JTNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LNombre.setForeground(Color.red);
            return false;
        } else if(CMGenero.getSelectedItem() == Genero.Seleccione) {
            JOptionPane.showMessageDialog(this, "Genero es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;        
        }  else if(CBNacionalidad.getSelectedItem() == Nacionalidad.Seleccione) {
            JOptionPane.showMessageDialog(this, "Nacionalidad es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;        
        }
        return true;
    }

    public List<Disco> getListaDisco() {
        return listaDisco;
    }

    public void setListaDisco(List<Disco> listaDisco) {
        this.listaDisco = listaDisco;
    }

    
    
}
