package recursos;

import menu.menu;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class recursosMenu extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldNombre;
    private JButton agregarButton;
    private JTable table1;
    private JList listaTurnos;

    private DefaultTableModel modelo;

    meseros meseros = recursos.meseros.obtenerInstancia();
    public recursosMenu() {
        setTitle("Menu Recursos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(512, 200);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        iniciarTabla();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        agregarButton.addActionListener(e -> {
            agregarMesero();
        });
    }

    public void iniciarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Turno");
        modelo.addColumn("Siguiente Nombre");
        Object[] listaMeseros = meseros.obtenerListaMeseros();
        for (Object mesero : listaMeseros) {
            Object[] fila = (Object[]) mesero;
            modelo.addRow(fila);
        }
        table1.setModel(modelo);
    }

    private void agregarMesero(){
        String nombre = textFieldNombre.getText();
        String turno = listaTurnos.getSelectedValue().toString();
        if(nombre.equals("") || turno.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor llena todos los campos", "Error al agrega mesero", JOptionPane.ERROR_MESSAGE);
            return;
        }
        meseros.agregarMesero(nombre, turno);
        iniciarTabla();
        textFieldNombre.setText("");
        listaTurnos.setSelectedIndex(0);
    }

    private void onOK() {
        menu menuPrincipal = new menu();
        menuPrincipal.setVisible(true);
        setVisible(false);
    }

    private void onCancel() {
        dispose();
        System.exit(0);
    }

    public static void main(String[] args) {
        recursosMenu dialog = new recursosMenu();
        dialog.pack();
        dialog.setVisible(true);
    }
}
