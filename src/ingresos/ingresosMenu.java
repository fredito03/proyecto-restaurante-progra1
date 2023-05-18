package ingresos;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import menu.menu;

public class ingresosMenu extends JFrame{
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private JButton agregarButton;
    private JTextField textField1;
    private JTable table1;
    private DefaultTableModel modelo;

    productos productos = ingresos.productos.getSingletonInstance();

    public ingresosMenu() {
        setTitle("Menu de ingresos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        setLocation(512, 200);
        setMinimumSize(new java.awt.Dimension(500, 400));
        getRootPane().setDefaultButton(buttonOK);
        iniciarBotones();
        iniciarTabla();
        iniciarBotonesDeAccion();
    }

    public void iniciarBotones(){
        list1.addListSelectionListener(e -> {
            String productoSeleccionado = list1.getSelectedValue() != null ? list1.getSelectedValue().toString() : "";
            textField1.setText(productoSeleccionado);
        });

        agregarButton.addActionListener(e -> {
            agregarProducto(list1.getSelectedIndex(), list1.getSelectedValue());
        });
    }

    public void iniciarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        table1.setModel(modelo);
    }

    public void iniciarBotonesDeAccion(){
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regresarAMenuPrincipal();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
    }

    public void agregarProducto(int id, Object nombre) {
        boolean hayalgunProductoSeleccionado = list1.isSelectionEmpty();
        if(!hayalgunProductoSeleccionado){
            productos.agregarProducto(id);
            Object[] fila = {id, nombre};
            modelo.addRow(fila);
            textField1.setText("");
            list1.clearSelection();
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un item de la lista");
        }
    }

    private void regresarAMenuPrincipal() {
        menu menuPrincipal = new menu();
        menuPrincipal.setVisible(true);
        setVisible(false);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
        System.exit(0);
    }

    // create method to close current window


    public static void main(String[] args) {
        ingresosMenu frame = new ingresosMenu();
        frame.pack();
        frame.setVisible(true);
    }

}
