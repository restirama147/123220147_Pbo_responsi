/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Lab Informatika
 */
public class InputMahasiswa extends JFrame {

    ControllerMahasiswa controller;

    JLabel header = new JLabel("Input Mahasiswa");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNIM = new JLabel("NIM");
    JLabel labelInputAngkatan = new JLabel("Angkatan");
    JTextField inputNama = new JTextField();
    JTextField inputNIM = new JTextField();
    JTextField inputAngkatan = new JTextField();
    JButton tombolTambah = new JButton("Tambah Mahasiswa");
    JButton tombolKembali = new JButton("Kembali");

    public InputMahasiswa() {
        setTitle("Input Mahasiswa");
        setVisible(true);
        setSize(480, 240);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(header);
        add(labelInputNama);
        add(labelInputNIM);
        add(inputNama);
        add(inputNIM);
        add(tombolTambah);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNIM.setBounds(20, 96, 440, 24);
        inputNIM.setBounds(18, 120, 440, 36);
        labelInputAngkatan.setBounds(18, 144, 440, 24);
        inputAngkatan.setBounds(18, 168, 440, 24);
        tombolKembali.setBounds(20, 192, 215, 40);
        tombolTambah.setBounds(240, 232, 215, 40);

        controller = new ControllerMahasiswa(this);
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewMahasiswa();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertMahasiswa();
            }
        });
    }

    public String getInputNama() {
        return inputNama.getText();
    }

    public String getInputNIM() {
        return inputNIM.getText();
    }

    public String getInputAngkatan() {
        return inputAngkatan.getText();
    }
}
