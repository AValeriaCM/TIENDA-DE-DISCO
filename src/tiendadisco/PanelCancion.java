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
public class PanelCancion extends JDialog  implements ActionListener,ItemListener{
    
    private JLabel LArtista, LDisco, LNombreCancion, LDuracion;
    private Disco disco;
    private Cancion cancion;
    private JComboBox CBArtista, CBDisco;
    private JButton BGuardar;  
    private JTextField JTNombreCancion, JTDuracion;
    
    private PanelArtista artista;    
    private PanelBotones ventana;
    //private PanelDisco discos;
    
    public PanelCancion(PanelBotones ventana) {
        this.ventana = ventana;
        setSize(350, 300);
        setTitle("AGREGAR CANCION");
        setLocation(400, 100);
        setResizable(false);
        setLayout(null);
        
         
        LArtista = new JLabel("Artista: ");
        LArtista.setBounds(30, 30, 100, 20);
        add(LArtista);
        
        CBArtista = new JComboBox();
        CBArtista.addItem("Seleccione...");
        
        for (Artista artista : ventana.getListaArtista()) {
            CBArtista.addItem(artista.getNombre());
        }
        
        CBArtista.setBounds(140, 30, 150, 20);
        CBArtista.addItemListener(this);
        add(CBArtista);
        
        LDisco = new JLabel("Disco: ");
        LDisco.setBounds(30, 60, 100, 20);
        add(LDisco);
        
        CBDisco = new JComboBox();
        CBDisco.addItem("Seleccione...");
         
        CBDisco.setBounds(140, 60, 150, 20);
        add(CBDisco);
                
        LNombreCancion = new JLabel ("Nombre:*"); 
        LNombreCancion.setBounds(30, 90, 100, 20);
         add(LNombreCancion);
         
        JTNombreCancion = new JTextField();
        JTNombreCancion.setBounds(140, 90, 150, 20);
        add(JTNombreCancion);
        
        LDuracion = new JLabel ("Duracion:*");
        LDuracion.setBounds(30, 120, 100, 20);
        add(LDuracion);

        JTDuracion = new JTextField();
        JTDuracion.setBounds(140, 120, 150, 20);
        add(JTDuracion);
        
        BGuardar = new JButton("Guardar");
        BGuardar.setBounds(140, 150, 150, 20);
        BGuardar.addActionListener(this);
        add(BGuardar);
                  
    }
    
    public void actualizarArtista(String nombreArtista) {
        CBArtista.addItem(nombreArtista);
    }
    
    public void actualizarDisco(String nombreDisco) {
        CBDisco.addItem(nombreDisco);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(validarDatos()){
            cancion = new Cancion(JTNombreCancion.getText(), JTDuracion.getText());
            for (Artista artistaInd : ventana.getListaArtista()) {
                if(CBArtista.getSelectedItem().equals(artistaInd.getNombre())) {
                    for (Disco discoInd : artistaInd.getDisco()) {
                        if(CBDisco.getSelectedItem().equals(discoInd.getNombreDisco())) {
                            discoInd.getCancion().add(cancion);
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "Cancion Agregada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            vaciarDatos();
            
       }
    } 
    
    @Override
    public void itemStateChanged(ItemEvent e ) {
       CBDisco.removeAllItems();
       CBDisco.addItem("Seleccione...");
       for (Artista artistaInd : ventana.getListaArtista()) {
               if(CBArtista.getSelectedItem().equals(artistaInd.getNombre())) {
                    for (Disco disco1 : artistaInd.getDisco()) {
                        CBDisco.addItem(disco1.getNombreDisco());
                     }
                }
        }
   }
    
    private void vaciarDatos() {
        JTNombreCancion.setText("");
        JTDuracion.setText("");
        LNombreCancion.setForeground(Color.BLACK);
        CBArtista.setSelectedIndex(0);
        CBDisco.setSelectedIndex(0);
    }
    
    private boolean validarDatos() {
        if(JTNombreCancion.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LNombreCancion.setForeground(Color.red);
            return false;
        } else if(CBArtista.getSelectedItem() == ("Seleccione")) {
            JOptionPane.showMessageDialog(this, "Artista es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;        
        } else if(CBDisco.getSelectedItem() == ("Seleccione")) {
            JOptionPane.showMessageDialog(this, "Disco es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            return false;        
        }
        return true;
    }
}

