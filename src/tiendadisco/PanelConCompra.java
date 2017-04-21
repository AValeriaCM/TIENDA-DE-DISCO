/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendadisco;

import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angie Castañeda
 */
public class PanelConCompra extends JDialog{
    
    JPanel panel;
    JTable tablaClientes;
    
    private final DefaultTableModel tabla;
    private final PanelBotones ventana;
    private Artista artista;
    
    public PanelConCompra(PanelBotones ventana) {
        this.ventana = ventana;
        setSize(300, 300);
        setTitle("TOTAL COMPRAS");
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("COMPRAS"));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);
        
        tabla = new DefaultTableModel();
        tablaClientes = new JTable(tabla);
        
        Object[] columna = {"Nombre", "Cedula", "Total"};
        for (Object columna1 : columna) {
            tabla.addColumn(columna1);
        }        
        
        
        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        scrollPane.setBounds(30, 30, 240, 50);
        panel.add(scrollPane);
    }
    
    public void actualizarTabla() {
         List<Cliente> lista = this.ventana.getListaCliente();
         for (Cliente cliente : lista) {
             Object[] fila = {cliente.getNombre(), cliente.getCedula()};
             tabla.addRow(fila);
        }
    }

}
