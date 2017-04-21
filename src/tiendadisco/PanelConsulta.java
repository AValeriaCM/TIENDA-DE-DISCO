/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendadisco;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angie Castañeda
 */
public class PanelConsulta extends JDialog{
    
    JPanel panel;
    JTable tablaArtista;
    
    private DefaultTableModel dtm;
    private PanelBotones ventana;
    
    public PanelConsulta(PanelBotones ventana) {
        this.ventana = ventana;
        setSize(300, 300);
        setTitle("CONSULTA ARTISTA");
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("ARTISTAS"));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);
        
        dtm = new DefaultTableModel();
        tablaArtista = new JTable(dtm);
        
        Object[] columna = {"Nombre", "Genero", "Nacionalidad"};
        for (Object columna1 : columna) {
            dtm.addColumn(columna1);
        }        
        
        
        JScrollPane scrollPane = new JScrollPane(tablaArtista);
        scrollPane.setBounds(30, 30, 240, 50);
        panel.add(scrollPane);
    }
    
    public void actualizarTabla() {
         List<Artista> lista = this.ventana.getListaArtista();
         for (Artista artista : lista) {
             Object[] fila = {artista.getNombre(), artista.getGenero().toString(), artista.getNacionalidad().toString()};
             dtm.addRow(fila);
        }
    }

}
