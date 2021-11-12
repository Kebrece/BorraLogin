package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField userText;
    private JPasswordField pwdField;
    private JButton loginBTN;
    private JButton salirBTN;
    private JPanel principal;

    public LoginForm()
    {
        setTitle("Ventana Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addComponents(getContentPane());
        setVisible(true);
    }

    private void addComponents(Container contentPane)
    {
        contentPane.add(principal);
    }

    public String getUser() {
        return userText.getText();
    }

    public String getPwdField() {
        return String.valueOf(pwdField.getPassword());
    }

    public void addListener(ActionListener al)
    {
        loginBTN.addActionListener(al);
        salirBTN.addActionListener(al);
    }

    public void showMessage(String s)
    {
        JOptionPane.showMessageDialog(this, s, "Sistema de LOGIN", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String s) {
        JOptionPane.showMessageDialog(this, s, "Sistema LOGIN - ERROR", JOptionPane.ERROR_MESSAGE);
    }
    public int yesNoMessage(String s)
    {
        return JOptionPane.showConfirmDialog(this, s, "Sistema LOGIN", JOptionPane.YES_NO_OPTION);
    }

    public void salir()
    {
        System.exit(0);
    }

    }

