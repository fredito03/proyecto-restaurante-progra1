package estado;

import menu.menu;

import javax.swing.*;
import java.awt.event.*;

public class estadoMenu extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private JTable table2;
    private JTable table3;

        public estadoMenu() {
        setTitle("Menu Estado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(512, 200);
        setMinimumSize(new java.awt.Dimension(500, 400));
        iniciarBotonesDeAccion();
        }

        {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
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
