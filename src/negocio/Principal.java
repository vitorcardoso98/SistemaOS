/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import telas.TelaPrincipal;

/**
 *
 * @author JOÃO VITOR
 */
public class Principal {

    public static void main(String[] args) {
        lookAndFeel();
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        tela.setExtendedState(MAXIMIZED_BOTH);
    }

    private static void lookAndFeel() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
