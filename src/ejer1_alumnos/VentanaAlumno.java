/*
 * Cambia tipo de moneda
 */
package ejer1_alumnos;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaAlumno extends JFrame implements ActionListener, WindowListener {

    JPanel contenedor;
    JButton botonAlta, botonFin;
    JTextField nombre, telefono;
    JLabel etiquetaNombre, etiquetaTelefono;
    DataBase db;

    public VentanaAlumno(DataBase db) {
        //El título lo recibirá como parámetro para dar de alta alumnos o profesores
        this.db = db;
        this.setTitle("Alta Alumno");
        this.setVisible(true);
        initComponents();
        this.pack();
        this.setSize(300, 300);
    }

    private void initComponents() {
        //Utilizo todo el fondo del JFrame
        contenedor = (JPanel) this.getContentPane();
        //Inicializo un layout
        contenedor.setLayout(new GridLayout(4, 2, 5, 5));
        //Inicializo los objetos
        etiquetaNombre = new JLabel("Nombre: ");
        nombre = new JTextField();
        etiquetaTelefono = new JLabel("Telefono: ");
        telefono = new JTextField();
        botonAlta = new JButton("Alta");
        botonAlta.addActionListener(this);
        botonAlta.setActionCommand("alta");
        botonFin = new JButton("Fin");
        botonFin.addActionListener(this);
        botonFin.setActionCommand("fin");
        //los pongo en el contendor
        contenedor.add(etiquetaNombre);
        contenedor.add(nombre);
        contenedor.add(etiquetaTelefono);
        contenedor.add(telefono);
        contenedor.add(botonAlta);
        contenedor.add(botonFin);
    }

    private void limpiaPantalla() {
        nombre.setText(null);
        telefono.setText(null);
    }

    private void ventanaError(String cadena) {
        JOptionPane.showMessageDialog(
                this, cadena,
                "Error", JOptionPane.INFORMATION_MESSAGE);
    }

    private void alta() {
        //Creo un objeto de la clase persona, pero lo instancio como
        //alumno, de esta manero
        if (compruebaCadena20(nombre.getText())) {
            if (compruebaCadena20(telefono.getText())) {
                //lo guardo en la base de datos
                String cadena="INSERT INTO alumnos (nombre, telefono) VALUES ('" + 
                        nombre.getText() + "',  '" + telefono.getText()+"')";
                db.ejecutaUpdate(cadena);
            } else {
                ventanaError("El teléfono tiene que tener entre 1 y 20 car.");
            }
        } else {
            ventanaError("El nombre tiene que tener entre 1 y 20 car.");
        }
        limpiaPantalla();
    }

    private boolean compruebaCadena20(String cadena) {
        return cadena.length() > 0 && cadena.length() <= 20;
    }
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "alta":
                alta();
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
