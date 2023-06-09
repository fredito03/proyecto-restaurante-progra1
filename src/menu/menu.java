package menu;

import estado.estadoMenu;
import ingresos.ingresosMenu;
import recursos.recursosMenu;

import javax.swing.*;
import java.awt.event.*;

public class menu extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private JButton ingresosButton;
    private JButton recursosButton;
    private JButton estadoButton;

    public menu() {
        setTitle("Menu Principal");
        setMinimumSize(new java.awt.Dimension(500, 400));
        setLocation(512, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

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

        ingresosButton.addActionListener(e -> {
            ingresosMenu ingresosMenu = new ingresosMenu();
            ingresosMenu.setVisible(true);
            dispose();
        });
        recursosButton.addActionListener(e -> {
            recursosMenu recursosMenu = new recursosMenu();
            recursosMenu.setVisible(true);
            dispose();
        });


        estadoButton.addActionListener(e -> {
            estadoMenu estadoMenu = new estadoMenu();
            estadoMenu.setVisible(true);
            dispose();
        });

    }

    private void onOK() {

        dispose();
        System.exit(0);
    }

    private void onCancel() {
        dispose();
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            menu frame = new menu();
            frame.pack();
            frame.setVisible(true);
        });
    }
}
