package ingresos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class ingresosMenu extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private JButton agregarButton;
    private JTextField textField1;
    private JTable table1;

    public ingresosMenu() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        final int[] menuSeleccionado = {0};
        controlador controlador = new controlador();

        list1.addListSelectionListener(e -> {
            textField1.setText(list1.getSelectedValue().toString());
            menuSeleccionado[0] = list1.getSelectedIndex();
        });

        agregarButton.addActionListener(e -> {
            controlador.agregaMenu(menuSeleccionado[0]);
        });


        // Default
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
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
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
        ingresosMenu dialog = new ingresosMenu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
