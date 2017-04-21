/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendadisco;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Angie Castañeda
 */
public class PanelBotones extends JPanel implements ActionListener{
    private final JButton btnArtista;
    private final JButton btnDisco;
    private final JButton btnCancion;
    private final JButton btnConsulta;
    private final JButton btnCompra;
    private final JButton btnConsultaCompra;

    
    public static final String BTN_ARTISTA = "ARTISTA";
    private static final String BTN_DISCO= "DISCO";
    private static final String BTN_CANCION = "CANCION";
    public static final String BTN_CONSULTA = "CONSULTA";
    public static final String BTN_COMPRA = "COMPRA";
    public static final String BTN_CONSULTACOMPRA = "CONSULTA COMPRA";
    
    private Principal principal;
    private List<Artista> listaArtista;
    private List<Cliente> listaCliente;
    
    public PanelBotones(Principal principal){
        this.principal=principal;
        setBackground(Color.WHITE);
        setLayout(new GridLayout(6, 1));
        
        listaArtista = new ArrayList<Artista>();
        listaCliente = new ArrayList<Cliente>();
        
        btnArtista = new JButton ("Crear Artista");
        btnArtista.addActionListener((ActionListener) this);
        btnArtista.setActionCommand(BTN_ARTISTA);
        //btnArtista.setBounds(10, 340, 10, 100);
        add(btnArtista);

        
        btnDisco = new JButton ("Crear Disco");
        btnDisco.addActionListener((ActionListener) this);
        btnDisco.setActionCommand(BTN_DISCO);
        //btnArtista.setBounds(4, 10, 20, 10);
        add(btnDisco);
        
        btnCancion = new JButton ("Crear Canción");
        btnCancion.addActionListener((ActionListener) this);
        btnCancion.setActionCommand(BTN_CANCION);
        //btnArtista.setBounds(2, 10, 24, 10);
        add(btnCancion);
        
        btnConsulta = new JButton ("Consultar Artista");
        btnConsulta.addActionListener((ActionListener) this);
        btnConsulta.setActionCommand(BTN_CONSULTA);
        //btnArtista.setBounds(2, 10, 28, 10);
        add(btnConsulta);
        
        btnCompra = new JButton ("Generar Compra");
        btnCompra.addActionListener((ActionListener) this);
        btnCompra.setActionCommand(BTN_COMPRA);
        //btnArtista.setBounds(2, 10, 32, 10);
        add(btnCompra);
        
        btnConsultaCompra = new JButton ("Consultar Compras");
        btnConsultaCompra.addActionListener((ActionListener) this);
        btnConsultaCompra.setActionCommand(BTN_CONSULTACOMPRA);
        //btnArtista.setBounds(2, 10, 32, 10);
        add(btnConsultaCompra);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
           if(BTN_ARTISTA.equals(e.getActionCommand())){
              PanelArtista artista1 = new PanelArtista(this);
              artista1.setVisible(true);
            }
           else if (BTN_DISCO.equals(e.getActionCommand())){
              PanelDisco disco1 = new PanelDisco(this);
              disco1.setVisible(true);
            }
           else if (BTN_CANCION.equals(e.getActionCommand())){
              PanelCancion cancion1 = new PanelCancion(this);
              cancion1.setVisible(true);
              
           }
           else if (BTN_CONSULTA.equals(e.getActionCommand())){
              PanelConsulta consulta1 = new PanelConsulta(this);
              consulta1.actualizarTabla();
              consulta1.setVisible(true);
           }
           else if (BTN_COMPRA.equals(e.getActionCommand())){
               PanelCompra compra1 = new PanelCompra(this);
               compra1.setVisible(true);
           }
           else if (BTN_CONSULTACOMPRA.equals(e.getActionCommand())){
              PanelConCompra consulta1 = new PanelConCompra(this);
              consulta1.actualizarTabla();
              consulta1.setVisible(true);
           }
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
    
}
