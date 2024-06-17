/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Dosen;

import Controller.ControllerDosen;
import Model.Dosen.ModelDosen;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Lab Informatika
 */
public class EditDosen extends JFrame {

    ControllerDosen controller;

    JLabel header = new JLabel("Edit Dosen");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNo_Hp = new JLabel("No HP");
    JLabel labelInputEmail = new JLabel("Email");
    JTextField inputNama = new JTextField();
    JTextField inputNo_Hp = new JTextField();
    JTextField inputEmail = new JTextField();
    JButton tombolEdit = new JButton("Edit Dosen");
    JButton tombolKembali = new JButton("Kembali");

    public EditDosen(ModelDosen dosen) {
        setTitle("Edit Dosen");
        setVisible(true);
        setSize(480, 240);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(header);
        add(labelInputNama);
        add(labelInputNo_Hp);
        add(inputNama);
        add(inputNo_Hp);
        add(inputEmail);
        add(tombolEdit);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNo_Hp.setBounds(20, 96, 440, 24);
        inputNo_Hp.setBounds(18, 120, 440, 36);
        labelInputEmail.setBounds(18, 144, 440, 24);
        inputEmail.setBounds(18, 168, 440, 24);
        tombolKembali.setBounds(20, 192, 215, 40);
        tombolEdit.setBounds(240, 232, 215, 40);

        // Masukkin nama dan nidn yang didapat dari halaman sebelumnya.
        inputNama.setText(dosen.getNama());
        inputNo_Hp.setText(dosen.getNo_hp());
        inputEmail.setText(dosen.getEmail());
        controller = new ControllerDosen(this);

        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDosen();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.editDosen(dosen.getId());
            }
        });
    }

    public String getInputNama() {
        return inputNama.getText();
    }

    public String getInputNo_hp() {
        return inputNo_Hp.getText();
    }

    public String getInputEmail() {
        return inputEmail.getText();
    }   
}
