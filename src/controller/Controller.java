package controller;

import data.SQLExecutor;
import view.LoginForm;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller
{
    private LoginForm ventana;
    private SQLExecutor executor;

    public Controller()
    {
        ventana = new LoginForm();
        ventana.addListener(new ButtonListener());
    }

    private void procesoSalir()
    {
        if(ventana.yesNoMessage("Esta seguro que desea salir")== JOptionPane.YES_OPTION)
        {
            ventana.salir();
        }
    }

    private void procesoLogin()
    {
        String user, password;
        user = ventana.getUser();
        password = ventana.getPwdField();
        if(user.equals("")&&password.equals(""))
        {
            ventana.showErrorMessage("Debe especificar un usuario y clave!");
        }
        else
            try
            {
                executor = new SQLExecutor(user, password);
                ResultSet rs = executor.ejecutaQuery("SELECT * FROM CURSO.dbo.PERSONA");
                rs.next();
               String cadena = "Conexion exitosa! \n Datos de prueba: ";
                cadena += rs.getString("CEDULA");
                cadena += "   ";
                cadena += rs.getString("NOMBRE");
                ventana.showMessage(cadena);
            }catch (SQLException throwables)
            {
                ventana.showErrorMessage(throwables.getMessage());
            }
    }
    private class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            String valor = e.getActionCommand();
            switch (valor)
            {
                case "login":
                    procesoLogin();
                    break;
                case "salir":
                    procesoSalir();
                    break;
            }

        }
    }

}
