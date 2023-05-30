package estado;

import menu.menu;
import recursos.meseros;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class estadoMenu extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private DefaultTableModel modeloMeseros;
    private JTable table2;
    private DefaultTableModel modeloPilaDeProductos;
    private JTable table3;
    private DefaultTableModel modeloColaDeProductos;


    recursos.meseros meseros = recursos.meseros.obtenerInstancia();
    ingresos.productos productos = ingresos.productos.obtenerInstancia();


    public estadoMenu() {
        setTitle("Menu Estado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(512, 200);
        setMinimumSize(new java.awt.Dimension(500, 400));
        iniciarBotonesDeAccion();
        iniciarTablas();
    }

    {
    setContentPane(contentPane);
    getRootPane().setDefaultButton(buttonOK);
    }

    public void iniciarTablas(){
        iniciarTablaMeseros();
        iniciarTablaPilaDeProductos();
        iniciarTablaColaDeProductos();
    }
    public void iniciarTablaMeseros(){
        modeloMeseros = new DefaultTableModel();
        modeloMeseros.addColumn("Nombre");
        modeloMeseros.addColumn("Turno");
        modeloMeseros.addColumn("Siguiente Nombre");
        Object[] listaMeseros = meseros.obtenerListaMeseros();
        for (Object mesero : listaMeseros) {
            Object[] fila = (Object[]) mesero;
            modeloMeseros.addRow(fila);
        }
        table1.setModel(modeloMeseros);
    }
    public void iniciarTablaPilaDeProductos(){
        Object[] listaProductos = productos.obtenerProductosDePila();
        modeloPilaDeProductos = new DefaultTableModel();
        modeloPilaDeProductos.addColumn("Id");
        modeloPilaDeProductos.addColumn("Nombre");
        for (Object producto : listaProductos) {
            Object[] fila = (Object[]) producto;
            modeloPilaDeProductos.addRow(fila);
        }
        table2.setModel(modeloPilaDeProductos);
    }
    public void iniciarTablaColaDeProductos(){
        Object[] listaProductos = productos.obtenerProductosDeCola();
        modeloColaDeProductos = new DefaultTableModel();
        modeloColaDeProductos.addColumn("Id");
        modeloColaDeProductos.addColumn("Nombre");
        for (Object producto : listaProductos) {
            Object[] fila = (Object[]) producto;
            modeloColaDeProductos.addRow(fila);
        }
        table3.setModel(modeloColaDeProductos);
    }

   public void iniciarBotonesDeAccion(){
       // Inicializa los botones de cancelar y ok de la ventana
    buttonOK.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) { regresarAMenuPrincipal(); }
    });

    buttonCancel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) { onCancel(); }
    });
        }

    private void regresarAMenuPrincipal() {
    menu MenuPrincipal = new menu();
    MenuPrincipal.setVisible(true);
    setVisible(false);
     }

    private void onCancel() {
    dispose();
     }

    public static void main(String[] args) {
        estadoMenu dialog = new estadoMenu();
        dialog.pack();
        dialog.setVisible(true);
    }
}
