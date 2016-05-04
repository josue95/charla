/*
 * Cambia tipo de moneda
 */
package ejer1_alumnos;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaBúsqueda extends JFrame implements ActionListener, WindowListener {

    JPanel contenedor;
    JButton botonAlta, botonFin;
    JTextField nombre;
    JLabel etiquetaNombre;
    DataBase db;

    public VentanaBúsqueda(DataBase db) {
        //El título lo recibirá como parámetro para dar de alta alumnos o profesores
        this.db = db;
        this.setTitle("Busca Alumno");
        this.setVisible(true);
        initComponents();
        this.pack();
        this.setSize(300, 150);
    }

    private void initComponents() {
        //Utilizo todo el fondo del JFrame
        contenedor = (JPanel) this.getContentPane();
        //Inicializo un layout
        contenedor.setLayout(new GridLayout(2, 2, 5, 5));
        //Inicializo los objetos
        etiquetaNombre = new JLabel("Nombre: ");
        nombre = new JTextField();
        botonAlta = new JButton("Busca");
        botonAlta.addActionListener(this);
        botonAlta.setActionCommand("busca");
        botonFin = new JButton("Fin");
        botonFin.addActionListener(this);
        botonFin.setActionCommand("fin");
        //los pongo en el contendor
        contenedor.add(etiquetaNombre);
        contenedor.add(nombre);
        contenedor.add(botonAlta);
        contenedor.add(botonFin);
    }

    private void limpiaPantalla() {
        nombre.setText(null);
    }

    private void ventanaError(String cadena) {
        JOptionPane.showMessageDialog(
                this, cadena,
                "Error", JOptionPane.INFORMATION_MESSAGE);
    }

    private void busca() {
        //le pasamos al método de la base de datos el nombre a buscar
        if (!db.buscaRegistro(nombre.getText())) {
            ventanaError("Registro no encontrado");
        } else {
            limpiaPantalla();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "busca":
                busca();
                break;
            default:
                this.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
       
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {       
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
