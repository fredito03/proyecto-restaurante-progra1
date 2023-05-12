package menu;

import javax.swing.*;
import java.awt.event.*;

public class menu extends JDialog {
    private final controlador controlador = new controlador();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private JButton ingresosButton;
    private JButton recursosButton;
    private JButton estadoButton;

    public menu() {
        setContentPane(contentPane);
        setModal(true);
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

        ingresosButton.addActionListener(e -> controlador.controladorIngresos());
        recursosButton.addActionListener(e -> System.out.println("Hola estoy en recursos"));
        estadoButton.addActionListener(e -> controlador.controladorEstado());
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        menu dialog = new menu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
