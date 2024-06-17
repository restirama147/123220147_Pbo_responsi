/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Lab Informatika
 */
public class Home extends JFrame {

    JLabel header = new JLabel();
    JLabel subHeader = new JLabel("Silahkan Pilih Untuk melanjutkan");
    JButton tombolMahasiswa = new JButton("Menu Mahasiswa");
    JButton tombolDosen = new JButton("Menu Dosen");
    JButton tombolKembali = new JButton("LogOut");

    public Home() {
        
        setVisible(true);
        setSize(480, 480);
        setTitle("Halaman Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        add(header);
        add(subHeader);
        add(tombolMahasiswa);
        add(tombolDosen);
        add(tombolKembali);

        header.setBounds(20, 12, 440, 36);
        tombolDosen.setBounds(80, 70, 320, 40);
        tombolMahasiswa.setBounds(80, 115, 320, 40);
        tombolKembali.setBounds(80, 160, 320, 40);

        header.setText("Selamat datang, " );
        header.setFont(header.getFont().deriveFont(20.0f));
        header.setBounds(20, 20, 440, 24);

        subHeader.setBounds(20, 50, 440, 16);

        tombolMahasiswa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new View.Mahasiswa.ViewMahasiswa();
            }
        });
        tombolDosen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new View.Dosen.ViewDosen();
            }
        });
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage();
            }
        });
    }

}
