/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Lab Informatika
 */
public class LoginPage extends JFrame implements ActionListener{

    JLabel header = new JLabel("Selamat Datang!");
    JLabel subheader = new JLabel("Silakan masuk untuk melanjutkan.");
    JLabel labelUsername = new JLabel("Username");
    JLabel labelPassword = new JLabel("Password");

    JTextField inputUsername = new JTextField();
    JTextField inputPassword = new JTextField();

    JButton tombolLogin = new JButton("Login");
    public LoginPage() {
        setVisible(true);
        setSize(480, 480);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(header);
        add(subheader);
        add(labelUsername);
        add(labelPassword);
        add(inputUsername);
        add(inputPassword);
       
        add(tombolLogin);
        
        header.setFont (header.getFont().deriveFont (20.0f));
        header.setBounds(20, 20, 440, 24);
        subheader.setBounds(20, 50, 440, 12);
        
        labelUsername.setBounds(20, 84, 440, 12);
        inputUsername.setBounds(18, 100, 440, 32);
        
        labelPassword.setBounds(20, 150, 440, 12);
        inputPassword.setBounds(18, 166, 440, 32);
        
        tombolLogin.setBounds(14, 280, 452, 36);
         tombolLogin.addActionListener(this);
    }
      public void actionPerformed(ActionEvent e) {
        try {
            String username = inputUsername.getText();
            String password = inputPassword.getText();
            
            if (username.isEmpty() || password.isEmpty()) {
                throw new Exception("Input Data!");
            }
          
            new Home();
            
            this.dispose();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}
